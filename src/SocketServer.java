import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer {
    ServerSocket ss;
    int port = 1488;
    InputStream[] sin = new InputStream[9];
    OutputStream[] sout = new OutputStream[9];
    DataInputStream[] in = new DataInputStream[9];
    DataOutputStream[] out = new DataOutputStream[9];
    int count = 0, count1 = 0;
    Socket[] players = new Socket[9];
    String[] login = new String[9];
    SocketServer(){
        try {
            ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a clients...");
            for (int i = 0; i < 9; i++) {
                players[i] = null;
                login[i] = null;
            }
        } catch(Exception x) { x.printStackTrace(); }

    }
}
