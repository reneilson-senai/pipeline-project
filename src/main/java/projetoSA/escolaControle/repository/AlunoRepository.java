package projetoSA.escolaControle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoSA.escolaControle.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	List<Aluno> findByNomeAlunoLike(String nomeAluno);
}
