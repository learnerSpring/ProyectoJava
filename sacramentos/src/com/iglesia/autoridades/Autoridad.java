/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iglesia.autoridades;


public class Autoridad {
  int id = 0;
  String st_auto = "";
  String st_nom_auto = "";
  
    public void Autoridad(){}

    public int getId(){
      return id;
    }
    
    public void setId(int pid){
        this.id = pid;
    }
    
    public String getSt_auto() {
        return st_auto;
    }

    public void setSt_auto(String st_auto) {
        this.st_auto = st_auto;
    }

    public String getSt_nom_auto() {
        return st_nom_auto;
    }

    public void setSt_nom_auto(String st_nom_auto) {
        this.st_nom_auto = st_nom_auto;
    }
    
}
