/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// http://www.allcolor.org/YaHPConverter/
import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

public class HtmlToPDF {

    public HtmlToPDF(){
        
    }
    public static void convert(File htmlIn, File pdfOut) throws FileNotFoundException, IHtmlToPdfTransformer.CConvertException, IOException {
        Scanner scanner
                = new Scanner(htmlIn).useDelimiter("\\Z");
        String htmlContents = scanner.next();

        CYaHPConverter converter = new CYaHPConverter();
        FileOutputStream out = new FileOutputStream(pdfOut);
        Map properties = new HashMap();
        List headerFooterList = new ArrayList();

        properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
                IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
        //properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
        converter.convertToPdf(htmlContents,
                IHtmlToPdfTransformer.A4P,
                headerFooterList,
                "file:///temp/html/",
                out,
                properties);
        out.flush();
        out.close();
    }
        public static void convert(String html, File pdfOut) throws FileNotFoundException, IHtmlToPdfTransformer.CConvertException, IOException  {
        Scanner scanner
                = new Scanner(html).useDelimiter("\\Z");
        String htmlContents = scanner.next();

        CYaHPConverter converter = new CYaHPConverter();
        FileOutputStream out = new FileOutputStream(pdfOut);
        Map properties = new HashMap();
        List headerFooterList = new ArrayList();

        properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
                IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
        //properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
        converter.convertToPdf(htmlContents,
                IHtmlToPdfTransformer.A4P,
                headerFooterList,
                "file:///temp/html/",
                out,
                properties);
        out.flush();
        out.close();
    }
}
