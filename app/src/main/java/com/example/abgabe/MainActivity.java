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

                    txtAntwort.setText(t.answer());//Fills Text Box with answer from Server
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

                txtAntwort.setText(answer); // Fills Text box with Text from calculation


            }
        });
    }

}