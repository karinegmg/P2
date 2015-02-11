package repositorios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import classes_livraria.Livro;
import excecoes.AlgumCampoNaoPreenchidoException;
import excecoes.LivroIndisponivelException;
import excecoes.LivroJaDisponivelException;
import excecoes.LivroNaoCadastradoException;

public class RepositorioLivro {
	private Livro [] arrayLivro;
	private int index;

	public RepositorioLivro(){
		arrayLivro = new Livro[10000];
	}

	public Livro addLivro(String autor, String editora, String titulo, int edicao, int periodo, double preco, String codigo, boolean disponivel) throws AlgumCampoNaoPreenchidoException{
		Livro novoLivro = null;

		if(autor.equals("") || editora.equals("") || titulo.equals("") || codigo.equals("")){
			throw new AlgumCampoNaoPreenchidoException();
		}
		else{
			novoLivro = new Livro(autor, editora, titulo, edicao, periodo, preco, codigo, disponivel);
			arrayLivro [index] = novoLivro;
			index++;
		}

		return novoLivro;
	}

	public Livro pesquisarByTitulo(String titulo) throws LivroNaoCadastradoException{

		Livro livro = null;

		for (int i = 0; i < index; i++){
			if(arrayLivro[i].getTitulo().equals(titulo));

			livro = arrayLivro[i];
			i = index;
		}
		if(livro == null){
			throw new LivroNaoCadastradoException();
		}
		return livro;
	}

	public void removerLivro(String codigo) throws LivroNaoCadastradoException{
		Livro livro = null;

		for(int i = 0; i < index; i++){
			if(arrayLivro[i].getCodigo().equals(codigo)){
				livro = arrayLivro[i];
				i = index;
				index = index - 1;
				arrayLivro[i] = arrayLivro[index];

			}
			if(livro == null){
				throw new LivroNaoCadastradoException();
			}


		}
	}

	public void pegarLivroEmprestado(String titulo) throws LivroNaoCadastradoException, LivroIndisponivelException{
		Livro livro = this.pesquisarByTitulo(titulo);
		if(livro.isDisponivel()){
			livro.setDisponivel(false);
		}else{
			throw new LivroIndisponivelException();
		}
	}

	public void devolverLivro(String titulo) throws LivroNaoCadastradoException, LivroJaDisponivelException{
		Livro livro = pesquisarByTitulo(titulo);

		if(livro.isDisponivel()){
			throw new LivroJaDisponivelException();
		}

	}
	
	



}
