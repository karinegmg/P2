package repositorios;

import classes_livraria.Aluno;
import excecoes.AlgumCampoNaoPreenchidoException;
import excecoes.AlunoNaoEncontradoException;
import excecoes.LoginInvalidoException;
import excecoes.SexoEmFormatoIncorretoException;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 


public class RepositorioAluno {

	private Aluno [] arrayAluno;
	private int index;

	public RepositorioAluno(){
		arrayAluno = new Aluno[1000];
		index = 0;
	}

	public Aluno AddAluno(String nome, String cpf, String email, String sexo, String curso) throws SexoEmFormatoIncorretoException, AlgumCampoNaoPreenchidoException{
		Aluno novoAluno = null;

		if(nome.equals("") || cpf.equals("") || email.equals("") || curso.equals("")){
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
		novoAluno = new Aluno(nome,cpf,email, sexo, curso);
		arrayAluno[index] = novoAluno;
		index++;

		return novoAluno;
	}

	public Aluno procurarAluno(String cpf) throws AlunoNaoEncontradoException{
		Aluno aluno = null;

		for(int i = 0; i < index; i++){
			if(arrayAluno[i].getCpf().equals(cpf)){
				aluno = arrayAluno[i];
				i = index;
			}
			if(aluno == null){
				throw new AlunoNaoEncontradoException();
			}
		}
		return aluno;

	}
	public Aluno removerAluno(String cpf) throws AlunoNaoEncontradoException{
		Aluno aluno = null;
		for(int i = 0; i < index; i++){
			if(arrayAluno[i].getCpf().equals(cpf)){
				aluno = arrayAluno[i];
				arrayAluno[i] = null;
				i = index;
			}
			
		}
		if(aluno == null){
			throw new AlunoNaoEncontradoException();
		}
		return aluno;
	}
	
//	public void alunoLogando(String email, String senha) throws LoginInvalidoException{
//		boolean logado = false;
//		
//		for (int i = 0; i < index; i++){
//			if(arrayAluno[i].getEmail().equals(email) && arrayAluno[i].getSenha().equals(senha)){
//				logado = true;
//				i = index;
//			}
//			if(!logado){
//				throw new LoginInvalidoException();
//			}
//		}
//	}
	
//	public void insereAlunoNoArquivo(String path) throws FileNotFoundException, IOException{
//		BufferedReader bfr = new BufferedReader(new FileReader(path));
//		BufferedWriter bfw = new BufferedWriter(new FileWriter(path));
//		
//		
//
//	}
	
	public void listarAlunos(){

		for (int i = 0; i < arrayAluno.length; i++){
			if(arrayAluno[i] != null){
				System.out.println(arrayAluno[i]);
			} 
		}
	}

}
