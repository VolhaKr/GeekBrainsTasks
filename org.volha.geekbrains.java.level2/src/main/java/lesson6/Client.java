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
        System.out.println("Client opened connection to server " + IP_ADRESS + " " + PORT);

        inKeyboard = new Scanner(System.in);
        try {
            in = new DataInputStream(socketClient.getInputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            out = new DataOutputStream(socketClient.getOutputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Thread readFromConsole = new Thread(() -> {
            while (true) {
                String strReadFromClient;
                strReadFromClient = inKeyboard.nextLine();
                try {
                    System.out.println("String read from client " + strReadFromClient);
                    out.writeUTF(strReadFromClient);
                    if (strReadFromClient.equals("/end")) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
            try {
                System.out.println("Client disconnected");
                out.writeUTF("/end");
                socketClient.close();
                System.out.println("Socket closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        readFromConsole.start();

        Thread writeToConsole = new Thread(() -> {
            while (true) {
                String strSentToClientString = null;
                try {
                    strSentToClientString = in.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (strSentToClientString.equals("/end")) {
                    try {
                        socketClient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                System.out.println("String received from server " + strSentToClientString);
            }
        });
        writeToConsole.start();
    }
}

