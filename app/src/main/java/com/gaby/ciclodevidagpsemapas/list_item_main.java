package com.gaby.ciclodevidagpsemapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ListView;

import java.util.ArrayList;

public class list_item_main extends AppCompatActivity {

    private ListView listaLocal;
    private LocalizacaoAdapter adpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        recyclerView = findViewById(R.id.localizacoesRecyclerView);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        recyclerView.setAdapter(new LocalizacaoAdapter(adpt));

        public ArrayList<String> geraLocalizacoes() {
            ArrayList<String> listaLocal = new ArrayList<>();
            return listaLocal;
        }


    }
}
