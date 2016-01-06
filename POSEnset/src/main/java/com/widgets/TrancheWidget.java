package com.widgets;

import com.beans.AwsomeIconConst;
import com.entities.Categorie;
import com.entities.Tranche;
import com.models.AwsomeIcon;
import com.models.GRessource;
import controlors.traitesControlor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class TrancheWidget extends JPanel {

    Tranche tranche;
    private static TrancheWidget selected;
    private MyLabel lblImg;
    private MyButton btnValider;
    private JPanel parent;

    public TrancheWidget(Tranche tranche, JPanel parent) {
        this.tranche = tranche;
        this.parent = parent;
        initComponent();

    }

    private void initComponent() {
        this.setLayout(new MigLayout("fillx"));
        lblImg = new MyLabel(GRessource.getIcon("database.png", 40));
        this.add(lblImg);
        this.add(new MyLabel(tranche.getSomme() + ""));
        this.add(new MyLabel(new SimpleDateFormat("dd-MM-yyyy").format(tranche.getDatePayment())));
        btnValider = new MyButton("Valider", new AwsomeIcon(AwsomeIconConst.VALIDE_ICON, 24));
        this.add(btnValider);

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                trancheClickedAction();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validerTrancheAction();
            }
        });

    }
    public void validerTrancheAction(){
        try{
        traitesControlor.validerTranche(tranche);
        this.repaint();
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur",JOptionPane.ERROR_MESSAGE );
        }
    }
    public void trancheClickedAction() {
        this.setSelected(this);
        for (int i = 0; i < parent.getComponentCount(); i++) {
            parent.getComponents()[i].repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1, color2;
        if (tranche.isPaye()) {
            color1 = new Color(181, 186, 196);
            color2 = new Color(181, 186, 196);
            btnValider.setEnabled(false);
        } else {
            color1 = new Color(195, 195, 195);
            color2 = new Color(162, 241, 150);
            btnValider.setEnabled(true);
        }

        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        if (selected == this) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(4));
            g2d.drawRoundRect(0, 0, getWidth(), getHeight(), 9, 9);
        }
    }

    public void setSelected(TrancheWidget selected) {
        this.selected = selected;
    }

    public Tranche getCategorie() {
        return tranche;
    }

    public void setLblImg(byte[] bytes) {
        this.lblImg.setIcon(new ImageIcon(bytes));
    }

    public void setCategorie(Tranche categorie) {
        this.tranche = categorie;
    }

}
