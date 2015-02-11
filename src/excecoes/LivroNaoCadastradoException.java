package excecoes;

public class LivroNaoCadastradoException extends Exception {
	
	public LivroNaoCadastradoException(){
		super("Livro não cadastrado.");
	}

}
