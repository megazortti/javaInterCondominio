package model;

public class Morador extends Pessoa{
        private int numCasa;
        private int id;
	private String dataNascimento;
	public enum tipoMorador{
		Proprietário, Morador, Inquilino;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
        public void setNumCasa(int numCasa){
            this.numCasa = numCasa;
        }
        public int getNumCasa(){
            return this.numCasa;
        }
        public void setId(int id){
            this.id=id;
        }
        public int getId(){
            return this.id;
        }
        
}
