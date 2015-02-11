package excecoes;

public class ClienteJaExisteException extends Exception {
	public ClienteJaExisteException(){
		super("Cliente já cadastrado");
	}

}
