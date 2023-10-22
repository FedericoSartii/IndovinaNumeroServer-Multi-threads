package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{

    Socket s;
    public ServerThread(Socket s){
        this.s = s;
    }
    public void run()
    {
        try {
        int rand = (int) (Math.random() * 100) +1;
        System.out.println(rand);
        System.out.println("Server avviato");
        System.out.println("Un client si è connesso");
    
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String numeroRicevuto;
        int num = 0;
        int n = 0;
        do {
            n++;
            numeroRicevuto = in.readLine();
            num = Integer.parseInt(numeroRicevuto);
            System.out.println("Il client ha inviato " + numeroRicevuto);
            if(num > rand && num != 0)
            {
                System.out.println("1");
                out.writeBytes("1" + '\n');
            }
            else if(num < rand && num != 0)
            {
                System.out.println("2");
                out.writeBytes("2" + '\n');
            }
            else if(num > 100 || num == 0)
            {
                System.out.println("4");
                out.writeBytes("4" + '\n');
            }
        } while (num != rand);
            System.out.println("3");
            out.writeBytes("3" + '\n');
            System.out.println(n);
            //server.close();
            //s.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Errore durante l'istanza del server !");
        System.exit(1);
    }
    }
}