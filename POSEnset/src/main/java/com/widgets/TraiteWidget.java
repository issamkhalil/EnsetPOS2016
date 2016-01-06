/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author elmottaki
 */
public class TraiteWidget extends JPanel {

    JSpinner spiner;
    private int nombre = 0;
    ArrayList<Tranche> listTranche;
    JDialog parent;
    private JPanel panelTranche;
    double total;

    public double getTotal() {
        return total;
    }
   public Integer getNbrTraite(){
       return (Integer) spiner.getValue();
   }
   
    public void setTotal(double total) {
        this.total = total;
    }
    public TraiteWidget(JDialog parent,double total) {
        this.parent = parent;
        this.total = total;
        listTranche = new ArrayList<Tranche>();
        init();

    }
    
    public double[] getTraites(){
        double[] tr = new double[listTranche.size()];
        for(int i=0;i<listTranche.size();i++){
            tr[i] = listTranche.get(i).getVal();
        }
        return tr;
    }

    public void init() {
        setLayout(new MigLayout());
        spiner = new JSpinner();
        spiner.setValue(1);
        spiner.setModel(new SpinnerNumberModel(1, 1, 9, 1));
        this.add(new MyLabel("Nombre de Tranches"));
        this.add(spiner, "w 70px,wrap");
        panelTranche = new JPanel(new MigLayout());
        this.add(panelTranche);
        addTranche();
        spiner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if((Integer)spiner.getValue()>nombre){
                    addTranche();
                }
                else{
                    delTranche();
                }
            }
        });
        

    }

    protected class Tranche extends JPanel {

        int index;
        private JButton btnAdd;
        private MyText txtVal;

        public Tranche(int index) {
            this.index = index;
            initComponent();
        }

        public void initComponent() {
            this.setLayout(new MigLayout("insets 0 0 0 0"));
            this.add(new MyLabel("Tranche " + index + ":", 12));
            txtVal = new MyText("0");
            txtVal.setEditable(false);
            txtVal.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {
                    MyText source = (MyText) e.getSource();
                    double prix = 0;
                    int temp = 0;
                    if ((source).getText().equals("")) {
                        source.setText("0");
                    }
                    for (int i = 0; i < listTranche.size(); i++) {
                        if (!listTranche.get(i).txtVal.getText().equals("")) {
                            prix = prix + listTranche.get(i).getVal();
                        }
                        if (listTranche.get(i).txtVal == source) {
                            temp = i;
                        }
                    }
                    prix = (total - prix);
                    prix = floor(prix);
                    double val;
                    if (listTranche.size() > (temp + 1)) {
                        listTranche.get(temp + 1).txtVal.setText(floor(Double.parseDouble(listTranche.get(temp + 1).txtVal.getText()) + prix) + "");
                        if (listTranche.get(temp + 1).getVal() < 0) {
                            source.setText(floor(Double.parseDouble(listTranche.get(temp).txtVal.getText()) + listTranche.get(temp + 1).getVal()) + "");
                            listTranche.get(temp + 1).setText("0");
                        }
                    } else {
                        source.setText(floor(Double.parseDouble(listTranche.get(temp).txtVal.getText()) + prix) + "");
                    }

                }
            });
            this.add(txtVal, "w 100px");
            this.add(new MyLabel("DH", 12));
        }

        public double getVal() {
            return Math.floor(Double.parseDouble(txtVal.getText()) * 100) / 100;
        }

        public void setText(String txt) {
            txtVal.setText(txt);
        }

        public int getIndex() {
            return index;
        }
    }

    public double floor(double val) {
        return Math.floor(val * 100) / 100;
    }

    private void addTranche() {
        nombre++;
        Tranche tr = new Tranche(nombre);
        listTranche.add(tr);
        panelTranche.add(tr, "wrap");
        panelTranche.repaint();
        panelTranche.revalidate();
        //spiner.setValue(nombre);
        listTranche.get(listTranche.size() - 1).txtVal.setEditable(true);
        parent.pack();
    }

    private void delTranche() {
        if (nombre > 1) {
            Tranche tr = listTranche.get(nombre - 1);
            panelTranche.remove(tr);
            listTranche.remove(tr);
            nombre--;
            //spiner.setValue(nombre);
            panelTranche.revalidate();
            parent.pack();
        }
    }
}
