package com.qualle.trip.service.util;

import com.qualle.trip.aspect.ServiceAspect;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class WordUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    private static final String TEMPLATE_PATH = "data/template/";
    private static final String REPORT_FILE_NAME = "report.docx";

    public static void createReport(String path, String name, Map<String, Object> data) {

        try {
            XWPFDocument document = new XWPFDocument(OPCPackage.open(TEMPLATE_PATH + REPORT_FILE_NAME));
            data.forEach((key, value) -> write(document, key, value));
            document.write(new FileOutputStream(path + getFileName("report" + name)));

        } catch (IOException | InvalidFormatException e) {
            LOGGER.warn("Create report exception: " + e.getMessage(), e);
        }
    }

    private static void write(XWPFDocument document, String key, Object value) {

        for (XWPFParagraph paragraph : document.getParagraphs()) {
            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun run : runs) {
                String text = run.getText(0);
                if (text != null && text.contains("${" + key + "}") && value instanceof List) {

                    run.setText("", 0);

                    for (Object val : (List) value) {
                        run.setText(String.valueOf(val));
                        run.addBreak();
                    }
                    paragraph.setAlignment(ParagraphAlignment.LEFT);

                } else if (text != null && text.contains("${" + key + "}")) {
                    text = text.replace("${" + key + "}", String.valueOf(value));
                    run.setText(text, 0);
                }
            }
        }
    }


    private static String getFileName(String type) {
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        return type + "_" + dateFormat.format(new Date()) + ".docx";
    }
}
