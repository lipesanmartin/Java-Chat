package swing;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente_Swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane);

        JTextField messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket cliente = new Socket("127.0.0.1", 10000);
                    PrintStream out = new PrintStream(cliente.getOutputStream());
                    out.println(messageField.getText());
                    out.close();
                    cliente.close();
                    messageField.setText("");
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(messageField, "South");

        frame.setVisible(true);
    }
}


