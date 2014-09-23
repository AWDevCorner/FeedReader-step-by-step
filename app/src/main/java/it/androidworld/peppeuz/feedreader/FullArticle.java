package it.androidworld.peppeuz.feedreader;

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
        Bundle extras = getIntent().getExtras();
        int articleIndex= extras.getInt("articleIndex");
        Articolo a = MyActivity.listaArticoli.get(articleIndex);
        article.getSettings().setJavaScriptEnabled(true);
        article.setBackgroundColor(Color.TRANSPARENT);
        article.loadDataWithBaseURL(null, "<style>img{display: inline; height: auto; max-width: 100%;}</style>\n"+"<h2>"+a.getTitolo()+"</h2>"+a.getContenuto(), null, null, null);

    }

}
