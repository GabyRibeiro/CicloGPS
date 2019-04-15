package com.gaby.ciclodevidagpsemapas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class LocalizacaoAdapter extends ArrayAdapter<Localizacao> {

    public LocalizacaoAdapter(Context context, List<Localizacao>localizacoes){
        super(context,-1, localizacoes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Localizacao loc = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewHolder vh = null;
        if (convertView== null){
            convertView= inflater.inflate(R.layout.list_item, parent,false);
        }
        vh = new ViewHolder();
        vh.latitude  =  convertView.findViewById(R.id.latitudeTextView);
        vh.longitude = convertView.findViewById(R.id.longitudeTextView);

        return convertView;
    }

    public class ViewHolder{
        public TextView lat;
        public TextView lon;
    }

    public class LocalizacaoViewHolder extends RecyclerView.ViewHolder{
        public TextView lat;
        public TextView lon;

        public LocalizacaoViewHolder(View v){
            super(v);
            lat = v.findViewById(R.id.latitudeTextView);
            lon = v.findViewById(R.id.longitudeTextView);
        }
    }

    public class LocalizacaoRecyclerViewAdapter extends RecyclerView.Adapter<LocalizacaoViewHolder>{
        private List<Localizacao> localizacoes;

        public LocalizacaoRecyclerViewAdapter(List<Localizacao>localizacoes){
            this.localizacoes=localizacoes;
        }


        @NonNull
        @Override
        public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View raiz =
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
            return new LocalizacaoViewHolder(raiz);
        }

        @Override
        public void onBindViewHolder(@NonNull LocalizacaoViewHolder localizacaoViewHolder, int i) {
            Localizacao l =     localizacoes.get(i);
        }

        @Override
        public int getItemCount() {
            return localizacoes.size();
        }
    }
}
