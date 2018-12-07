package com.example.ece.class3;

import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectThread extends Thread {
    private String hostname;

    public ConnectThread(String hostname){
        this.hostname = hostname;
    }

    public void run(){
        try{
            int port = 11001;

            Socket sock = new Socket(hostname,port);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
            objectOutputStream.writeObject("2016-19550 Martin");
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
            String Obj = (String) objectInputStream.readObject();

            Log.d("MainActivity","Message received from server: "+Obj);

            sock.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
