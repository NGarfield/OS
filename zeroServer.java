
import java.io.*;
import java.net.*;
import java.nio.channels.*;

import java.nio.ByteBuffer;

public class zeroServer {

    static int port = 5467;
    static String path = "F:/OsFile/Server/an1.exe";

    public static void main(String[] args) {
        try {

            FileChannel fileChannel = new FileInputStream(path).getChannel();
            long size = fileChannel.size();

            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("Server Open");

            while (true) {
                SocketChannel sockketChannel = serverSocket.accept();
                System.out.println("Connected");

                ByteBuffer buffer = ByteBuffer.allocate(8);
                buffer.asLongBuffer().put(size);
                sockketChannel.write(buffer);
                System.out.println("Send size " + size + " byte");

            }

        } catch (IOException e) {
        }

    }
}
