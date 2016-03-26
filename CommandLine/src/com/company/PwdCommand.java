package com.company;

import java.io.File;

/**
 * Created by alexandra on 25.3.16.
 */
public class PwdCommand {
    private void dirlist(String fname){
        File dir = new File(fname);
        System.out.println(dir);

    }
    public void pwdCommand(){
        String currentdir = System.getProperty("user.dir");
        dirlist(currentdir);
    }

}
