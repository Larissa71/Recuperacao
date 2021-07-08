package br.com.senai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.Motorista.Motorista;
import br.com.senai.Motorista.MotoristaController;
import br.com.senai.Veiculo.Veiculo;
import br.com.senai.Veiculo.VeiculoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {

		List<Motorista> motoristas = new ArrayList<>();
		List<Veiculo> veiculos = new ArrayList<>();

		MotoristaController motoristaController = new MotoristaController();
		VeiculoController veiculoController = new VeiculoController();

		Scanner tec = new Scanner(System.in);
		boolean sair = false;

		do {
			System.out.println("----- MENU ----");
			System.out.println("1) Registro de Motorista");
			System.out.println("2) Registro de Veiculo");
			System.out.println("3) Sair");
			System.out.println(" > ");
			int opcao = tec.nextInt();
			switch (opcao) {
			case 1:
				motoristaController.menu1(motoristas, veiculos);
				break;

			case 2:
				veiculoController.menu2(veiculos, motoristas);
				break;

			case 3:
				sair = true;
				break;
			default:
				System.out.println(" Opção invalida! ");
				break;
			}
		} while (!sair);
		System.out.println(" Sistema encerrado! ");
	}
}
