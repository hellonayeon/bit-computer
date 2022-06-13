package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread {

    Socket socket; // 담당자 (not 문지기)
    List<Socket> clients;

    public ServerThread(Socket socket, List<Socket> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void setList(List<Socket> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        super.run();

        try {

            while (true) {
                // 수신 (receive)
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = reader.readLine();
//                System.out.println("[client 메시지]: " + str);

                // 송신 (send)
                // 자기 자신을 제외한 다른 모든 클라이언트에게 메시지 송신
                for (Socket client : clients) {
                    if (client.equals(socket)) {
                        continue;
                    }

                    PrintWriter writer = new PrintWriter(client.getOutputStream());
                    writer.println(str);
                    writer.flush();
                }

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
