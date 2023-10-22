package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(6789);
        while(true)
        {
            Socket s = ss.accept();
            ServerThread thread = new ServerThread(s);
            thread.start();
        }
    }
}
