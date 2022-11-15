package projetoSA.escolaControle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoSA.escolaControle.model.entity.Relatorio;

import java.util.List;

public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {

	List<Relatorio> findByAlunoIdAluno(Integer idAluno);
}
