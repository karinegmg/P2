package excecoes;

public class LivroIndisponivelException extends Exception {
	
	public LivroIndisponivelException(){
		super("Livro encontra-se indisponível");
	}

}
