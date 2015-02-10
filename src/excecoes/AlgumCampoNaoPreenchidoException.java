package excecoes;

public class AlgumCampoNaoPreenchidoException extends Exception{
	
	public AlgumCampoNaoPreenchidoException(){
		super("Preencha todos os campos, por favor.");
	}

}
