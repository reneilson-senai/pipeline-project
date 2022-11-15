package projetoSA.escolaControle.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import java.time.LocalDateTime;

@Entity
public class Relatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RELATORIOID")
	private Integer idRelatorio;
	private LocalDateTime momentoDataHora;
	private String nomeAcompanhado;
	
	@ManyToOne
	@JoinColumn(name = "ALUNOID")
	private Aluno aluno;
	
	public Relatorio() {}
	
	public Relatorio(Integer idRelatorio, LocalDateTime momentoDataHora, String nomeAcompanhado) {
		this.idRelatorio = idRelatorio;
		this.momentoDataHora = momentoDataHora;
		this.nomeAcompanhado = nomeAcompanhado;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Integer getIdRelatorio() {
		return idRelatorio;
	}
	public void setIdRelatorio(Integer idRelatorio) {
		this.idRelatorio = idRelatorio;
	}
	public LocalDateTime getMomentoDataHora() {
		return momentoDataHora;
	}
	public void setMomentoDataHora(LocalDateTime momentoDataHora) {
		this.momentoDataHora = momentoDataHora;
	}
	public String getNomeAcompanhado() {
		return nomeAcompanhado;
	}
	public void setNomeAcompanhado(String nomeAcompanhado) {
		this.nomeAcompanhado = nomeAcompanhado;
	}
}
