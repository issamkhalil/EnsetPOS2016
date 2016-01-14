/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.beans.Constants;
import com.entities.Vente;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.views.Main;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;
import org.jsoup.select.Evaluator;



/**
 *
 * @author EL MOTTAKI
 */

public class PdfFactory {



    public static void createRecu(Vente vente, File fout) throws IOException, FileNotFoundException, IHtmlToPdfTransformer.CConvertException {
        Document document = Jsoup.parse(new File(ClassLoader.getSystemClassLoader().getResource("templates/"+Constants.HTML_RECU).getFile()), "UTF-8", "http://ensetpos.com/");
        Element idVente = document.getElementById("idVente");
        idVente.appendText(vente.getId()+"");
        Element date = document.getElementById("date");
        date.appendText(new SimpleDateFormat().format(vente.getDate()));
        Element client = document.getElementById("client");
        client.appendText(vente.getClient().getNom());
        Element caissier = document.getElementById("caissier");
        caissier.appendText(Main.compte.getNom());
        Element nbrProduit = document.getElementById("nbr_produit");
        nbrProduit.appendText(vente.getLignsVente().size()+"");
        Element total = document.getElementById("total");
        total.appendText(vente.getTotale()+"");
        StringBuilder html = new StringBuilder();
        for(int i = 0;i<vente.getLignsVente().size();i++){
            html.append("<tr>\n" +
"            <th>"+vente.getLignsVente().get(i).getProduit().getDesigniation()+"</th>\n" +
"            <th>"+vente.getLignsVente().get(i).getQuantite()+"</th>\n" +
"            <th>"+vente.getLignsVente().get(i).getProduit().getPrixVente()+"</th>\n" +
"        </tr>");
        }
        Element table = document.getElementById("table");
        table.appendText(html.toString());
        HtmlToPDF.convert(document.toString(), fout);
    }





}
