package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contrato;
import entities.Trabalhador;
import enum_nivel.NivelDoProficional;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Trabalhador trabalhador = new Trabalhador();
		System.out.print("Informe departamento:");
		trabalhador.setDepartamento(sc.nextLine());
		System.out.print("Informe nome:");
		trabalhador.setNome(sc.nextLine());
		System.out.print("Informe n�vel do proficional:");
		NivelDoProficional nivel = NivelDoProficional.valueOf(sc.nextLine().toUpperCase());
		trabalhador.setNivelDoProficional(nivel);
		System.out.print("Informe sal�rio base:");
		trabalhador.setSalariBase(sc.nextDouble());
		System.out.println("Informe a quabntidade de contratos:");
		int quantidadeContratos = sc.nextInt();
		for(int i=0; i<quantidadeContratos;i++) {
			sc.nextLine();
			Contrato contrato = new Contrato();
			System.out.println("Contrato "+(i+1));
			System.out.print("Data do contrato:");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataContrato;
			try {
				dataContrato = sdf.parse(sc.nextLine());
				contrato.setData(dataContrato);
				System.out.print("Informe valor das horas:");
				contrato.setValorDaHora(sc.nextDouble());
				System.out.print("Informe quantidade de horas trabalhadas:");
				contrato.setHorasTraalhadas(sc.nextInt());
				trabalhador.addContrato(contrato);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.print("Informe m�s e ano para calculo de valor acumulado:");
		Integer mes = sc.nextInt();
		System.out.printf("Valor acumulado de contratos R$ %.2f",trabalhador.valorAcumuladoDeContrato(mes));
		sc.close();
	}

}
