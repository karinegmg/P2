package repositorios;

import classes_livraria.Cliente;
import excecoes.AlgumCampoNaoPreenchidoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.LoginInvalidoException;
import excecoes.SexoEmFormatoIncorretoException;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Scanner; 

import javax.security.auth.login.LoginException;


public class RepositorioCliente {

	private Cliente [] arrayCliente;
	private int index;

	public RepositorioCliente(){
		arrayCliente = new Cliente[1000];
		index = 0;
	}

	public Cliente AddCliente(String nome, String cpf, String email, String senha, String sexo) throws SexoEmFormatoIncorretoException, AlgumCampoNaoPreenchidoException{
		Cliente novoCliente = null;

		if(nome.equals("") || cpf.equals("") || email.equals("") || senha.equals("")){
			throw new AlgumCampoNaoPreenchidoException();	
		}
		else{
			char sexoChar;
			if(sexo.equalsIgnoreCase("m") || sexo.equalsIgnoreCase("f")){
				sexoChar = sexo.toCharArray()[0];
			}
			else{
				throw new SexoEmFormatoIncorretoException();
			}

		}
		novoCliente = new Cliente(nome,cpf,email,senha, sexo);
		arrayCliente[index] = novoCliente;
		index++;

		return novoCliente;
	}

	public Cliente procurarCliente(String cpf) throws ClienteNaoEncontradoException{
		Cliente cliente = null;

		for(int i = 0; i < index; i++){
			if(arrayCliente[i].getCpf().equals(cpf)){
				cliente = arrayCliente[i];
				i = index;
			}
			if(cliente == null){
				throw new ClienteNaoEncontradoException();
			}
		}
		return cliente;

	}
	public Cliente removeCliente(String cpf) throws ClienteNaoEncontradoException{
		Cliente cliente = null;
		for(int i = 0; i < index; i++){
			if(arrayCliente[i].getCpf().equals(cpf)){
				cliente = arrayCliente[i];
				i = index;
				index--;
				arrayCliente[i] = arrayCliente[index];
			}
			if(cliente == null){
				throw new ClienteNaoEncontradoException();
			}
		}
		return cliente;
	}
	
	public void clienteLogando(String email, String senha) throws LoginInvalidoException{
		boolean logado = false;
		
		for (int i = 0; i < index; i++){
			if(arrayCliente[i].getEmail().equals(email) && arrayCliente[i].getSenha().equals(senha)){
				logado = true;
				i = index;
			}
			if(!logado){
				throw new LoginInvalidoException();
			}
		}
	}
	
	public void insereClienteNoArquivo(String path) throws FileNotFoundException, IOException{
		BufferedReader bfr = new BufferedReader(new FileReader(path));
		BufferedWriter bfw = new BufferedWriter(new FileWriter(path));
		
		

	}
}
