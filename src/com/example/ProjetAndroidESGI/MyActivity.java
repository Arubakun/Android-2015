package com.example.ProjetAndroidESGI;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MyActivity extends ListActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Article[] items = {
          new Article("Audio : Shure et BoomStick, le meilleur et le pire du CES 2016 pour nos mobiles", "http://www.frandroid.com/hardware/336213_audio-le-meilleur-et-le-pire-du-ces-pour-nos-mobiles", "Content"),
          new Article("CES 2016 : en video, nos coups de coeur et nos deceptions", "http://www.frandroid.com/video/335923_ces-2016-en-video-nos-coups-de-coeur-et-nos-deceptions", "Content")
        };

        ArrayAdapter<Article> adaptes = new ArrayAdapter<Article>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(adaptes);

        Intent intentWeb = new Intent(this, ArticleWeb.class);



        Intent intentText = new Intent(this, ArticleText.class);



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        // ListView Clicked item index
        int itemPosition     = position;

        // ListView Clicked item value
        Article  article    = (Article) l.getItemAtPosition(position);
        Log.d("Test_articles",article.toString());

        Intent i = new Intent(this, ArticleWeb.class);
        String url = article.url;
        i.putExtra("URL", url);
        startActivity(i);

    }
}
