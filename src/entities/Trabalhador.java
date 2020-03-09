package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enum_nivel.NivelDoProficional;

public class Trabalhador {
	private String nome;
	private NivelDoProficional nivelDoProficional;
	private Departamento departamento;
	private List <Contrato> contrato = new ArrayList<>();
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
		this.contrato.add(contrato);
	}
	public Double valorAcumuladoDeContrato(Integer mes, Integer ano) {
		Double valor=this.getSalariBase();
		for(Contrato x: contrato) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(x.getData());
			int mesContrato = 1+ cal.get(Calendar.MONTH);
			int anoContrato = cal.get(Calendar.YEAR);
			if(mesContrato==mes && anoContrato==ano) {
				valor+=x.valorTotal();
			}
		}
		return valor;
	}
}
