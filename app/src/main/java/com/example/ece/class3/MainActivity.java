package com.example.ece.class3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText input01;
    private Button button01;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input01 = findViewById(R.id.input01);
        button01 = findViewById(R.id.button01);
        nextButton = findViewById(R.id.nextbutton);


        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = input01.getText().toString();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });



    }

    public void goToNext(View v){
       Intent intent = new Intent(MainActivity.this, InClass3_2.class);
       startActivity(intent);
    }
}
