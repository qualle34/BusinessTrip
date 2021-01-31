package com.qualle.trip;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class QuickTest {

    @Test
    void test() throws Exception {

        Desktop.getDesktop().open(new File("D:\\t.docx"));

        assertDoesNotThrow(this::test);
    }
}
