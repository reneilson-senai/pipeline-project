package projetoSA.escolaControle.model.DTO;

import projetoSA.escolaControle.model.entity.Turma;

public class TurmaDTO {
	
	private Integer idTurma;
	private Integer anoTurma;
	private String periodoTurma;
	
	public TurmaDTO() {}
	
	public TurmaDTO(Integer anoTurma, Integer idTurma, String periodoTurma) {
		super();
		this.idTurma = idTurma;
		this.anoTurma = anoTurma;
		this.periodoTurma = periodoTurma;
	}
	public TurmaDTO(Turma turma) {
		super();
		this.idTurma = turma.getIdTurma();
		this.anoTurma = turma.getAnoTurma();
		this.periodoTurma = turma.getPeriodoTurma();
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
