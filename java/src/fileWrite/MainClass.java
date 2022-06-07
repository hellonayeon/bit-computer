package fileWrite;

import java.io.*;

public class MainClass {
    public static void main(String[] args) throws IOException {

        File file = new File("./newfile.txt");
// Users
//        FileWriter fWriter;
//
//        fWriter = new FileWriter(file);
//        fWriter.write("hello" + "\n");
//        fWriter.write("안녕하세요 :D");
//        fWriter.close(); // FIXME close() 없으면 제대로 동작X - 기존에 있는 파일이 덮어쓰기 되므로 주의
//
//        // 추가 기입
//        fWriter = new FileWriter(file, true);
//        fWriter.write("반갑습니다 :D");
//        fWriter.close();

        // 성능적으로 더 우수
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        pw.println("안녕하세요 !!");
        pw.println("Hello");
        pw.println("반갑습니다 !!");
        pw.close();

    }
}
