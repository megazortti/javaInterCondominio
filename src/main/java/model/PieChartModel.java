/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author mazzo
 */
    public class PieChartModel{
        private int numFuncionarios=0;
        private int numMoradores=0;
        public void initialize(PieChart pieChart){
            ObservableList<PieChart.Data> pieChartData
                        = FXCollections.observableArrayList(
                                new PieChart.Data("Funcionários",this.numFuncionarios),
                                new PieChart.Data("Moradores",this.numMoradores));
        pieChart.setData(pieChartData);
        }

        public int getNumFuncionarios() {
            return numFuncionarios;
        }

        public void setNumFuncionarios(int numFuncionarios) {
            this.numFuncionarios = numFuncionarios;
        }

        public int getNumMoradores() {
            return numMoradores;
        }

        public void setNumMoradores(int numMoradores) {
            this.numMoradores = numMoradores;
        }
    }
    
