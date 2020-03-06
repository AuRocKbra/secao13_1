package entities;

import java.util.Date;

public class Contrato {
	private Date data;
	private Double valorDaHora;
	private Integer horasTraalhadas;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorDaHora() {
		return valorDaHora;
	}
	public void setValorDaHora(Double valorDaHora) {
		this.valorDaHora = valorDaHora;
	}
	public Integer getHorasTraalhadas() {
		return horasTraalhadas;
	}
	public void setHorasTraalhadas(Integer horasTraalhadas) {
		this.horasTraalhadas = horasTraalhadas;
	}
	
	public Double valorTotal() {
		return getValorDaHora()*getHorasTraalhadas();
	}
}
