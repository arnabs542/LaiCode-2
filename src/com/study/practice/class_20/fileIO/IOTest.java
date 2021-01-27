package com.study.practice.class_20.fileIO;

import java.io.*;

public class IOTest {
  public static void main(String[] args) throws IOException {
    IOTest.readFile();
    IOTest.readFileLines();
    IOTest.readFileBytes();
    IOTest.directoryOperations();
  }

  // Character streams - unicode
  private static void readFile() throws IOException {
    FileReader in = null;
    FileWriter out = null;
    try {
      in = new FileReader("src/com/study/practice/class_20/IO/input.txt");
      out = new FileWriter("src/com/study/practice/class_20/IO/output1.txt");
      int c;
      while ((c = in.read()) != -1) {
        System.out.print((char)c);
        out.write(c);
      }
    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }

  // Byte Streams, 文件没变，但是read是8-bit byte。
  private static void readFileBytes() throws IOException {
    FileInputStream in = null;
    FileOutputStream out = null;
    try {
      in = new FileInputStream("src/com/study/practice/class_20/IO/input.txt");
      out = new FileOutputStream("src/com/study/practice/class_20/IO/output2.txt");
      int c;
      while ((c = in.read()) != -1) { // 读出来是8-bit byte, 放入int里。
        System.out.print((char)c); // 再转换成char（2 byte)
        out.write(c);
      }
    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }

  // BufferReader, 方便一次读一行
  public static void readFileLines() throws IOException {
    FileReader in = null;
    try {
      in = new FileReader("src/com/study/practice/class_20/IO/input.txt");
      BufferedReader br = new BufferedReader(in);
      while (true) {
        String line = br.readLine();
        if (line == null) {
          break;
        }
        System.out.println(line);
      }
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }

  // File (get the list of files + Directories)
  private static void directoryOperations() throws IOException {
    String dir = "G:\\LaiCode\\src\\com\\study\\practice\\class_20\\IO";
    File d = new File(dir);
    String[] paths = d.list();
    for (String p : paths) {
      System.out.println(p);
    }

    File d2 = new File("src/com/study/practice/class_20/IO/newDir");
    d2.mkdirs();

    // delete the two output txt
//    File f1 = new File("src/com/study/practice/class_20/IO/output1.txt");
//    f1.delete();
//    File f2 = new File("src/com/study/practice/class_20/IO/output2.txt");
//    f2.delete();
  }
}
