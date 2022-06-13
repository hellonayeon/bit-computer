package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread {

    Socket socket; // 담당자 (not 문지기)
    List<Socket> list;

    public ServerThread(Socket socket, List<Socket> list) {
        this.socket = socket;
        this.list = list;
    }

    @Override
    public void run() {
        super.run();

        try {

            while (true) {
                // 수신 (receive)
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = reader.readLine();
                System.out.println("[client 메시지]: " + str);

                // 송신 (send)
                str = "반값습니다 \\' \'/: " + str;

                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(str);
                writer.flush();

                Thread.sleep(300);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
