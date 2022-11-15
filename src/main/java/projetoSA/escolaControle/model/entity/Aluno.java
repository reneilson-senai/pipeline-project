package projetoSA.escolaControle.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import projetoSA.escolaControle.model.DTO.AlunoDTO;

@Entity
public class Aluno {

	@Id
	@SequenceGenerator(name = "alunoGenerator", sequenceName = "ALUNO_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alunoGenerator")
	@Column(name = "ALUNOID")
	private Integer idAluno;
	
	private String nomeAluno;
	private String responsavelContato;
	private boolean permissaoSairSozinho;
	private String observacoesAdicionais;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ALUNOID", referencedColumnName = "ALUNOID")
	private List<Relatorio> relatorioAluno;
	
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name = "TURMAID")
	@JsonBackReference
	private Turma turmaAno;	
	
	public Aluno() {}

	public Aluno(Integer idAluno, String nomeAluno,
			String responsavelContato, boolean permissaoSairSozinho,
			String observacoesAdicionais, List<Relatorio> relatorioAluno, Turma turmaAno) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.responsavelContato = responsavelContato;
		this.permissaoSairSozinho = permissaoSairSozinho;
		this.observacoesAdicionais = observacoesAdicionais;
		this.relatorioAluno = relatorioAluno;
		this.turmaAno = turmaAno;
	}
	
	public Aluno(Integer idAluno, AlunoDTO alunoDTO) {
		super();
		this.nomeAluno = alunoDTO.getNomeAluno();
		this.responsavelContato = alunoDTO.getResponsavelContato();
		this.permissaoSairSozinho = alunoDTO.isPermissaoSairSozinho();
		this.observacoesAdicionais = alunoDTO.getObservacoesAdicionais();
	}
	
	public Turma getTurmaAno() {
		return turmaAno;
	}
	public void setTurmaAno(Turma turmaAno) {
		this.turmaAno = turmaAno;
	}
	public Integer getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}
	public String getObservacoesAdicionais() {
		return observacoesAdicionais;
	}
	public void setObservacoesAdicionais(String observacoesAdicionais) {
		this.observacoesAdicionais = observacoesAdicionais;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getResponsavelContato() {
		return responsavelContato;
	}
	public void setResponsavelContato(String responsavelContato) {
		this.responsavelContato = responsavelContato;
	}
	public boolean isPermissaoSairSozinho() {
		return permissaoSairSozinho;
	}
	public void setPermissaoSairSozinho(boolean permissaoSairSozinho) {
		this.permissaoSairSozinho = permissaoSairSozinho;
	}
}
