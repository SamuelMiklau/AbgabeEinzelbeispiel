package com.example.abgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bttnSend;
    EditText txtMatrklNr;
    TextView txtAntwVomServer;
    TextView txtAntwort;
    Button bttnCalc;
    TextView txtOrder;
    String number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttnSend = (Button) findViewById(R.id.bttnSend);
        bttnCalc = (Button) findViewById(R.id.bttnCalc);
        txtMatrklNr = (EditText) findViewById(R.id.txtMatrklNr);
        txtAntwVomServer = (TextView) findViewById(R.id.txtAntwVomServer);
        txtAntwort = (TextView) findViewById(R.id.txtAntwort);
        txtOrder = (TextView) findViewById(R.id.txtOrder);

        bttnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = txtMatrklNr.getText().toString();

                try{
                    Thread t = new Thread();
                    t.sendMessage(number); //Sends entered Number to class Thread

                    t.start(); // Starts the excecution of Thread

                    t.join(); // Waits until class Thread finished all the operations

                    String answerSpace = t.answer();
                    String answerFromCalc = txtAntwort.getText().toString();

                    txtAntwort.setText(answerSpace + '\n' + answerFromCalc);//Fills Text Box with answer from Server
                }catch (Exception e){
                    txtAntwort.setText(e.toString()); //If an Error occurs Text Box is filled with Exception Message
                }
            }



        });

        bttnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AltSumme as = new AltSumme();
                String answer = "";
                answer = as.calculate(txtMatrklNr.getText().toString()); //Stores caluclated Value from class AltSumme in String answer
                String textFromServerMessage = txtAntwort.getText().toString(); //Creates a temporary place for the Server message which is already in the Text box.

                txtAntwort.setText(textFromServerMessage + '\n' + answer); // Fills Text box with Text from Server and the Answer from the Calculation


            }
        });
    }

}