package projetoSA.escolaControle.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

//import projetoSA.escolaControle.model.DTO.RelatorioDTO;
import projetoSA.escolaControle.model.entity.Relatorio;
import projetoSA.escolaControle.repository.RelatorioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioService {

	@Autowired
	private RelatorioRepository relatorioRepository;
	
	public Relatorio salvarRelatorio(Relatorio relatorio) {
		return relatorioRepository.save(relatorio);
	}
	
	public List<Relatorio> listarRelatorios(Integer idAluno) {
		return relatorioRepository.findByAlunoIdAluno(idAluno);
	}
	
	public boolean existeRelatorio(Integer idRelatorio, Integer idAluno) {
		Optional<Relatorio> relatorio = relatorioRepository.findById(idRelatorio);
		if(relatorio.isPresent() && relatorio.get().getAluno().getIdAluno() == idAluno) {
			return true;
		} return false;
		
	}
	
	public void excluirRelatorio(Integer idRelatorio) {
		relatorioRepository.deleteById(idRelatorio);
	}
}
