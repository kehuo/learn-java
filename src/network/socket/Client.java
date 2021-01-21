package network.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // 指定客户端去连接 服务器的 localhost 和 6666 端口
        Socket sock = new Socket("localhost", 6666);
        try(InputStream input = sock.getInputStream()){
            try (OutputStream output = sock.getOutputStream()){
                handle(input, output);
            }
        }
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[Server] " + reader.readLine());

        while(true){
            System.out.println(">>>");
            // 读取一行输入
            String s = scanner.nextLine();
            writer.write(s);
            writer.newLine();
            writer.flush();
            String response = reader.readLine();
            System.out.println("<<< " + response);
            if (response.equals("bye")){
                break;
            }
        }
    }

}
