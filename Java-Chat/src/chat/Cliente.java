package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Cliente {
    public static void main(String[]args) throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 10000); // info sobre o servidor

        Scanner s = new Scanner(System.in);
        PrintStream out = new PrintStream(cliente.getOutputStream());

        while(s.hasNextLine()){
            out.println(s.nextLine());
        }

        out.close();
        s.close();
        cliente.close();
    }
}
