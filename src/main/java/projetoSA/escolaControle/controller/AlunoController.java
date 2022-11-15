package projetoSA.escolaControle.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoSA.escolaControle.model.DTO.AlunoDTO;
import projetoSA.escolaControle.model.entity.Aluno;
import projetoSA.escolaControle.model.entity.Relatorio;
import projetoSA.escolaControle.service.AlunoService;
import projetoSA.escolaControle.service.RelatorioService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AlunoDTO>> listarAluno() {
		return new ResponseEntity<>(alunoService.procurarAlunos(), HttpStatus.OK);
	}
	
	/*
	@GetMapping(path = "por-nome/{nomeAluno}")
	public ResponseEntity<List<Aluno>> listarAlunoPorNome(@PathVariable(required = false) String nomeAluno) {
		if(nomeAluno != null && !nomeAluno.isEmpty()) {
			return new ResponseEntity<>(alunoService.procurarAlunoPorNome(nomeAluno), HttpStatus.OK);
		}
		return new ResponseEntity<>(alunoService.procurarAlunos(), HttpStatus.OK);
	}
	*/

	@GetMapping(path = "/{idAluno}")
	public ResponseEntity<AlunoDTO> listarAluno(@PathVariable Integer idAluno){
		AlunoDTO dto = alunoService.procurarAlunoPorId(idAluno);
		if(dto != null) {
			return new ResponseEntity<>(alunoService.procurarAlunoPorId(idAluno), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno){
		try {
			alunoService.salvarAluno(aluno);
			return new ResponseEntity<>(aluno, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@PutMapping(path = "/{idAluno}")
	public ResponseEntity<Void> editarAluno(@RequestBody Aluno aluno, @PathVariable Integer idAluno){
		try {
			aluno.setIdAluno(idAluno);
			if(alunoService.alunoExiste(idAluno)) {
				alunoService.salvarAluno(aluno);
				return new ResponseEntity<>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping(path = "/{idAluno}")
	public ResponseEntity<Void> excluirAluno(@PathVariable Integer idAluno){
		alunoService.excluirAluno(idAluno);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/*Controller para Relatorio */
	
	@GetMapping(path = "/{idAluno}/relatorio")
	public ResponseEntity<List<Relatorio>> listarRelatorios(@PathVariable Integer idAluno) {
		return new ResponseEntity<>(relatorioService.listarRelatorios(idAluno), HttpStatus.OK);
	}
	
	@PostMapping(path = "/{idAluno}/relatorio", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Relatorio> salvarRelatorio(@RequestBody Relatorio relatorio, @PathVariable Integer idAluno){
		try {
			Optional<Aluno> aluno = alunoService.procurarAlunoPorIdParaRelatorio(idAluno);
			if (aluno.isPresent()) {
				relatorio.setAluno(aluno.get());
				relatorio.setMomentoDataHora(LocalDateTime.now());
				relatorioService.salvarRelatorio(relatorio);
				return new ResponseEntity<>(relatorio, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping(path = "/{idAluno}/relatorio/{idRelatorio}")
	public ResponseEntity<Void> excluirRelatorio(@PathVariable Integer idAluno, @PathVariable Integer idRelatorio){
		try {
			boolean relatorio = relatorioService.existeRelatorio(idRelatorio, idAluno);
			if(relatorio == true ) {
				relatorioService.excluirRelatorio(idRelatorio);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}







