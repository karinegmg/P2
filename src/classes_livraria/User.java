package classes_livraria;

public class User {
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String sexo;
	
	public User (String nome, String cpf, String email, String senha, String sexo){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	

}
