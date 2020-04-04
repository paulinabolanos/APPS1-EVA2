package com.example.eva2_6_web_search;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent intWebS;
    Button btnWebS;
    EditText edTxtBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWebS = findViewById(R.id.btnWebS);
        edTxtBusqueda = findViewById(R.id.edTxtBusqueda);

        btnWebS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sBusqueda = edTxtBusqueda.getText().toString();
                intWebS = new Intent(Intent.ACTION_WEB_SEARCH);
                intWebS.putExtra(SearchManager.QUERY,sBusqueda);
                startActivity(intWebS);
            }
        });


    }
}
