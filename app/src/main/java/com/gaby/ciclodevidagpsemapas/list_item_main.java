package com.gaby.ciclodevidagpsemapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class list_item_main extends AppCompatActivity {

    private ListView listaLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        public ArrayList<String> geraLocalizacoes() {
            ArrayList<String> listaLocal = new ArrayList<>();
            return listaLocal;
        }


    }
}
