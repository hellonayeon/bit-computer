import net.ReadThread;
import view.ClientFrame;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClass {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("192.168.0.99", 9000);
            System.out.println("connection success!!");

            ClientFrame cf = new ClientFrame(socket);

            new ReadThread(socket, cf).start();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
