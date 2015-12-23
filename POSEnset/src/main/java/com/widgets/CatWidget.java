package com.widgets;

import com.entities.Categorie;
import com.models.GRessource;

import java.awt.*;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class CatWidget extends JPanel {

    Categorie categorie;
    private static CatWidget selected;
    private MyLabel lblImg;

    public CatWidget(Categorie categorie) {
        this.categorie = categorie;
        initComponent();

    }

    private void initComponent() {
        this.setLayout(new MigLayout("fillx"));
        lblImg = new MyLabel(GRessource.getIcon("open_folder.png", 40));
        if(categorie.getImage() != null){
        	this.setLblImg(categorie.getImage());
        }
        	this.add(lblImg);
        this.add(new MyLabel(categorie.getNom()));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1, color2;
        color1 = new Color(195, 195, 195);
        color2 = new Color(162, 241, 150);

        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        if (selected==this) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(4));
            g2d.drawRoundRect(0, 0, getWidth(), getHeight(), 9, 9);
        }
    }

    public void setSelected(CatWidget selected) {
        this.selected = selected;
    }

   

    public Categorie getCategorie() {
        return categorie;
    }

    
    public void setLblImg(byte[] bytes) {
    	this.lblImg.setIcon(new ImageIcon(bytes));
	}
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}
