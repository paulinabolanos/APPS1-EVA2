package com.example.eva2_8_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class myDataActivity extends AppCompatActivity
implements AdapterView.OnItemClickListener, View.OnClickListener {
    ListView lstVwRest;
    Button btnCancel;

    String [] Rest  = {
      "La cafe",
      "Buffalucas",
      "Montados La Junta",
      "Montados Dorados de Villa",
      "Boston",
      "Doña Pelos",
      "La cucaracha crocante",
      "h",
      "i",
      "j",
      "k",
      "l",
      "m",
      "n",
      "o",
      "p",
      "q",
      "r",
      "s",
      "t",
      "u",
      "v",
      "w",
      "x",
      "y",
      "z"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        lstVwRest = findViewById(R.id.lstVwRest);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        lstVwRest.setAdapter(new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Rest
                )
        );
        lstVwRest.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(this,Rest[position],Toast.LENGTH_LONG).show();
        Intent inDatos = new Intent();
        inDatos.putExtra("aaaa", Rest[position]);
        setResult(Activity.RESULT_OK, inDatos);
        finish();

    }


    @Override
    public void onClick(View v) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
