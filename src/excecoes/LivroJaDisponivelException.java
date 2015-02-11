package excecoes;

public class LivroJaDisponivelException extends Exception {
	
	public LivroJaDisponivelException(){
		super("Livro já disponível!");
	}

}
