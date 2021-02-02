package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static Socket socketClient;
    private static String IP_ADRESS = "localhost";
    private static final int PORT = 8189;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Scanner inKeyboard;

    public static void main(String[] args) {
        try {
            socketClient = new Socket(IP_ADRESS, PORT);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("Client opened connection to server " + IP_ADRESS + "  " + PORT);
        inKeyboard = new Scanner(System.in);
        try {
            in = new DataInputStream(socketClient.getInputStream());
            out = new DataOutputStream(socketClient.getOutputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Thread readFromConsole = new Thread(() -> {
            while (Server.connected) {
                String strReadFromClient;
                strReadFromClient = inKeyboard.nextLine();
                try {
                    System.out.println("String read from client " + strReadFromClient);
                    out.writeUTF(strReadFromClient);
                    if (strReadFromClient.equals("/end")) {
                        Server.connected = false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                   // Server.connected = false;
                    //break;
                }
            }

        });
        readFromConsole.start();

        Thread writeToConsole = new Thread(() -> {
            while (Server.connected) {
                String strSentToClientString = null;
                try {
                    strSentToClientString = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                 //   Server.connected = false;
                }
                if (strSentToClientString.equals("/end")) {
                    Server.connected = false;
                    //break;
                }
                System.out.println("String received from server " + strSentToClientString);
            }
        });
        writeToConsole.start();
        try {
            readFromConsole.join();
            writeToConsole.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Server.connected){
            try {
                socketClient.close();
                System.out.println("Client disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

