package it.androidworld.peppeuz.feedreader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import com.loopj.android.image.SmartImageTask;
import com.loopj.android.image.SmartImageView;


public class FullArticle extends Activity{
    WebView article;
    String titolo;
    String link;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_share_menu, menu);
        MenuItem item = menu.findItem(R.id.menu_item_share);

        ShareActionProvider myShareActionProvider = (ShareActionProvider) item.getActionProvider();

        Intent myIntent = new Intent();
        myIntent.setAction(Intent.ACTION_SEND);
        myIntent.putExtra(Intent.EXTRA_TEXT, "Dai un'occhiata a questo articolo su AndroidWorld.it: "+titolo+" , "+link);
        myIntent.setType("text/plain");

        myShareActionProvider.setShareIntent(myIntent);

        return true;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);
        article= (WebView) findViewById(R.id.articleTxt);
        article.setBackgroundColor(Color.TRANSPARENT);
        Bundle extras = getIntent().getExtras();
        titolo = extras.getString("titoloArticolo");
        link = extras.getString("link");
        String contenuto = extras.getString("contenutoArticolo");
        article.getSettings().setJavaScriptEnabled(true);
        article.loadDataWithBaseURL(null, "<style>img{display: inline; height: auto; max-width: 100%;}</style>\n"+"<h2>"+titolo+"</h2>"+contenuto, null, null, null);

    }

}
