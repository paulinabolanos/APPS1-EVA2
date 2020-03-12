package com.example.eva2_2_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent inTel;
    EditText edtTxtTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtTel = findViewById(R.id.edtTxtTel);
    }
    public void onClick(View v){

        //ACCION_CALL ejecuta a llamada directamente (Permisos)
        //ACCION_DIAL Pone el telefono en pantalla de marcación para que el usuario haga la llamada (no requiere permisos)
        //URL --Dirección web, es un estandar para ubicar recursos en algún lado
        //    Protocolo(como buscar el recurso), despues la direccion
        //URI -- identificacor uniforme de recursos, (le damos el id de lo que queremos buscar)
        //    el telefono se busca con una uri (protocolo y depsues la ruta donde está)
        //    formato de URI -- tel:
        String cade = "tel:" + edtTxtTel.getText().toString();

        if(v.getId() == R.id.btnDial){
            //Accion, Datos
            inTel = new Intent(Intent.ACTION_DIAL, Uri.parse(cade));
        }else{
            //Accion, Datos
            inTel = new Intent(Intent.ACTION_CALL, Uri.parse(cade));
        }
        //Ejecutar un intento, para iniciar una actividad
        startActivity(inTel);

    }
}

/*Permission Denial:
DEPENDE DE LA VERSION DE ANDROID:

*/
