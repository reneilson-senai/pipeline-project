package projetoSA.escolaControle.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TURMAID")
	private Integer idTurma;
	
	@Column(name = "ANOTURMA")
	private Integer anoTurma; 
	private String periodoTurma;
	
	@OneToMany(mappedBy = "turmaAno", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Aluno> alunos;
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public Integer getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}
	public Integer getAnoTurma() {
		return anoTurma;
	}
	public void setAnoTurma(Integer anoTurma) {
		this.anoTurma = anoTurma;
	}
	public String getPeriodoTurma() {
		return periodoTurma;
	}
	public void setPeriodoTurma(String periodoTurma) {
		this.periodoTurma = periodoTurma;
	}
}
