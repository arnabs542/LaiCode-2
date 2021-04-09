package com.study.script;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateBigFIle {
    public static void main(String[] args) throws IOException{
        FileWriter out = null;
        try {
            out = new FileWriter("30GB.txt");
            String str = "a part of a large file. very good.";
            for (int i = 0; i < 1073741824; i++) {
                out.write(str);
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
