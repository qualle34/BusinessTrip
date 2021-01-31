package com.qualle.trip.service.util;

import com.qualle.trip.Application;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.core.io.ClassPathResource;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@UtilityClass
public class WordUtil {

    private static final String TEMPLATE_DIR = "word/";
    private static final String REPORT_FILE_NAME = "report.docx";

    private static final String APP_FILE = "trip-1.0.jar";

    public static void createReport(String path, String name, Map<String, Object> data) {
        String file = path + getFileName("report" + name);

        try {

            XWPFDocument document = new XWPFDocument(new ClassPathResource(TEMPLATE_DIR + REPORT_FILE_NAME).getInputStream());
            data.forEach((key, value) -> write(document, key, value));
            document.write(new FileOutputStream(file));
            Desktop.getDesktop().open(new File(file));

        } catch (IOException e) {
            log.warn("Create report exception: {}", e.getMessage(), e);
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

    public static String getPath() throws UnsupportedEncodingException {
        String path = null;

        try {
            path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "utf-8");
            return "/" + path.substring(6, path.lastIndexOf(APP_FILE));

        } catch (IndexOutOfBoundsException e) {
            log.warn("Unable to get path ({}): {}", path, e.getMessage(), e);
            throw e;
        }
    }

    private static String getFileName(String type) {
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        return type + "_" + dateFormat.format(new Date()) + ".docx";
    }
}
