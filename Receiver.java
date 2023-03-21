package reciver;

import java.io.*;
import java.net.*;

public class Receiver {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(5000);
        byte[] buffer = new byte[1024];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        FileOutputStream outputStream = new FileOutputStream("receivedFile.jpg");
        int bytesRead = 0;
        while (true) {
            socket.receive(packet);
            bytesRead = packet.getLength();
            if (bytesRead == -1) {
                break;
            }
            outputStream.write(buffer, 0, bytesRead);
            System.out.println("Received " + bytesRead + " bytes.");
        }

        outputStream.close();
        socket.close();
        System.out.println("File received and saved.");
    }
}
