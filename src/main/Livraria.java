package main;

import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Scanner; 

import classes_livraria.Livro;
import excecoes.AlgumCampoNaoPreenchidoException;
import excecoes.AlunoJaExisteException;
import excecoes.AlunoNaoEncontradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.LivroIndisponivelException;
import excecoes.LivroJaDisponivelException;
import excecoes.LivroNaoCadastradoException;
import excecoes.LoginInvalidoException;
import excecoes.SexoEmFormatoIncorretoException;
import excecoes.TipoDeUsuarioNaoValidoException;
import repositorios.RepositorioAluno;
import repositorios.RepositorioFuncionario;
import repositorios.RepositorioLivro;


public class Livraria {
	public static void main (String [] args) throws FileNotFoundException, IOException, SexoEmFormatoIncorretoException, AlgumCampoNaoPreenchidoException, TipoDeUsuarioNaoValidoException, LoginInvalidoException, LivroJaDisponivelException, LivroNaoCadastradoException{

		//		String path = "/Arquivos/alunos.txt";
		RepositorioAluno repalu = new RepositorioAluno();
		RepositorioFuncionario repfunc = new RepositorioFuncionario();
		RepositorioLivro repliv = new RepositorioLivro();

		repalu.AddAluno("Karine", "123456", "karine@email.com", "f", "SI");
		repalu.AddAluno("Karina", "123123", "karina@email.com", "f", "CC");
		repalu.AddAluno("Rafael", "123321", "rafael@email.com", "m", "EC");

		repfunc.AddFuncionario("Henrique", "111", "henrique@email.com", "m", "gerente");
		repfunc.AddFuncionario("Rebelo", "123", "rebelo@email.com","m", "atendente");
		repfunc.AddFuncionario("Funcionario", "10", "funcionario@email.com","m", "atendente");

		repliv.addLivro("Deitel", "aprender", "JavaOO", 1, 2, 150.00, "5282", true);
		repliv.addLivro("José", "altabooks", "JavaUseAcabeça", 3, 1, 145.00, "5282873", true);
		repliv.addLivro("Marcos Java", "americana", "bancoDeDados", 1, 2, 150.00, "22526", true);

		//repcli.insereAlunoNoArquivo(path);

		Scanner in = new Scanner(System.in);

		//String login, senha;
		int menu;

		Livraria chama = new Livraria();
		System.out.println("Bem-vindo!"
				+ "\nEssa é a livrariaP2 que tem tudo para você!");
		System.out.println("");
		System.out.println("Você é aluno ou funcionário da livraria?"
				+ "\n1. Funcionário"
				+ "\n2. Aluno");
		menu = in.nextInt();

		//int escolha = -1;
		//int esc;

//		while((menu != 1) || (menu != 2)){
//			System.out.println("Informe uma opção válida!"
//					+ "\nVocê é aluno ou funcionário da livraria?"
//					+ "\n1. Funcionário"
//					+ "\n2. Aluno");
//			menu = in.nextInt();
//
//		}


		if (menu == 1){
			int escolha = -1;
			//String esc;

			do{
				System.out.println("\nEscolha uma das opções:" +
						"\n1. Inserir Livro" +
						"\n2. Remover Livro" +
						"\n3. Pesquisar Livro" +
						"\n4. Cadastrar aluno"+ 
						"\n5. Cadastrar Funcionario"+ 
						"\n6. Remover Funcionario" +
						"\n7. Listar Alunos" +
						"\n8. Listar Livros" +
						"\n9. Listar Funcionarios" +
						"\n0. Logout");
				System.out.print("\nopcao: ");



				try{

					escolha = in.nextInt();
				}catch(NumberFormatException e){
					System.out.println("ERRO: "+e.getMessage());
				}

				switch(escolha){
				case 1: 
					System.out.println("Inserir novo livro no sistema:");
					System.out.println("Autor:");
					String autor = in.next();
					System.out.println("Editora:");
					String editora = in.next();
					System.out.println("Título:");
					String titulo = in.next();
					System.out.println("Edição:");
					int edicao = in.nextInt();
					System.out.println("Período:");
					int periodo = in.nextInt();
					System.out.println("Preco:");
					double preco = in.nextDouble();
					System.out.println("Código:");
					String codigo = in.next();
					boolean disponivel = true;

					try{
						repliv.addLivro(autor, editora, titulo, edicao, periodo, preco, codigo, disponivel);

						System.out.println("Livro inserido com sucesso!");
					}catch(AlgumCampoNaoPreenchidoException acnpe){
						System.out.println(acnpe.getMessage());
					}

					break;

				case 2:
					System.out.println("Remover livro do sistema:");
					System.out.println("Insira o código do livro a ser removido:");
					codigo = in.next();
					try{
						repliv.removerLivro(codigo);
						System.out.println("Livro removido com sucesso!");
					}catch(LivroNaoCadastradoException lnce){
						System.out.println(lnce.getMessage());
					}

					break;

				case 3:
					System.out.println("Pesquisar livro no sistema:");
					System.out.println("Insira o título do livro:");
					titulo = in.next();

					try{
						repliv.pesquisarByTitulo(titulo);

					}catch(LivroNaoCadastradoException lnce){
						System.out.println(lnce.getMessage());
					}
					break;

				case 4: 
					System.out.println("Inserir novo aluno no sistema:");
					System.out.println("Nome:");
					String nome = in.next();
					System.out.println("CPF:");
					String cpf = in.next();
					System.out.println("Email:");
					String email = in.next();
					System.out.println("Sexo:");
					String sexo = in.next();
					System.out.println("Curso:");
					String curso = in.next();

					try{
						repalu.AddAluno(nome, cpf, email, sexo, curso);
						System.out.println("Aluno inserido com sucesso");
					}catch(AlgumCampoNaoPreenchidoException acnpe){
						System.out.println(acnpe.getMessage());							
					}catch(SexoEmFormatoIncorretoException sefi){
						System.out.println(sefi.getMessage());
					}
					break;

				case 5: 
					System.out.println("Inserir novo funcionário no sistema:");
					System.out.println("Nome:");
					nome = in.next();
					System.out.println("CPF:");
					cpf = in.next();
					System.out.println("Email:");
					email = in.next();
					System.out.println("Sexo:");
					sexo = in.next();
					System.out.println("Cargo:");
					String cargo = in.next();

					try{
						repfunc.AddFuncionario(nome, cpf, email, sexo, cargo);
						System.out.println("Funcionário inserido com sucesso");
					}catch(AlgumCampoNaoPreenchidoException acnpe){
						System.out.println(acnpe.getMessage());							
					}catch(SexoEmFormatoIncorretoException sefi){
						System.out.println(sefi.getMessage());
					}
					break;
				case 6: 
					System.out.println("Remover funcionário:");
					System.out.println("Informe o cpf do funcionário:");
					cpf = in.next();

					try{
						repfunc.removeFuncionario(cpf);
						System.out.println("Funcionário removido com sucesso!");
					}catch(FuncionarioNaoEncontradoException fnee ){
						System.out.println(fnee.getMessage());
					}
					break;

				case 7:
					try{
						repalu.listarAlunos();
					}catch(RuntimeException fnee ){
						System.out.println(fnee.getMessage());
					}
					break;

				case 8:
					try{
						repliv.listarLivro();
					}catch(RuntimeException fnee ){
						System.out.println(fnee.getMessage());
					}
					break;

				case 9:
					try{
						repfunc.listarFuncionario();
					}catch(RuntimeException fnee ){
						System.out.println(fnee.getMessage());
					}
					break;

				case 0:
					System.out.println("Até a próxima!");
					break;
				default:
					System.out.println("Digite uma opcao valida!");

				}

			}while(escolha != 0);



		}

		if (menu == 2){

			int escolha = -1;
			String esc;
			String titulo;


			do{
				System.out.println("\nEscolha uma das opções:" +
						"\n1. Pegar Livro Emprestado" +
						"\n2. Devolver Livro" +
						"\n3. Pesquisar Livro" +
						"\n4. Listar Livros" +
						"\n0. Logout");
				System.out.print("\nopcao: ");

				try{
					esc = in.next();
					escolha = Integer.parseInt(esc);
				}catch(NumberFormatException e){
					System.out.println("ERRO: "+e.getMessage());
				}

				switch(escolha){
				case 1: 
					System.out.println("Empréstimo de livro.");
					System.out.println("Insira o título do livro a ser pego emprestado:");
					titulo = in.next();
					try{
						repliv.pegarLivroEmprestado(titulo);
						System.out.println("Operação realizada com Sucesso!");
					}catch(LivroNaoCadastradoException lnce){
						System.out.println(lnce.getMessage());
					}catch(LivroIndisponivelException lie){
						System.out.println(lie.getMessage());
					}
					break;
				case 2:
					System.out.println("Devolver livro.");
					System.out.println("Insira o título do livro:");
					titulo = in.next();

					try{
						repliv.devolverLivro(titulo);
						System.out.println("Livro devolvido. Livro Disponível.");
					}catch(LivroNaoCadastradoException lnce){
						System.out.println(lnce.getMessage());
					}
					break;
				case 3:
					System.out.println("Pesquisar livro no sistema:");
					System.out.println("Insira o título do livro:");
					titulo = in.next();

					try{
						repliv.pesquisarByTitulo(titulo);

					}catch(LivroNaoCadastradoException lnce){
						System.out.println(lnce.getMessage());
					}
					break;

				case 4: 

					System.out.println("Listar livro.");

					try{
						repliv.listarLivro();

					}catch(RuntimeException lnce){
						System.out.println(lnce.getMessage());
					}
					break;

				case 0:
					System.out.println("Até a próxima!");
					break;
				default:
					System.out.println("Digite uma opcao valida!");
				}

			}while(escolha != 0);


		}


	}

}
