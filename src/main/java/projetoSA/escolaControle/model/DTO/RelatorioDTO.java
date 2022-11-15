package projetoSA.escolaControle.model.DTO;

import java.time.LocalDateTime;

import projetoSA.escolaControle.model.entity.Relatorio;

public class RelatorioDTO {

	private Integer idRelatorio;
	private LocalDateTime momentoDataHora;
	private String nomeAcompanhado;
	
	public RelatorioDTO() {}
	
	public RelatorioDTO(Integer idRelatorio, LocalDateTime momentoDataHora, String nomeAcompanhado) {
		super();
		this.idRelatorio = idRelatorio;
		this.momentoDataHora = momentoDataHora;
		this.nomeAcompanhado = nomeAcompanhado;
	}
	
	public RelatorioDTO(Relatorio relatorio) {
		super();
		this.idRelatorio = relatorio.getIdRelatorio();
		this.momentoDataHora = relatorio.getMomentoDataHora();
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
