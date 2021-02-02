package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    public static boolean connected = true;
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Scanner inKeyboard;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            inKeyboard = new Scanner(System.in);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread readFromConsole = new Thread(() -> {
                while (connected) {
                    String strReadFromServer;
                    strReadFromServer = inKeyboard.nextLine();
                    try {
                        System.out.println("String read from server " + strReadFromServer);
                        out.writeUTF(strReadFromServer);
                    } catch (IOException e) {
                        e.printStackTrace();
                       // connected = false;
                    }
                    if (strReadFromServer.equals("/end")) {
                        connected = false;
                    }
                }
//                try {
//                    socket.close();
//                    System.out.println("Server connection to client closed.");
//                    server.close();
//                    System.out.println("Server closed.");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            });
            readFromConsole.start();

            Thread writeToConsole = new Thread(() -> {
                while (connected) {
                    String strSentFromClient = null;
                    try {
                        strSentFromClient = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                        //connected = false;
                    }
                    System.out.println("String received from client" + strSentFromClient);
                    if (strSentFromClient.equals("/end")) {
                        connected = false;
                    }
                }
//                try {
//                    socket.close();
//                    System.out.println("Server connection to client closed");
//                    server.close();
//                    System.out.println("Server closed");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            });
            writeToConsole.start();
            try {
                readFromConsole.join();
                writeToConsole.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (!connected){
                try {
                    socket.close();
                    System.out.println("Server connection to client closed");
                    server.close();
                    System.out.println("Server closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

