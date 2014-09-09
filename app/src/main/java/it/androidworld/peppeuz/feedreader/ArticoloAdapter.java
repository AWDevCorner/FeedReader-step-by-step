package it.androidworld.peppeuz.feedreader;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by peppeuz on 25/08/14.
 */
public class ArticoloAdapter extends BaseAdapter {

    private Activity mActivity;
    private ArrayList<Articolo> listaArticoli;
    private static LayoutInflater inflater = null;

    public ArticoloAdapter(Activity a, ArrayList<Articolo> list) {
        mActivity = a;
        listaArticoli = list;
        inflater = (LayoutInflater) mActivity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaArticoli.size();
    }

    @Override
    public Object getItem(int item) {
        // TODO Auto-generated method stub
        return item;
    }

    @Override
    public long getItemId(int item) {
        // TODO Auto-generated method stub
        return item;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.row, null);

        TextView titolo = (TextView) vi.findViewById(R.id.titolo);
        TextView autore = (TextView) vi.findViewById(R.id.autore);
        SmartImageView immagine = (SmartImageView) vi.findViewById(R.id.immagine);
        Articolo articoloCorrente = listaArticoli.get(position);
        titolo.setText(articoloCorrente.getTitolo());
        autore.setText(articoloCorrente.getAutore());
        immagine.setImageUrl(articoloCorrente.getImmagine());
        return vi;
    }
}
