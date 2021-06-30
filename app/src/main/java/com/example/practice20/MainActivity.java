package com.example.practice20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout itemContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemContainer = (LinearLayout)findViewById(R.id.main_container);
        LayoutInflater inflater = getLayoutInflater();
        Resources res = getResources();

        for(int count = 1; count <= 3; count++) {
            View itemView = inflater.inflate(R.layout.poem_item, null);
            Drawable shape = res.getDrawable(R.drawable.shape_item);
            itemView.setBackground(shape);

            TextView txtTitle= (TextView)itemView.findViewById(R.id.item_textView1);
            int titleID = res.getIdentifier("poem"+count+"_title", "string", getPackageName());
            txtTitle.setText(titleID);

            TextView txtAuthor= (TextView)itemView.findViewById(R.id.item_textView2);
            int authorID = res.getIdentifier("poem"+count+"_author", "string", getPackageName());
            txtAuthor.setText(authorID);

            TextView txtBody= (TextView)itemView.findViewById(R.id.item_textView3);
            int bodyID = res.getIdentifier("poem"+count+"_body", "string", getPackageName());
            txtBody.setText(bodyID);

            itemView.setTag(Integer.toString(count));
            itemContainer.addView(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent poemIntent = new Intent(MainActivity.this, PoemActivity.class);
                    String tag = (String)itemView.getTag();
                    poemIntent.putExtra("poemTag", tag);
                    startActivity(poemIntent);
                }
            });
        }
    }
}