package projetoSA.escolaControle.model.DTO;

import projetoSA.escolaControle.model.entity.Aluno;

public class AlunoDTO {

	private Integer idAluno;
	private String nomeAluno;
	private String responsavelContato;
	private boolean permissaoSairSozinho;
	private String observacoesAdicionais;
	private Integer anoTurma;
	
	public AlunoDTO() {}
	
	public AlunoDTO(Integer idAluno, String nomeAluno,
			String responsavelContato, boolean permissaoSairSozinho,
			String observacoesAdicionais, Integer anoTurma) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.responsavelContato = responsavelContato;
		this.permissaoSairSozinho = permissaoSairSozinho;
		this.observacoesAdicionais = observacoesAdicionais;
		this.anoTurma = anoTurma;
	}
	
	public AlunoDTO(Aluno aluno) {
		super();
		this.idAluno = aluno.getIdAluno();
		this.nomeAluno = aluno.getNomeAluno();
		this.responsavelContato = aluno.getResponsavelContato();
		this.permissaoSairSozinho = aluno.isPermissaoSairSozinho();
		this.observacoesAdicionais = aluno.getObservacoesAdicionais();
		if(aluno.getTurmaAno() != null) {
			this.anoTurma = aluno.getTurmaAno().getAnoTurma();
		}
	}
	
	
	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
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
	public String getObservacoesAdicionais() {
		return observacoesAdicionais;
	}
	public void setObservacoesAdicionais(String observacoesAdicionais) {
		this.observacoesAdicionais = observacoesAdicionais;
	}

	public Integer getAnoTurma() {
		return anoTurma;
	}

	public void setAnoTurma(Integer anoTurma) {
		this.anoTurma = anoTurma;
	}
	
}
