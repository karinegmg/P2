package livrariaSI;

public class Livro {
	private String autor;
	private String editora;
	private String titulo;	
	private int edicao;
	private double preco;
	private int codigo;
	private boolean disponivel;
	private int quantidade;
	
	public Livro(String autor, String editora, String titulo, int edicao, double preco, int codigo, boolean disponivel, int quantidade){
		
		this.autor = autor;
		this.editora = editora;
		this.titulo = titulo;
		this.edicao = edicao;
		this.preco = preco;
		this.codigo = codigo;
		this.quantidade = quantidade;
	}
	
	

}
