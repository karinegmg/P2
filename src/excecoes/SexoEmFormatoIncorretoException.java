package excecoes;

public class SexoEmFormatoIncorretoException extends Exception{
	
	public SexoEmFormatoIncorretoException(){
		
		super("Formato incorreto! Coloque 'm' (masculino) ou 'f' (feminino)");
	}

}
