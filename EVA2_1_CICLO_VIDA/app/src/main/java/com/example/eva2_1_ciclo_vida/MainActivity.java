package com.example.eva2_1_ciclo_vida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mensaje("onCreate");
    }

    public void Mensaje(String mensa){
        Toast.makeText(this,mensa, Toast.LENGTH_SHORT).show();
        Log.wtf("APP",mensa);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Mensaje("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Mensaje("onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Mensaje("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Mensaje("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Mensaje("onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Mensaje("onStop");
    }
}
