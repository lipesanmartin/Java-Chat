package swing;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor_Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane);

        frame.setVisible(true);

        try {
            ServerSocket server = new ServerSocket(10000);
            chatArea.append("Porta 10000 aberta, aguardando conexão...\n");

            while (true) {
                Socket client = server.accept();
                chatArea.append("Conexão de " + client.getInetAddress().getHostAddress() + "\n");

                Scanner s = new Scanner(client.getInputStream());
                while (s.hasNextLine()) {
                    chatArea.append(s.nextLine() + "\n");
                }
                s.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

