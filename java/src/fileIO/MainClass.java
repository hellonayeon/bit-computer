package fileIO;

import java.io.File;

public class MainClass {
    public static void main(String[] args) throws Exception {
        /*
         * 저장매체: 파일, Database
         *
         * *.java *.cpp *.dll *.lib
         *        *.jar
         *        *.xml
         *        *.json
         *
         * 가장 상위 파일의 확장자: *.txt
         *
         * dll = Dynamic Link Library -> 동적 파일
         *
         * program -> 1 -> 2 -> 3
         *           dll
         *
         * lib = Library -> 정적 파일
         *
         * program -> 1 -> 2 -> 3
         *  lib
         *
         * */

//        File file = new File("./");
//
//        File fileList[] = file.listFiles();
//
//        for (int i=0; i<fileList.length; i++) {
//            if (fileList[i].isFile()) {
//                System.out.println("[파일]" + fileList[i].getName());
//            }
//            else if (fileList[i].isDirectory()) {
//                System.out.println("[폴더]" + fileList[i].getName());
//            }
//            else {
//                System.out.println("[?]" + fileList[i].getName());
//            }
//        }

        // 파일 생성
        File newfile = new File("./newfile.txt"); // 파일 포인터 생성

        if (newfile.createNewFile()) {
            System.out.println("파일 생성 성공!");
        }
        else {
            System.out.println("파일 생성 실패~");
        }

        // 폴더 생성
        File newDir = new File("./sub-dir");
        if (newDir.mkdir()) {
            System.out.println("폴더 생성 성공!");
        }
        else {
            System.out.println("폴더 생성 실패~");
        }

        // 여러 폴더 생성
        File newDirs = new File("./dir");
        if (newDirs.mkdirs()) { // 여러 폴더 한 번에 생성
            System.out.println("폴더 생성 성공!");
        }
        else {
            System.out.println("폴더 생성 실패~");
        }

        // 파일 존재 여부
        if (newfile.exists()) {
            System.out.println("\'" + newfile.getName() + "\'" + " 파일이 존재합니다.");
        }

        // 읽기 전용
//        newfile.setReadOnly(); // rw-r--r-- -> r--r--r--

        // 쓰기 전용
        newfile.setWritable(true);

        // 삭제
        newfile.delete(); // return boolean

    }
}
