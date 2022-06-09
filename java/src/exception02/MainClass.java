package exception02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainClass {
    public static void main(String[] args) {
        // NullPointerException
        String str = null;

        try{
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("str 은 null 입니다.");
            str = "Hello :D"; // 권장X
        }

        System.out.println("str = " + str);

        // ArrayIndexOutOfBoundsException;

        int arr[] = { 1, 2, 3 };

        try {
            arr[3] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }

        // FileNotFoundException
        File file = new File("./hello-world");
        FileInputStream is;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // NumberFormatException
        try {
            int num = Integer.parseInt("123.123");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
