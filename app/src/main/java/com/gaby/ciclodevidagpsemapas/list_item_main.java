package com.gaby.ciclodevidagpsemapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class list_item_main extends AppCompatActivity {

    private ListView listaLocal;
    private LocalizacaoAdapter adpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        listaLocal = findViewById(R.id.localizacoesListView);
        listaLocal.setAdapter(adpt);

        public ArrayList<String> geraLocalizacoes() {
            ArrayList<String> listaLocal = new ArrayList<>();
            return listaLocal;
        }


    }
}
