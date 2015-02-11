package excecoes;

public class TipoDeUsuarioNaoValidoException extends Exception {
	
	public TipoDeUsuarioNaoValidoException(){
		System.out.println("Erro: Escolha uma opção válida.");
	}

}
