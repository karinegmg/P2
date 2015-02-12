package classes_livraria;
import classes_livraria.User;

public class Funcionario extends User{
	private String cargo;

	public Funcionario (String nome, String cpf, String email, String sexo, String cargo){
		super(nome, cpf, email, sexo);
		this.cargo = cargo;

	}
	public void setCargo(String cargo){
		this.cargo = cargo;
	}
	public String getCargo() {
		return cargo;
	}
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Email: " + getEmail()
				+  ", Sexo: " + getSexo() +", Cargo: "+cargo;
	}

}
