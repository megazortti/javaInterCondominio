/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.Objeto;
import model.Morador;
import java.util.HashSet;


/**
 *
 * @author biaca
 */
public class RealizaEntrega {
    private String dataEntrega;
    private String dataRecebido;
    private String dataAtual;
    
    public RealizaEntrega(){
        //** ILUSTRATIVO        
        //this.dataAtual = DATA ATUAL 
    }
    
    public int RealizaEntrega(Objeto obj, Pessoa p){ // objeto que será entregue
       // se retornar 0, tudo correu bem.
       if(obj.getState() == "recebido"){
           // realiza entrega
           obj.setState("entregue");
           this.setDataRecebido(dataAtual);
           
           return 0;
       }else{
           // este objeto já foi entregue.
           return -1;
       }
       
    }
    public void setDataRecebido(String dataRecebido) {
        this.dataRecebido = dataRecebido;
    }
    
    
    
}