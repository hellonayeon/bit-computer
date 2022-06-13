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

    public void setList(List<Socket> list) {
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
                if (str == null) {
                    // 클라이언트가 종료했으므로 담당 socket 을 관리할 필요 X
                    list.remove(socket);
                    throw new ClientExitException();
                }

                // 송신 (send)
                // 자기 자신을 제외한 다른 모든 클라이언트에게 메시지 송신
                for (Socket s : list) {
                    if (s != socket) {
                        PrintWriter writer = new PrintWriter(s.getOutputStream());
                        writer.println(str);
                        writer.flush();
                    }
                }

                Thread.sleep(300);
            }
        } catch (Exception e) {
            System.out.println("연결이 끊긴 IP: " + socket.getInetAddress());
            list.remove(socket);

            // 접속되어 있는 남아있는 클라이언트 출력
            list.forEach(s ->
                    System.out.println("접속되어 있는 IP: " + s.getInetAddress()
                            + ", Port: " + s.getPort()));

            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
