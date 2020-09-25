package ru.study;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File path = new File("temp2");
        File file = new File(path + "\\text.txt");
        path.mkdir();
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("stroke1");
            bufferedWriter.newLine();
            bufferedWriter.write("stroke2");
            bufferedWriter.newLine();
            bufferedWriter.write("stroke3");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.read();

            File fileCopy = new File(path + "\\textCopy.txt");
            fileCopy.createNewFile();
            FileWriter fileWriterCopy = new FileWriter(fileCopy);
            BufferedWriter bufferedWriterCopy = new BufferedWriter(fileWriterCopy);
            while (bufferedReader.ready()){
                bufferedWriterCopy.write(bufferedReader.read());
            }
            bufferedWriterCopy.flush();
            bufferedReader.close();
            bufferedWriterCopy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
