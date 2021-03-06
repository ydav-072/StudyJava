package ru.study;

import java.io.*;

public class WorkWithFile {
    public static void main(String[] args) {
        File path = new File("temp");
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
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }


            //copy in new file
            File fileCopy = new File(path + "\\copyText1.txt");
            fileCopy.createNewFile();
            FileWriter fileWriterCopy = new FileWriter(fileCopy);
            BufferedWriter bufferedWriterCopy = new BufferedWriter(fileWriterCopy);
            while (bufferedReader.ready()){
                bufferedWriterCopy.write(bufferedReader.readLine());
                bufferedWriterCopy.newLine();
                bufferedWriterCopy.flush();
            }

            bufferedWriterCopy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
