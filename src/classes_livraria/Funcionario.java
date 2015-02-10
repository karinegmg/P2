package classes_livraria;
import classes_livraria.User;

public class Funcionario extends User{
	private double salario;
	
	public Funcionario (String nome, String cpf, String email, String senha, String sexo){
		super(nome, cpf, email, senha, sexo);
		this.salario = salario;
		
	}
	public void setSalario(double salario){
		this.salario = salario;
	}
	public double getSalario() {
		return salario;
	}


}
