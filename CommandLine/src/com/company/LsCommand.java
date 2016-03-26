package com.company;

import java.io.File;

/**
 * Created by alexandra on 25.3.16.
 */
public class LsCommand {

    public void printHelp() {
        System.out.println(getDescription());
    }

    public boolean lsCommand(javax.naming.Context context, String... args) {
        if (args == null) {
            // print current directory content
//            printDir(context.currentDirectory);
        } else {
            // print specified directory content
            // todo
        }
        return true;
    }

    public String getName() {
        return "DIR";
    }

    private void printDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
    }

    public String getDescription() {
        return "Prints directory content";
    }
}


