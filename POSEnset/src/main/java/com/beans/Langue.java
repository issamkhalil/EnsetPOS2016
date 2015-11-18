/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

/**
 *
 * @author elmottaki
 */
public enum Langue {
    FRENCH("fr"),ENGLISH("en"),ARABE("ar");
    private String lang;  
    Langue(String lang){
        this.lang = lang;
    }
    @Override
    public String toString(){
        return lang;
    }
}
