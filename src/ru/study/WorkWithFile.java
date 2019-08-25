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
            File fileCopy = new File(path + "\\copyText.txt");
            fileCopy.createNewFile();
            FileWriter fileWriter1 = new FileWriter(fileCopy);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            while (bufferedReader.ready()){
                bufferedWriter1.write(bufferedReader.readLine());
                bufferedWriter1.newLine();
                bufferedWriter1.flush();
            }

            bufferedWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
