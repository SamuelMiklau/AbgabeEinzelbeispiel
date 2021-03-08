package com.example.abgabe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Thread extends java.lang.Thread {
    private String mssgForServer; //String in which the message for the server will be stored
    private String answerFromServer; //String in which the answer from the server will be stored


    public void sendMessage(String number) {
        this.mssgForServer = number;
    } // Set Message for server to the given Number from mainActivity

    public String answer() {
        return this.answerFromServer;
    } // returning the answer from the server to MainActivity

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212); //Creating Socket to connect to server
            try {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //Sends the Input from MainActivity to the Server
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Recieves answer from the Server
                outToServer.writeBytes(mssgForServer + '\n'); //Writing String via ByteStream to the Server

                answerFromServer = inFromServer.readLine();//Stores Value in private String and reads Message from server

            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }
}
