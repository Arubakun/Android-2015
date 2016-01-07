package com.example.ProjetAndroidESGI;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ProjetAndroidESGI.Adapter.GridListAdapter;

public class MyActivity extends ListActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new GridListAdapter());

        Intent intentWeb = new Intent(this, ArticleWeb.class);

        Button btn_web = (Button) findViewById(R.id.btn_article_web);
        btn_web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentWeb);
            }
        });

        Intent intentText = new Intent(this, ArticleText.class);

        Button btn_text = (Button) findViewById(R.id.btn_article_text);
        btn_text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentText);
            }
        });
    }
}
