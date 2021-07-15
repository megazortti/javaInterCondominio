package model;

public class Morador extends Pessoa{
        private int numCasa;
        private int id;
	private String dataNascimento;
	public enum tipoMorador{
		Proprietário, Morador, Inquilino;
	}
        public tipoMorador tipo_morador;
	
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
        public void setTipoMorador(String _tipoMorador){
            if(_tipoMorador == "Proprietário"){
                this.tipo_morador = tipoMorador.Proprietário;
            }else if (_tipoMorador == "Inquilino"){
                this.tipo_morador = tipoMorador.Inquilino;
            }else{
                this.tipo_morador = tipoMorador.Morador;
            }
        }
        public String getTipoMorador(){
            return this.tipo_morador.toString();
        }
        
}
