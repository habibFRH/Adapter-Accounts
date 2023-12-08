package com.example.adaptercours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;

    String[] maintitle ={
            "Instagram","Facebook",
            "Twitter","Gmail"
    };

    String[] subtitle ={
            "https://www.instagram.com/",
            "https://www.facebook.com/",
            "https://twitter.com/",
            "https://gmail.google.com/"
    };

    Integer[] imgid={
            R.drawable.download_1,R.drawable.download_2,
            R.drawable.download_3,R.drawable.download_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter=new Adapter(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String[] urls = {
                        "https://www.instagram.com",
                        "https://www.facebook.com",
                        "https://www.twitter.com",
                        "https://mail.google.com"
                };


                if (position >= 0 && position < urls.length) {
                    String url = urls[position];
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Website not available", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}