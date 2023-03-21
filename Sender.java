import java.io.*;
import java.net.*;

public class Sender {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        File file = new File("naruto.jpg");
        byte[] buffer = new byte[1024];

        FileInputStream inputStream = new FileInputStream(file);
        DatagramPacket packet;

        while (inputStream.read(buffer) != -1) {
            packet = new DatagramPacket(buffer, buffer.length, address, 5000);
            socket.send(packet);
            System.out.println("Sent " + buffer.length + " bytes.");
        }

        inputStream.close();
        socket.close();
        System.out.println("File sent.");
    }
}
