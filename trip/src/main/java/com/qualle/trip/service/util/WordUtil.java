package com.qualle.trip.service.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class WordUtil {

    public static void createReport(String targetPath, String templatePath, Map<String, Object> data) {

        try {
            XWPFDocument template = getTemplate(templatePath);
            fillTemplate(template, data);
            template.write(new FileOutputStream(targetPath));
            Desktop.getDesktop().open(new File(targetPath));

        } catch (IOException e) {
            log.warn("Create report exception: {}", e.getMessage(), e);
        }
    }

    private static XWPFDocument getTemplate(String templatePath) throws IOException {
        FileInputStream stream = new FileInputStream(templatePath);
        return new XWPFDocument(stream);
    }

    private static void fillTemplate(XWPFDocument template, Map<String, Object> data){
        data.forEach((key, value) -> write(template, key, value));
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
}
