package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Client {

    private static Socket socketClient;
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

        //         inKeyboard = new Scanner(System.in);
        //PrintWriter outConsole = new PrintWriter(socket.getOutputStream(), true)

        try {
            in = new DataInputStream(socketClient.getInputStream());
        } catch (IOException ioException) {
            System.out.println("exception");
            //  ioException.printStackTrace();
        }
//        try {
//            out = new DataOutputStream(socket.getOutputStream());
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        Thread t3 = new Thread(() -> {
//                        while (true) {
//                            String strReadFromClient = null;
//                            strReadFromClient = inKeyboard.nextLine();
//                            if (strReadFromClient.equals("/end")) {
//                                break;
//                            }
//                            if (!strReadFromClient.equals(null)) {
//                                try {
//                                    out.writeUTF(strReadFromClient);
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            //    System.out.println("Client: " + str);
////                    try {
////                        out.writeUTF("echo: " + str);
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
//                        }
//                    });
//                    t3.start();
//
      //  Thread t4 = new Thread(() -> {
            while (true) {
                String strSentToClientString = "mom";
                try {
                    strSentToClientString = in.readUTF();
                    try {
                        sleep(50000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Client: " + strSentToClientString);
                } catch (IOException e) {
                    System.out.println("ex2");
                    // e.printStackTrace();
                }

            }
//                    try {
//                        out.writeUTF("echo: " + str);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//        });
//        t4.start();

//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    System.out.println("Client disconnected");
//                    try {
//                        socket.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        server.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
    }


}

