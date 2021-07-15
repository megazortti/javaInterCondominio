package model; 

public class Pessoa {

	private String cpf, nome_completo;
  private String dataNascimento;
	public enum sexo {
		Feminino, Masculino;
	}
        private sexo currentSexo;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome_completo() {
		return nome_completo;
	}
	
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
        public String getDataNascimento() {
            return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
	}
        public sexo getSexo(){
            return this.currentSexo;
        }
        public void setSexo(sexo sex){
            this.currentSexo = sex;
        }
	
	
	
}
