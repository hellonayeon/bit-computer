package thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {

    private Socket socket;

    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();

        while (true) {

            try {
                // 수신 (receive)
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = reader.readLine();

                System.out.println(str);

                Thread.sleep(300);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
