package classes_livraria;

public class Livro {
	private String autor;
	private String editora;
	private String titulo;	
	private int edicao;
	private int periodo;
	private double preco;
	private int codigo;
	private boolean disponivel;
	private int quantidade;
		
	public Livro(String autor, String editora, String titulo, int edicao, int periodo, double preco, int codigo, boolean disponivel, int quantidade){
		
		this.autor = autor;
		this.editora = editora;
		this.titulo = titulo;
		this.edicao = edicao;
		this.periodo = periodo;
		this.preco = preco;
		this.codigo = codigo;
		this.quantidade = quantidade;
	}
	
	

}
