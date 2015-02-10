package excecoes;

public class LoginInvalidoException extends Exception{
	
	public LoginInvalidoException(){
		super("Login e/ou senha incorretos. Tente novamente.");
	}

}
