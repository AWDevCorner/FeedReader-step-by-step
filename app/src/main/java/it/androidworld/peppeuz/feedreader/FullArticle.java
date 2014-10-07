package it.androidworld.peppeuz.feedreader;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.image.SmartImageTask;
import com.loopj.android.image.SmartImageView;


public class FullArticle extends ActionBarActivity {
    WebView article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);
        article= (WebView) findViewById(R.id.articleTxt);
        article.setBackgroundColor(Color.TRANSPARENT);
        Bundle extras = getIntent().getExtras();
        String titolo = extras.getString("titoloArticolo");
        String contenuto = extras.getString("contenutoArticolo");
        article.getSettings().setJavaScriptEnabled(true);
        article.loadDataWithBaseURL(null, "<style>img{display: inline; height: auto; max-width: 100%;}</style>\n"+"<h2>"+titolo+"</h2>"+contenuto, null, null, null);

    }

}
