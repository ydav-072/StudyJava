package ru.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class ReadFromConsole {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while (!str.equals("exit")){
            str = scanner.nextLine();
            System.out.println(str);
        }
        
        //more comfortable for me
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sName = bufferedReader.readLine();
        String sAge = bufferedReader.readLine();
        int age = Integer.parseInt(sAge);

    }
}
