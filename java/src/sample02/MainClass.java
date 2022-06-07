package sample02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {

        // input (console)
        Scanner sc = new Scanner(System.in);

        // boolean
        boolean b;
        System.out.print("b = ");
        b = sc.nextBoolean();
        System.out.println("input b = " + b);


        // integer
        int num;
        System.out.print("num = ");
        num = sc.nextInt();
        System.out.println("input num = " + num);


        // double
        double d;
        System.out.print("d = ");
        d = sc.nextDouble();
        System.out.println("input d = " + d);

        // string
        String str;
        System.out.print("str = ");
        str = sc.next();
        System.out.println("input str = " + str);


        // file, network (Buffer 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("str = ");
        str = br.readLine();
        System.out.println("input str = " + str);
    }
}