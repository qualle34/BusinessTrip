package com.qualle.trip.service.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class WordUtil {

    private static final String TEMPLATE_PATH = "data/template/";
    private static final String REPORT_FILE_NAME = "report.docx";

    public static boolean createReport(String path, Map<String, String> data) {

        try {
            XWPFDocument document = new XWPFDocument(OPCPackage.open(TEMPLATE_PATH + REPORT_FILE_NAME));
            data.forEach((key, value) -> write(document, key, value));
            document.write(new FileOutputStream(path + getFileName("report")));
            return true;

        } catch (IOException | InvalidFormatException ignore) {
            return false;
        }
    }

    private static void write(XWPFDocument document, String key, String value) {

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains("${" + key + "}")) {
                        text = text.replace("${" + key + "}", value);
                        r.setText(text, 0);
                    }
                }
            }
        }
    }

    private static String getFileName(String type){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd_hh:mm:ss");
        return type + "_" + dateFormat.format(new Date()) + ".docx";
    }
}
