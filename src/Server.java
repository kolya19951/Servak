import javax.swing.*;
import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] ar)    {
        SocketServer sock = new SocketServer();
        MainForm frame = new MainForm(sock);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            do {
                sock.players[sock.count] = sock.ss.accept();
                sock.sin[sock.count] = sock.players[sock.count].getInputStream();
                sock.sout[sock.count] = sock.players[sock.count].getOutputStream();
                sock.in[sock.count] = new DataInputStream(sock.sin[sock.count]);
                sock.out[sock.count] = new DataOutputStream(sock.sout[sock.count]);
                sock.login[sock.count] = sock.in[sock.count].readUTF();
                System.out.print(sock.login[sock.count]);
                System.out.println(" - " + sock.count + "Гравець");
                sock.count++;
            }
            while (sock.count != 1);
        }catch(Exception x) { x.printStackTrace(); }
        System.out.println("Game start!");

    }
}