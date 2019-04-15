package com.gaby.ciclodevidagpsemapas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class LocalizacaoAdapter extends ArrayAdapter<Localizacao> {

    public LocalizacaoAdapter(Context context, List<Localizacao> localizacoes){
        super(context,-1, localizacoes);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Localizacao loc = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView== null){
            convertView= inflater.inflate(R.layout.list_item, parent,false);
        }

        TextView lat = convertView.findViewById(R.id.latitudeTextView);
        TextView lon = convertView.findViewById(R.id.longitudeTextView);
        return convertView;
    }
}
