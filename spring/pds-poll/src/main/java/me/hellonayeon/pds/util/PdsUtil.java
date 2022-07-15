package me.hellonayeon.pds.util;

import java.util.Date;

public class PdsUtil {

    public static String getNewFileName(String filename) {
        String newfilename = "";
        String ext = "";

        if (filename.indexOf(".") >= 0) {
            ext = filename.substring(filename.indexOf('.'));

            newfilename = new Date().getTime() + ext;
        }
        else {
            newfilename = new Date().getTime() + ".back";
        }

        return newfilename;
    }

}
