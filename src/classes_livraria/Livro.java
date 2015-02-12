package classes_livraria;

public class Livro {
	private String autor;
	private String editora;
	private String titulo;	
	private int edicao;
	private int periodo;
	private double preco;
	private String codigo;	
	private boolean disponivel;
		
	public Livro(String autor, String editora, String titulo, int edicao, int periodo, double preco, String codigo, boolean disponivel){
		
		this.autor = autor;
		this.editora = editora;
		this.titulo = titulo;
		this.edicao = edicao;
		this.periodo = periodo;
		this.preco = preco;
		this.codigo = codigo;
		this.disponivel = true;
		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	

	@Override
	public String toString() {
		return "Autor: " + autor + ", Editora: " + editora + ", Titulo: "
				+ titulo + ", Edicao: " + edicao + ", Periodo: " + periodo
				+ ", Preco: " + preco + ", Codigo: " + codigo + ", Disponivel: "
				+ disponivel;
	}
	
	
	

}
