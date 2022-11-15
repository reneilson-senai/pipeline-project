package projetoSA.escolaControle.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import projetoSA.escolaControle.model.DTO.TurmaDTO;
import projetoSA.escolaControle.model.entity.Turma;
import projetoSA.escolaControle.repository.TurmaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public Turma salvarTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public void editarTurma(Turma turma) {
		if (turmaRepository.findById(turma.getIdTurma()).isPresent()) {
			turmaRepository.save(turma);
		}
	}
	public List<TurmaDTO> procurarTurma() {
		List<Turma> turmas = turmaRepository.findAll();
		List<TurmaDTO> turmasDTO = new ArrayList<>();
		for(Turma i : turmas) {
			TurmaDTO turmaDTO = new TurmaDTO(i.getAnoTurma(), i.getIdTurma(), i.getPeriodoTurma());
			turmasDTO.add(turmaDTO);
		}
		return turmasDTO;
	}
	
	public Optional<Turma> pegarTurmaId(Integer idTurma) {
		return turmaRepository.findById(idTurma);
	}
	
	public void excluirTurma(Integer idTurma) {
		turmaRepository.deleteById(idTurma);
	}
}
