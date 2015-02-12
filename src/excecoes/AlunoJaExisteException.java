package excecoes;

public class AlunoJaExisteException extends Exception {
	public AlunoJaExisteException(){
		super("Cliente já cadastrado");
	}

}
