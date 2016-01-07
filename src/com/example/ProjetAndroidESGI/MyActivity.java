package com.example.ProjetAndroidESGI;

import android.app.Activity;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ProjetAndroidESGI.Adapter.GridListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Array de test de l'adapter
        List<String> test = new ArrayList<String>();
        test.add("article 1");
        test.add("article 2");
        test.add("article 3");
        test.add("article 4");
        test.add("article 5");

        // Adapter permettant de récupérer les articles
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.main, R.id.textView ,test);

        // ListView listant les articles
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(listAdapter);

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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
