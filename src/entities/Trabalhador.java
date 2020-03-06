package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enum_nivel.NivelDoProficional;

public class Trabalhador {
	private String nome;
	private NivelDoProficional nivelDoProficional;
	private Departamento departamento;
	private List <Contrato> contrato;
	private Double salariBase;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public NivelDoProficional getNivelDoProficional() {
		return nivelDoProficional;
	}
	public void setNivelDoProficional(NivelDoProficional nivelDoProficional) {
		this.nivelDoProficional = nivelDoProficional;
	}
	public String getDepartamento() {
		return departamento.getNomeDepartamento();
	}
	public void setDepartamento(String departamento) {
		this.departamento = new Departamento();
		this.departamento.setNomeDepartamento(departamento);
	}
	public Double getSalariBase() {
		return salariBase;
	}
	public void setSalariBase(Double salariBase) {
		this.salariBase = salariBase;
	}
	public void addContrato(Contrato contrato) {
		if(this.contrato==null) {
			this.contrato = new ArrayList<>();
			this.contrato.add(contrato);
		}
		else {
			this.contrato.add(contrato);
		}
	}
	public Double valorAcumuladoDeContrato(Integer mes) {
		Double valor=0.00;
		for(Contrato x: contrato) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(x.getData());
			if(cal.get(Calendar.MONTH)==mes) {
				valor+=x.valorTotal();
			}
		}
		return valor;
	}
}
