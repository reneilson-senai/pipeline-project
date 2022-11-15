package projetoSA.escolaControle.controller;

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

import projetoSA.escolaControle.model.DTO.TurmaDTO;
import projetoSA.escolaControle.model.entity.Turma;
import projetoSA.escolaControle.service.TurmaService;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TurmaDTO>> listarTurma() {
		return new ResponseEntity<>(turmaService.procurarTurma(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{idTurma}")
	public ResponseEntity<Optional<Turma>> listarAlunos(@PathVariable Integer idTurma){
		return new ResponseEntity<>(turmaService.pegarTurmaId(idTurma), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Turma> salvarTurma(@RequestBody Turma turma){
		try {
			Turma novaTurma = turmaService.salvarTurma(turma);
			return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@PutMapping(path = "{idTurma}")
	public ResponseEntity<Void> editarTurma(@RequestBody Turma turma, @PathVariable Integer idTurma) {
		try {
			turma.setIdTurma(idTurma);
			turmaService.editarTurma(turma);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping(path = "/{idTurma}")
	public ResponseEntity<Void> excluirTurma(@PathVariable Integer idTurma){
		turmaService.excluirTurma(idTurma);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
