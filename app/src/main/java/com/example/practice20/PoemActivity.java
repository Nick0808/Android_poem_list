package com.example.practice20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class PoemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);

        Intent poemIntent = getIntent();
        String tag = poemIntent.getStringExtra("poemTag");

        Resources res = getResources();

        TextView txtTitle= (TextView)findViewById(R.id.poem_textView1);
        int titleID = res.getIdentifier("poem"+tag+"_title", "string", getPackageName());
        setTitle(titleID);
        txtTitle.setText(titleID);

        TextView txtAuthor= (TextView)findViewById(R.id.poem_textView2);
        int authorID = res.getIdentifier("poem"+tag+"_author", "string", getPackageName());
        txtAuthor.setText(authorID);

        TextView txtBody= (TextView)findViewById(R.id.poem_textView3);
        int bodyID = res.getIdentifier("poem"+tag+"_body", "string", getPackageName());
        txtBody.setText(bodyID);
    }
}