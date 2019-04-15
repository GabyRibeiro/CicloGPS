package com.gaby.ciclodevidagpsemapas;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Localizacao> localizacoes;
    private MeuAdapter adpt;
    private LocationManager locManager;
    private LocationListener locListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        localizacoes = new ArrayList<>();
        adpt = new MeuAdapter(localizacoes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(adpt);

       locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
       locListener = new LocationListener() {
           @Override
           public void onLocationChanged(Location location) {

               double lat;
               double lon;

               lat = location.getLatitude();
               lon = location.getLongitude();

               Localizacao l = new Localizacao(lat, lon);
               localizacoes.add(l);
               adpt.notifyDataSetChanged();
           }

           @Override
           public void onStatusChanged(String provider, int status, Bundle extras) {

           }

           @Override
           public void onProviderEnabled(String provider) {

           }

           @Override
           public void onProviderDisabled(String provider) {

           }
       };

    }

    private class MeuViewHolder extends  RecyclerView.ViewHolder {
        TextView latTxtView;
        TextView longTxtView;

        public MeuViewHolder (View raiz) {
            super(raiz);

            latTxtView = raiz.findViewById(R.id.latTxtView);
            longTxtView = raiz.findViewById(R.id.longTxtView);
        }
    }


    private class MeuAdapter extends RecyclerView.Adapter <MeuViewHolder>{
        List<Localizacao> localizacoes;

            public MeuAdapter (List <Localizacao> localizacoes) {
                this.localizacoes = localizacoes;
        }

        @NonNull
        @Override
        public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            Context context = viewGroup.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            View raiz = inflater.inflate(R.layout.activity_list_item, viewGroup, false);
            return new MeuViewHolder(raiz);

        }

        @Override
        public void onBindViewHolder(@NonNull MeuViewHolder meuViewHolder, int i) {
            Localizacao localizacao = localizacoes.get(i);
            meuViewHolder.latTxtView.setText(
                    Double.toString(
                            localizacao.lat
                    )
            );
            meuViewHolder.longTxtView.setText(
                    Double.toString(
                            localizacao.lon
                    )
            );
        }

        @Override
        public int getItemCount() {
            return localizacoes.size();

        }
    }

    private class Localizacao {
        double lat;
        double lon;

        public Localizacao (double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1000
            );
        }
        else{
            locManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    0,
                    0,
                    locListener
            );

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED) {
                    locManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            0,
                            0,
                            locListener
                    );

                }


            }

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        locManager.removeUpdates(locListener);
    }

}
