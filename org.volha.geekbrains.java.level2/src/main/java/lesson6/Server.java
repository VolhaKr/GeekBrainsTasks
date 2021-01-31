package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
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
            //PrintWriter outConsole = new PrintWriter(socket.getOutputStream(), true);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            Thread t1 = new Thread(() -> {
                while (true) {
                    String strReadFromServer = null;
                    strReadFromServer = inKeyboard.nextLine();
                    if (strReadFromServer.equals("/end")) {
                        break;
                    }
                    try {
                        System.out.println("String read from server" + strReadFromServer);
                        out.writeUTF(strReadFromServer);
                       // out.flush();
                        System.out.println("Hey" + out.toString());
                    } catch (IOException e) {
                        System.out.println("e1");
                        //  e.printStackTrace();
                    }

                    //    System.out.println("Client: " + str);
//                    try {
//                        out.writeUTF("echo: " + str);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            });
            t1.start();

//            Thread t2 = new Thread(() -> {
//                while (true) {
//                    String strReceivedFromClient = null;
//                    try {
//                        strReceivedFromClient = in.readUTF();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("Client: " + strReceivedFromClient);
////                    try {
////                        out.writeUTF("echo: " + str);
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
//                }
//            });
//            t2.start();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            System.out.println("Client disconnected");
//            try {
//           //     socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                server.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }


}


//        try {
//            server = new ServerSocket(PORT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Server started");
//
//            socket= server.accept();
//            System.out.println("Client connecte: "+socket.getRemoteSocketAddress());
//
//        try {
//            in = new DataInputStream(socket.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            out = new DataOutputStream(socket.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////            in = new Scanner(socket.getInputStream());
////            out = new PrintWriter(socket.getOutputStream(), true);
//
//            new Thread(() -> {
//
//            }.start();
//    }
//}


