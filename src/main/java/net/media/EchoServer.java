package net.media;
import java.net.*;
import java.io.*;


public class EchoServer {
    public static void main(String[] args) throws IOException {

        String clientSentence;
        String capitalizedSentence;

        while (true) {
            ServerSocket TCP_Socket = new ServerSocket(6789);

            Socket connectionSocket = TCP_Socket.accept();

            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));

            FileWriter fw = new FileWriter("/tmp/EchoServer.log", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            clientSentence = inFromClient.readLine();

            pw.println(clientSentence);
            pw.close();
            bw.close();

            inFromClient.close();

            TCP_Socket.close();

        }
    }
}