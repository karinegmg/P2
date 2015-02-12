package classes_livraria;
import classes_livraria.User;

public class Aluno extends User {

	private String curso;

	public Aluno(String nome, String cpf, String email, String sexo, String curso){
		super(nome, cpf, email, sexo);
		this.curso = curso;

	}
	
	

	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Email: " + getEmail()
				+  ", Sexo: " + getSexo() +", Curso: "+curso;
	}


}
