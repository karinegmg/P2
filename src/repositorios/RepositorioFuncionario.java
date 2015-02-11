package repositorios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import classes_livraria.Cliente;
import classes_livraria.Funcionario;
import excecoes.AlgumCampoNaoPreenchidoException;
import excecoes.ClienteNaoEncontradoException;
import excecoes.FuncionarioNaoEncontradoException;
import excecoes.LoginInvalidoException;
import excecoes.SexoEmFormatoIncorretoException;


public class RepositorioFuncionario {
	private Funcionario [] arrayFuncionario;
	private int index;
	
	public RepositorioFuncionario(){
		arrayFuncionario = new Funcionario[100];
		index = 0;
	}
	
	public Funcionario AddFuncionario(String nome, String cpf, String email, String senha, String sexo) throws SexoEmFormatoIncorretoException, AlgumCampoNaoPreenchidoException{
		Funcionario novoFuncionario = null;

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
		novoFuncionario = new Funcionario(nome,cpf,email,senha, sexo);
		arrayFuncionario[index] = novoFuncionario;
		index++;

		return novoFuncionario;
	}

	public Funcionario procurarFuncionario(String cpf) throws ClienteNaoEncontradoException{
		Funcionario funcionario = null;

		for(int i = 0; i < index; i++){
			if(arrayFuncionario[i].getCpf().equals(cpf)){
				funcionario = arrayFuncionario[i];
				i = index;
			}
			if(funcionario == null){
				throw new ClienteNaoEncontradoException();
			}
		}
		return funcionario;

	}
	public Funcionario removeFuncionario(String cpf) throws FuncionarioNaoEncontradoException{
		Funcionario funcionario = null;
		for(int i = 0; i < index; i++){
			if(arrayFuncionario[i].getCpf().equals(cpf)){
				funcionario = arrayFuncionario[i];
				i = index;
				index--;
				arrayFuncionario[i] = arrayFuncionario[index];
			}
			if(funcionario == null){
				throw new FuncionarioNaoEncontradoException();
			}
		}
		return funcionario;
	}
	
	public void funcioarioLogando(String email, String senha) throws LoginInvalidoException{
		boolean logado = false;
		
		for (int i = 0; i < index; i++){
			if(arrayFuncionario[i].getEmail().equals(email) && arrayFuncionario[i].getSenha().equals(senha)){
				logado = true;
				i = index;
			}
			if(!logado){
				throw new LoginInvalidoException();
			}
		}
	}
	
}
