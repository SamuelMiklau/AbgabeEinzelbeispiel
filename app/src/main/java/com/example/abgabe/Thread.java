package com.example.abgabe;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Thread extends java.lang.Thread {
    private String mssgForServer;
    private String answerFromServer;


    public void sendMessage(String Matrikelnummer) {
        this.mssgForServer = Matrikelnummer;
    }

    public String answer() {
        return this.answerFromServer;
    }

    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            try {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.writeBytes(mssgForServer + '\n');

                answerFromServer = inFromServer.readLine();
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }
}
