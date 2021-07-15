/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author mazzo
 */
public class _Morador {
    private final SimpleStringProperty nome;
    public _Morador(SimpleStringProperty nome){
        this.nome = nome;
    }
}
