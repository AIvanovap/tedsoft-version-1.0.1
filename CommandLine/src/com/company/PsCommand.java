package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by alexandra on 25.3.16.
 */
public class PsCommand {
    private static String nameProcess;

    public void psCommand() {
        Process p = null;
        System.out.println("Please, enter the name process :  ");
        Scanner scanner = new Scanner(System.in);
        nameProcess = scanner.nextLine();
        if(System.getProperty("os.name").equals("Linux")) {
            getLineLinux(p, nameProcess);
        }else if(System.getProperty("os.name").equals("Windows")){

        }

    }

    private void getLineLinux(Process p, String name){
        try {
            p = Runtime.getRuntime().exec("ps -C "+nameProcess);
            writeLne(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeLne(Process p){
        String line;
        BufferedReader input =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        try {
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getLineWindows(Process p){
        try {
            p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            writeLne(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
