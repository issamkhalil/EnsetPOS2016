/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import com.beans.AwsomeIconConst;
import com.entities.Produit;
import com.models.AwsomeIcon;
import com.models.GRessource;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

/**
 *
 * @author KASPAROV
 */
public class ProduitWidget extends JLabel {
    Produit produit;
    private static ProduitWidget selected;
    public ProduitWidget(Produit produit){
        this.produit = produit;
        this.setIcon(GRessource.getIcon("Product.png", 70));
        if(produit.getImage() != null){
        	this.setLblImg(produit.getImage());
        }
        setText(produit.getDesigniation());
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM); 
        this.setBackground(new Color(200, 200, 200));
        this.setOpaque(true);
    }
    
    public void setSelected(ProduitWidget selected) {
        this.selected = selected;
        setBorder();
    }
    public void setBorder(){
        if(selected==this){
            this.setBorder(BorderFactory.createLineBorder(Color.black));
        }
        else{
            setBorder(null);
        }
    }
    

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    public void setLblImg(byte[] bytes) {
    	this.setIcon(new ImageIcon(bytes));
	}

    public Produit getProduit() {
        return produit;
    }

    
    
}
