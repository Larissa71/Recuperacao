package br.com.senai.Veiculo;

import java.util.List;
import java.util.Scanner;

import br.com.senai.Motorista.Motorista;
import br.com.senai.Motorista.MotoristaController;

public class VeiculoController {

	Scanner tec = new Scanner(System.in);

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Veiculo cadastrarVeiculo() {
		Veiculo veiculo = new Veiculo();

		System.out.println("--- CADASTRAR VEICULO ---");
		System.out.print("Informe o Modelos do veiculo: ");
		tec.nextLine();
		veiculo.setModelo(tec.next());
		return veiculo;
	}

	public List<Veiculo> listarVeiculos(List<Veiculo> veiculos) {
		if (veiculos.isEmpty()) {
			System.out.println("Não possui Veiculos cadastrados.");
			return null;
		}
		System.out.println("--- VEICULOS CADASTRADAS ---");
		System.out.printf("2 | %5s | %4s | %15s | %5s| n", "id", "modelo", "ano", "tipoCombustivel", "placa");
		for (int i = 0; i < veiculos.size(); i++) {
			System.out.printf("| %2s | %10 | 10 | 5 | 10 | 10| \n", i + 1, veiculos.get(i).getModelo(),
					veiculos.get(i).getAno(), veiculos.get(i).getTipoCombustivel(), veiculos.get(i).getPlaca());
		}
		return veiculos;
	}

	public List<Veiculo> editarVeiculo(List<Veiculo> veiculos) {
		Veiculo veiculo = new Veiculo();
		listarVeiculos(veiculos);
		if (veiculos.isEmpty()) {
			return veiculos;
		}
		System.out.print("Informe o Id do Veiculo para editar: ");
		int idVeiculo = tec.nextInt() - 1;

		System.out.println(" 1) Modelo ");
		System.out.println(" 2) Ano ");
		System.out.println(" 3)  Tipo de combustivel");
		System.out.println(" 4) Placa ");
		System.out.println(" Informe o campo que deseja alterar: ");
		int opcao = tec.nextInt();
		switch (opcao) {

		case 1:
			System.out.println(" --- EDITAR O MODELO  --- ");
			System.out.println(" Informe o novo modelo: ");
			veiculo.setModelo(tec.next());

			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculos.set(idVeiculo, veiculo);
			break;

		case 2:
			System.out.println(" --- EDITAR O ANO  --- ");
			System.out.println(" Informe o novo ANO: ");
			veiculo.setAno(tec.nextInt());

			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculos.set(idVeiculo, veiculo);
			break;

		case 3:
			System.out.println(" --- EDITAR O TIPO DE COMBUSTIVEL  --- ");
			System.out.println(" Informe o novo Tipo: ");
			veiculo.setTipoCombustivel(tec.next());

			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculos.set(idVeiculo, veiculo);
			break;

		case 4:
			System.out.println(" --- EDITAR A PLACA  --- ");
			System.out.println(" Informe o nova placa: ");
			veiculo.setPlaca(tec.nextInt());

			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculos.set(idVeiculo, veiculo);
			break;
		}
		return veiculos;
	}

	public void excluirVeiculo(List<Veiculo> veiculos, List<Motorista> motoristas) {

		listarVeiculos(veiculos);
		if (veiculos.isEmpty()) {
			return;
		}
		System.out.println("--- EXCLUIR VEICULO ---");

		System.out.println("Informe o Id do Veiculo para exluir: ");
		int idVeiculo = tec.nextInt() - 1;

		if (veiculos.size() <= idVeiculo) {
			System.out.println("Veiculo não cadastrado.");
			return;
		}
		veiculos.remove(idVeiculo);

	}

	public void menu2(List<Veiculo> veiculos, List<Motorista> motoristas) {

		boolean sair = false;

		do {
			System.out.println(" --- MENU --- ");
			System.out.println(" 1) Cadastrar Veiculo ");
			System.out.println(" 2) Listar Veiculo ");
			System.out.println(" 3) Editar Veiculo ");
			System.out.println(" 4) Excluir Veiculo ");
			System.out.println(" 5) Sair ");

			int opcao = leopcao();
			switch (opcao) {
			case 1:
				veiculos.add(cadastrarVeiculo());
				break;

			case 2:
				listarVeiculos(veiculos);
				break;

			case 3:
				editarVeiculo(veiculos);
				break;

			case 4:
				excluirVeiculo(veiculos, motoristas);
				break;

			case 5:
				sair = true;
				break;

			default:
				System.out.println(" Opção inválida! ");
				break;
			}

		} while (!sair);
	}
}
