package main;

import java.util.Scanner;

import classes_livraria.Cliente;
import classes_livraria.Funcionario;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Scanner; 

import repositorios.RepositorioCliente;


public class Livraria {
	public static void main (String [] args) throws FileNotFoundException{
		
		String path = "/Arquivos/clientes.txt";
		RepositorioCliente repcli = new RepositorioCliente();

		
		repcli.insereNoArquivo(path);
		
		Scanner in = new Scanner(System.in);

		Cliente [] clientes = new Cliente[1000];
		Funcionario [] funcionarios = new Funcionario [10];
		
		String login;
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


			}

		}


		System.out.println("Login: ");


		System.out.println("Senha: ");		






	}
//	public boolean fazerLoginComSucesso(){
//		String login,senha;
//		System.out.println("Login:");
//		Scanner in = null;
//		login = in.nextLine();
//		System.out.print("Senha:");
//		senha = in.nextLine();
//		
//		return true;
//
//	}

}
