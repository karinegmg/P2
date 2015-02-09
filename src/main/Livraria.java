package main;

import java.util.Scanner;

import arquivo.Arquivo;
import livrariaSI.Cliente;
import livrariaSI.Funcionario;

public class Livraria {
	public static void main (String[]args){
		
		Arquivo arq = new Arquivo("login.in","");

		Scanner in = new Scanner(System.in);

		Cliente [] clientes = new Cliente[1000];
		Funcionario [] funcionarios = new Funcionario [10];
		
		String login;
		int menu;
		String resposta;
		Livraria chama = new Livraria();
		System.out.println("Welcome!");
		System.out.println("Kari's Library! ");
		System.out.println("Você já é cadastrado?" +
				"\n1 - sim." +
		"\n2 - não.");
		menu = in.nextInt();
		if(menu == 2){
			System.out.println("Deseja realizar cadastro? (s/n)");
			resposta = in.next();
			if(resposta.charAt(0) == 's'){


			}

		}


		System.out.println("Login: ");


		System.out.println("Senha: ");		






	}
	public boolean fazerLoginComSucesso(){
		String login,senha;
		System.out.println("Login:");
		Scanner in = null;
		login = in.nextLine();
		System.out.print("Senha:");
		senha = in.nextLine();
		
		return true;

	}

}
