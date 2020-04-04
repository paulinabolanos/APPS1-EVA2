package com.example.eva2_8_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSelRest, btnContactos, btnImagen, btnAudio, btnVideo;
    Intent inSelRest, inSelCont, intImagen, intAudio, intVideo;
    final int RESTAURANTE = 1000;
    final int CONTACTOS = 2000;
    final int IMAGEN = 3000;
    final int AUDIO = 4000;
    final int VIDEO = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelRest = findViewById(R.id.btnSelRest);
        btnContactos = findViewById(R.id.btnContactos);
        btnImagen = findViewById(R.id.btnImagen);
        btnAudio = findViewById(R.id.btnAudio);
        btnVideo = findViewById(R.id.btnVideo);

        inSelRest = new Intent(this, myDataActivity.class);
        inSelCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intImagen = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intAudio = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        intVideo = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);

        btnSelRest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(inSelRest);
                startActivityForResult(inSelRest, RESTAURANTE);
            }
        });

        btnContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSelCont, CONTACTOS);
            }
        });

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intImagen, IMAGEN);

            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intAudio, AUDIO);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intVideo, VIDEO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESTAURANTE: //QUE ACTIVIDAD DEVOLVIÓ DATOS
                if (resultCode == Activity.RESULT_OK){// CUAL FUE LA RESPUESTA
                    //QUE ACCION EJECUTAN CON LOS DATOS DEVUELTOS
                    Toast.makeText(this,data.getStringExtra("aaaa"),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "CANCELADO POR E USUARIO", Toast.LENGTH_LONG).show();
                }
                break;
            case CONTACTOS:
                if(resultCode == Activity.RESULT_OK){
                    String sCont = data.getDataString();
                    Log.wtf("CONTACTO", sCont);
                    Toast.makeText(this, sCont, Toast.LENGTH_LONG).show();
                }
                break;
            case IMAGEN:
                if (resultCode == Activity.RESULT_OK){
                    String sImage = data.getDataString();
                    Log.wtf("IMAGEN", sImage);
                    Toast.makeText(this,sImage , Toast.LENGTH_LONG).show();
                }
                break;
            case AUDIO:
                if (resultCode == Activity.RESULT_OK){
                    String sAudio = data.getDataString();
                    Log.wtf("AUDIO", sAudio);
                    Toast.makeText(this,sAudio , Toast.LENGTH_LONG).show();
                }
                break;
            case VIDEO:
                if (resultCode == Activity.RESULT_OK){
                    String sVideo = data.getDataString();
                    Log.wtf("VIDEO", sVideo);
                    Toast.makeText(this,sVideo , Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
