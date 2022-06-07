package fileRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {

        File file = new File("./newfile.txt");

        // 한 글자씩 읽기
        FileReader fr = new FileReader(file);
        int ch = fr.read();
        while (ch != -1) {
            System.out.println((char) ch);
            ch = fr.read();
        }
        fr.close();

        // 한 문장으로 읽기
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
    }
}
