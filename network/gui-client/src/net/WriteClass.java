package net;

import view.ClientFrame;
import view.IdFrame;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class WriteClass {

    Socket socket;
    ClientFrame cf;

    public WriteClass(Socket socket, ClientFrame cf) {
        this.socket = socket;
        this.cf = cf;
    }

    public void sendMessage() {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String id = IdFrame.tf.getText();
            String msg = "";
            if (cf.isFirst) { // 첫 번째 전송
                // 첫 번째 전송 시에는 IP 전송
                InetAddress iaddr = socket.getLocalAddress(); // InetAddr vs LocalAddr
                String ip = iaddr.getHostAddress();
                id = IdFrame.tf.getText();

                msg = "[" + id + "] 님 로그인 (" + ip + ")";
            }
            else {
                msg = "[" + id + "]" + cf.textF.getText();
            }

            writer.println(msg);
            writer.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
