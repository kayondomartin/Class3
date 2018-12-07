package com.example.ece.class3;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InClass3_2 extends AppCompatActivity {

    private EditText webaddr;
    private TextView message;
    private Button httpRequestButton;
    private String defaultURL = "http://my.snu.ac.kr";

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_class3_2);

        webaddr = findViewById(R.id.web_addr);
        message = findViewById(R.id.textmsg);
        httpRequestButton = findViewById(R.id.requestButton);

        httpRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = webaddr.getText().toString();
                if(url.isEmpty()){
                    url = defaultURL;
                }

                new Thread(){
                    public void run(){
                        final String outPut
                    }
                }
            }
        });
    }

    private String request(String urlString){
        StringBuilder output = new StringBuilder();

        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection != null){
                connection.setConnectTimeout(10000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);

                int resCode = connection.getResponseCode();
                Log.e("SampleHTTP", Integer.toString(resCode));

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = reader.readLine();

                while(line != null){
                    output.append(line + "\n");
                    line = reader.readLine();
                }

                reader.close();
                connection.disconnect();

            }


        }catch (Exception e){
            Log.e("SampleHTTp","Exception in processing response: ",e);
            e.printStackTrace();
        }

        return output.toString();
    }
}
