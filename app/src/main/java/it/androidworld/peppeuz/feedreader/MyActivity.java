package it.androidworld.peppeuz.feedreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class MyActivity extends ActionBarActivity implements Observer
{

    ConnectionHelper cHelper = null;
    XMLParser xmlParser = null;
    public static ArrayList<Articolo> listaArticoli = null;
    ListView listViewArticoli;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        listViewArticoli = (ListView) findViewById(R.id.listViewArticoli);
        cHelper = ConnectionHelper.getInstance();
        ctx= this;
        loadFeed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addArticolo(Articolo articolo){
        listaArticoli.add(articolo);
    }

    public void loadFeed()
    {
        xmlParser = XMLParser.getInstance();
        xmlParser.addObserver(this);
        cHelper.get("feed",null,new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.i("statusCode", statusCode+"");
                String xml = new String(responseBody);
                try {
                    xmlParser.parseXML(xml);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("error",statusCode+"");
            }
        });
    }

    @Override
    public void update(Observable observable, Object data) {
        listaArticoli = (ArrayList<Articolo>) data;
        ArticoloAdapter mArticoloAdapter = new ArticoloAdapter(this,listaArticoli);
        listViewArticoli.setAdapter(mArticoloAdapter);
        listViewArticoli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l)
            {
                Intent toFullArticle = new Intent(ctx, FullArticle.class);
                toFullArticle.putExtra("articleIndex",i);
                startActivity(toFullArticle);
            }
        });
    }
}
