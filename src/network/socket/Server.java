package network.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("server is running");

        while (true){
            // ss.accept()表示每当有新的客户端连接进来后，就返回一个Socket实例
            Socket sock = ss.accept();
            System.out.println("connected from client: " + sock.getRemoteSocketAddress());
            Thread t = new MySocketHandler(sock);
            t.start();
        }
    }
}

class MySocketHandler extends Thread{
    Socket sock;

    public MySocketHandler(Socket sock){
        this.sock = sock;
    }

    @Override
    public void run(){
        try(InputStream input = this.sock.getInputStream()){
            try(OutputStream output = this.sock.getOutputStream()){
                handle(input, output);
            }
        }catch(Exception e){
            try{
                this.sock.close();
            }catch(IOException ioe){ System.out.println("ioe"); }
        }
        System.out.println("client disconnected");
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

        writer.write("hello\n");
        writer.flush();
        while(true){
            String s = reader.readLine();
            if (s.equals("bye")){
                writer.write("bye\nv");
                writer.flush();
                break;
            }
            writer.write("ok server received client data: " + "[ " + s + " ]\n");
            writer.flush();
        }
    }
}
