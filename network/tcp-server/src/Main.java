import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        /*
        * TCP: Transmission Control Protocol
        *
        * Server: TCP, Web(tomcat), Database
        *
        * 종단시스템: Host(주인)
        *           PC, Smart Phone, Scanner, Printer
        *
        * Router: Hardware (not software)
        *           Host 간에 상호 데이터를 교환할 수 있도록 하는 장비
        *
        * Inter Network: 포괄적인 통신망
        *
        * [ 통신 규약 ]
        * TCP - Transmission Control Protocol 동기 통신 (한 쪽이 보내면 다른 쪽은 받을 준비 필요)
        * UDP - User Datagram Protocol        비동기 통신
        *
        * [ 7 Layer ]
        * 1계층 - Physical Layer          물리 계층
        * 2계층 - Data Link Layer         주소를 헤더에 첨부
        * 3계층 - Network Layer           네트워크 "IP" -> Address
        * 4계층 - Transport Layer         네트워크 "Port"
        * 5계층 - Session Layer           세션을 동기화     세션 = 서버의 저장공간 (Cache vs Session)
        * 6계층 - Presentation Layer      보안, 압축, 확장
        * 7계층 - Application Layer       프로그램
        *
        *
        * [ TCP ]
        * 신사적인 프로토콜, 신뢰할 수 있는 규약
        * 전화 -> 상대방 -> 연결 -> 통신 start
        * 동기화: send -> receive 처리 순서 중요 (sync)
        * 데이터의 경계 X 용량 제한 X
        * (채팅 프로그램) Object 전송
        *
        * [ UDP ]
        * 비 연결형 프로토콜
        * 편지, 지상파방송
        * 데이터의 경계 O 용량 제한 O (몇 byte 까지만 보내라, 그 이상은 잘라서 보내라)
        * 1 대 1 통신 (unicast)
        * 1 대 다 통신 (broadcast)
        * 다 대 다 통신 (multicast)
        *
        *
        * Packet (묶음)
        * 제어 정보, 데이터 (문자열, Object) 결합된 형태로 전송
        * IP, Port, String:
        *
        * IP: Internet Protocol => 주소
        *
        * IPv4: xxx.xxx.xxx.xxx -> 0 ~ 255
        * IPv6: xxx.xxx.xxx.xxx.xxx.xxx
        *
        * 127.0.0.1 -> 자기 자신의 접속주소
        *
        * Port Number
        * IP 주소는 Internet 에 존재하는 Host(PC) 를 식별할 수 있으나,
        * 최종 주체인 프로세스(프로그램)를 식별하지 못하기 때문에
        * 프로세스를 구별하기 위해서 지정된 수치(0 ~ 1024) 외의 숫자를 지정
        *
        * Socket
        * 통신의 주체. 통신을 하기 위한 오브젝트.
        * IP, TCP/UDP
        *
        * [ 통신 순서 ]
        *       server                      client
        * 1. socket 버전 확인                 1. socket 버전 확인
        * 2. binding -> IP, Port 설정
        * 3. listener (socket 동작 시키기)
        * 4. accept (접속 시켜줄 준비)  <----- 2. connect
        *
        *    1) receive       <-----       send (write (unix))
        *    2) send          ----->       receive (read)
        *
        * DNS (Domain Name System) Server
        *
        * */

        // 담당자 소켓 (클라이언트 정보를 담는 소켓)
        Socket clientSocket = null;

        try {

            // 문지기 소켓
            ServerSocket serverSocket = new ServerSocket(9000); // 버전 확인, 바인딩, 리스닝 포함

//            while (true) {
                System.out.println("접속 대기중...");
                clientSocket = serverSocket.accept(); // 클라이언트의 정보, 클라이언트가 송신한 문자열

                // 접속 client 확인
                System.out.println("client IP: " + clientSocket.getInetAddress() + " Port: " + clientSocket.getPort());
//            }

            while (true) {
                // 수신 (receive)
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String str = reader.readLine();

                System.out.println("[client 메시지]: " + str);

                // 송신 (send)
                str = "반값습니다 \\' \'/: " + str;

                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                writer.println(str);
                writer.flush();
            }


//            clientSocket.close();
//            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
