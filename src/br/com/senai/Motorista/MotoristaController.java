package br.com.senai.Motorista;

import java.util.List;
import java.util.Scanner;

import br.com.senai.Veiculo.Veiculo;
import br.com.senai.Veiculo.VeiculoController;

public class MotoristaController extends VeiculoController {
	private Scanner tec;

	public MotoristaController() {
		tec = new Scanner(System.in);
	}

	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Motorista cadastrarMotorista() {
		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo();

		System.out.println("--- CADASTRAR MOTORISTA ---");
		System.out.print("Informe o nome do motorista: ");
		motorista.setNome(tec.nextLine());

		System.out.println("Informe a idade: ");
		motorista.setIdade(tec.nextInt());

		System.out.println("Informe a Habilitação: ");
		motorista.setCategoriaHabilitacao(tec.next());

		System.out.println(" Informe o veiculo: ");
		motorista.setVeiculo(veiculo);

		return motorista;

	}

	public List<Motorista> listarMotorista(List<Motorista> motoristas) {
		if (motoristas.isEmpty()) {
			System.out.println("Não possui cursos cadastrados.");
			return null;
		}
		System.out.println("--- MOTORISTAS CADASTRADAS ---");
		System.out.printf("| %2s | %15s | %16s | %13s |%10s \n", "Id", " Nome ", " Idade ", "Habilitação", "Veiculo");
		for (int i = 0; i < motoristas.size(); i++) {
			System.out.printf(" |%2s |%15s |%6d |%10s |%10s \n", i + 1, motoristas.get(i).getNome(),
					motoristas.get(i).getNome(), motoristas.get(i).getIdade(),
					motoristas.get(i).getCategoriaHabilitacao(), motoristas.get(i).getVeiculo());
		}
		return motoristas;
	}

	public List<Motorista> editarMotorista(List<Motorista> motoristas) {
		Motorista motorista = new Motorista();
		listarMotorista(motoristas);
		if (motoristas.isEmpty()) {
			return motoristas;
		}
		System.out.print("Informe o Id do Motorista para editar: ");
		int idMotorista = tec.nextInt() - 1;

		System.out.println(" Informe o Id do aluno para editar: ");
		int idMotoristas = tec.nextInt() - 1;

		System.out.println(" 1) Nome ");
		System.out.println(" 2) Idade ");
		System.out.println(" 3) CategoriaHabilitacao ");
		System.out.println(" 4) Veiculo ");
		System.out.println(" Informe o campo que deseja editar: ");
		int opcao = tec.nextInt();

		switch (opcao) {

		case 1:
			System.out.println(" --- EDITAR O NOME --- ");
			System.out.println(" Informe o novo nome: ");
			motorista.setNome(tec.next());

			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			motoristas.set(idMotorista, motorista);
			break;

		case 2:
			System.out.println(" --- EDITAR A IDADE --- ");
			System.out.println("Informe a nova idade: ");
			motorista.setIdade(tec.nextInt());

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			motoristas.set(idMotorista, motorista);
			break;

		case 3:
			System.out.println(" --- EDITAR CategoriaHabilitacao --- ");
			System.out.println("Informe a nova Categoria de Habilitacao: ");
			motorista.setCategoriaHabilitacao(tec.next());

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			motoristas.set(idMotorista, motorista);
			break;

		case 4:
			System.out.println(" --- EDITAR VEICULO--- ");
			Veiculo veiculo = new Veiculo();
			System.out.println("Informe a novo veiculo: ");
			motorista.setVeiculo(veiculo);

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motoristas.set(idMotorista, motorista);
			break;

		default:
			System.out.println(" Opção Inválida! ");
			break;
		}
		return motoristas;
	}

	public void excluirMotorista(List<Motorista> motoristas) {
		listarMotorista(motoristas);
		if (motoristas.isEmpty()) {
			return;
		}
		System.out.println("--- EXCLUIR MOTORISTA ---");

		System.out.println("Informe o Id do Motorista para exluir: ");
		int idMotorista = tec.nextInt() - 1;

		if (motoristas.size() <= idMotorista) {
			System.out.println("Motorista não cadastrado.");
			return;
		}
		motoristas.remove(idMotorista);
	}

	public void menu1(List<Motorista> motoristas, List<Veiculo> veiculos) {

		boolean sair = false;
		do {
			System.out.println(" --- MENU --- ");
			System.out.println(" 1) Cadastrar motorista ");
			System.out.println(" 2) Listar motorista ");
			System.out.println(" 3) Editar motorista ");
			System.out.println(" 4) Excluir motorista ");
			System.out.println(" 5) Sair");

			int opcao = leopcao();
			switch (opcao) {
			case 1:
				motoristas.add(cadastrarMotorista());
				break;

			case 2:
				listarMotorista(motoristas);
				break;

			case 3:
				editarMotorista(motoristas);
				break;

			case 4:
				excluirMotorista(motoristas);
				break;

			case 5:
				sair = true;
				break;

			default:
				System.out.println(" Opção Inválida! ");
				break;
			}
		} while (!sair);
	}
}
