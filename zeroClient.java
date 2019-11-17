
import java.io.*;
import java.net.*;
import java.nio.channels.*;

import java.nio.ByteBuffer;

public class zeroClient {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[8]);
        try{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 5466));
        System.out.println("Connected");
        
        socketChannel.read(buffer);
        buffer.flip();
        long size = buffer.getLong();
            System.out.println("size File :"+size);
        buffer.clear();
        }
        
        catch(IOException e){
            
        }
    }
}
