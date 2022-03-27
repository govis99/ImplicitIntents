package com.example.android.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button Launch;
EditText weblink;
EditText phonenum;
Button Ring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Launch = (Button) findViewById(R.id.Launch);
        weblink = (EditText) findViewById(R.id.weblink);
        phonenum = (EditText) findViewById(R.id.phonenum);
        Ring = (Button) findViewById(R.id.Ring);

        Launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url1 = weblink.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
                startActivity(intent);
            }
        });

        Ring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = phonenum.getText().toString();
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+num));
                startActivity(callIntent);
            }
        });
    }
}