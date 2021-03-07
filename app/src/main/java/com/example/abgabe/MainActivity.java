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

            }
        });

        bttnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AltSumme as = new AltSumme();
                String answer = "";
                answer = as.calculate(txtMatrklNr.getText().toString());
                String textFromServerMessage = txtAntwort.getText().toString();

                txtAntwort.setText(textFromServerMessage + '\n' + answer);


            }
        });
    }
}