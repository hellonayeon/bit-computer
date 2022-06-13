import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. 접속을 해야 할 Server IP(주소)를 설정 -> Socket
        InetSocketAddress socketAddr = new InetSocketAddress("192.168.0.99", 9000);

        // 2. Socket 생성
        Socket socket = new Socket();

        try {
            // 3. Connect
            socket.connect(socketAddr, 10000);

            InetAddress inetAddr;
            if ((inetAddr = socket.getInetAddress()) != null) {
                System.out.println("서버 접속 성공 :)");
            }
            else {
                System.out.println("서버 접속 실패 :(");
            }

            while (true) {
                // 4. Packet 송수신
                // 송신 (send)
                System.out.print("[client 메시지]: ");
                String str = sc.next();

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(str);
                writer.flush();

                // 수신 (receive)
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                str = reader.readLine();

                System.out.println("[server 메시지]: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
