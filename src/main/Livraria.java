package main;

import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Scanner; 

import excecoes.AlgumCampoNaoPreenchidoException;
import excecoes.ClienteJaExisteException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.LivroIndisponivelException;
import excecoes.LivroJaDisponivelException;
import excecoes.LivroNaoCadastradoException;
import excecoes.LoginInvalidoException;
import excecoes.SexoEmFormatoIncorretoException;
import excecoes.TipoDeUsuarioNaoValidoException;
import repositorios.RepositorioCliente;
import repositorios.RepositorioFuncionario;
import repositorios.RepositorioLivro;


public class Livraria {
	public static void main (String [] args) throws FileNotFoundException, IOException, SexoEmFormatoIncorretoException, AlgumCampoNaoPreenchidoException, TipoDeUsuarioNaoValidoException, LoginInvalidoException, LivroJaDisponivelException, LivroNaoCadastradoException{

		//		String path = "/Arquivos/clientes.txt";
		RepositorioCliente repcli = new RepositorioCliente();
		RepositorioFuncionario repfunc = new RepositorioFuncionario();
		RepositorioLivro repliv = new RepositorioLivro();

		//repcli.insereClienteNoArquivo(path);

		Scanner in = new Scanner(System.in);

		//String login, senha;
		int menu;
		String resposta;
		Livraria chama = new Livraria();
		System.out.println("Welcome!");
		System.out.println("This is our Library! ");
		System.out.println("Você já é cadastrado?" +
				"\n1 - sim." +
				"\n2 - não.");
		menu = in.nextInt();
		if(menu == 2){
			System.out.println("Deseja realizar cadastro? (s/n)");
			resposta = in.next();
			if(resposta.charAt(0) == 's'){
				int tipodeusuario;
				System.out.println("Antes de iniciar o cadastro, gostaríamos de te fazer uma pergunta:"
						+ "\nVocê é cliente ou funcionário da loja?"
						+ "\nResponda: "
						+ "\n1 - cliente"
						+ "\n2 - funcionário");
				tipodeusuario = in.nextInt();
				//				while((tipodeusuario != 1) || (tipodeusuario != 2)){
				//					throw new TipoDeUsuarioNaoValidoException();
				//				}
				if(tipodeusuario == 1){
					System.out.println("Insira seus dados:");
					System.out.println("Nome:");
					String nome = in.nextLine();
					System.out.println("CPF:");
					String cpf = in.next();
					System.out.println("Email:");
					String email = in.next();
					System.out.println("Senha:");
					String senha = in.next();
					System.out.println("Sexo(m/f):");
					String sexo = in.next();

					try{

						repcli.AddCliente(nome, cpf, email, senha, sexo);
						System.out.println("Cadastro realizado com sucesso.");
					}catch(SexoEmFormatoIncorretoException sefie){
						System.out.println(sefie.getMessage());
					}catch (AlgumCampoNaoPreenchidoException acnpe){
						System.out.println(acnpe.getMessage());
					}
				}
				else{
					if(tipodeusuario == 2){
						System.out.println("Insira seus dados:");
						System.out.println("Nome:");
						String nome = in.nextLine();
						System.out.println("CPF:");
						String cpf = in.next();
						System.out.println("Email:");
						String email = in.next();
						System.out.println("Senha:");
						String senha = in.next();
						System.out.println("Sexo(m/f):");
						String sexo = in.next();

						try{

							repfunc.AddFuncionario(nome, cpf, email, senha, sexo);
							System.out.println("Cadastro realizado com sucesso.");
						}catch(SexoEmFormatoIncorretoException sefie){
							System.out.println(sefie.getMessage());
						}catch (AlgumCampoNaoPreenchidoException acnpe){
							System.out.println(acnpe.getMessage());
						}
					}
				}

			}
			if(resposta.charAt(0) == 'n'){
				System.out.println("Ok. Volte Sempre!");
			}
			else{

				System.out.println("Ok, até a próxima.");
			}

		}
		if (menu==1){
			String email, senha;
			boolean permissao = false;

			System.out.println("Escolha uma opção abaixo:"
					+ "\n1 - Login Funcionário"
					+ "\n2 - Login Cliente");
			int escolhaLogin = in.nextInt();

			if (escolhaLogin == 1){
				while(!permissao){
					try {

						System.out.println("Email:");
						email = in.next();
						System.out.println("Senha:");
						senha = in.next();
						repfunc.funcioarioLogando(email, senha);

						permissao = true;

						System.out.println("Usuário logado com sucesso!");
					}
					catch(LoginInvalidoException e){
						System.out.println(e.getMessage());
					}

				}
				int escolha = -1;
				String esc;

				do{
					System.out.println("\nEscolha uma das opções:" +
							"\n1. Inserir Livro" +
							"\n2. Remover Livro" +
							"\n3. Pesquisar Livro" +
							"\n4. Cadastrar cliente"+ 
							"\n5. Cadastrar Funcionario"+ 
							"\n6. Remover Funcionario" +
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
						System.out.println("Inserir novo cliente no sistema:");
						String nome = in.nextLine();
						System.out.println("Nome:");

						System.out.println("CPF:");
						String cpf = in.next();
						System.out.println("Email:");
						email = in.next();
						System.out.println("Senha:");
						senha = in.next();
						System.out.println("Sexo:");
						String sexo = in.next();

						try{
							repcli.AddCliente(nome, cpf, email, senha, sexo);
							System.out.println("Cliente inserido com sucesso");
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
						System.out.println("Senha:");
						senha = in.next();
						System.out.println("Sexo:");
						sexo = in.next();

						try{
							repfunc.AddFuncionario(nome, cpf, email, senha, sexo);
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
					case 0:
						System.out.println("Até a próxima!");
						break;
					default:
						System.out.println("Digite uma opcao valida!");
					}

				}while(escolha != 0);



			}

			if (escolhaLogin == 2){
				while(!permissao){

					System.out.println("Email:");
					email = in.next();
					System.out.println("Senha:");
					senha = in.next();
					try {
						repcli.clienteLogando(email, senha);

						System.out.println("Usuário logado com sucesso!");
					}
					catch(LoginInvalidoException lie){
						System.out.println(lie.getMessage());
					}
					permissao = true;
				}

				int escolha = -1;
				int esc;

				do{
					System.out.println("\nEscolha uma das opções:" +
							"\n1. Comprar Livro" +
							"\n2. Devolver Livro" +
							"\n3. Pesquisar Livro" +
							"\n4. Pegar Livro Emprestado" +
							"\n0. Logout");
					System.out.print("\nopcao: ");



					try{
						esc = in.nextInt();
						escolha = esc;
					}catch(NumberFormatException e){
						System.out.println("ERRO: "+e.getMessage());
					}

					switch(escolha){
					case 1:
						System.out.println("Olá, nos informe o título do livro que deseja comprar:");
						String titulo = in.next();

						try{
							repliv.comprarLivro(titulo);
							System.out.println("Livro comprado com sucesso!");
						}catch(LivroIndisponivelException lie){
							System.out.println(lie.getMessage());
						}catch(LivroNaoCadastradoException lnce){
							System.out.println(lnce.getMessage());
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

					case 0:
						System.out.println("Obrigado pela visita! Até a próxima!");
						break;
					default:
						System.out.println("Digite uma opcao valida!");
					}

				}while(escolha != 0);


			}
		}

	}
}