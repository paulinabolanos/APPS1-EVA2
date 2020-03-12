package com.example.eva2_3_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Intent inSMS;
    Button btnEnviarSMS;
    EditText edtTxtTel, edtTxtSMS;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviarSMS = findViewById(R.id.btnEnviarSMS);
        edtTxtTel = findViewById(R.id.edTxtTel);
        edtTxtSMS = findViewById(R.id.edtTxtSMS);


        btnEnviarSMS.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sTel = "smsto:" + edtTxtTel.getText().toString();
                        String sSMS = edtTxtSMS.getText().toString();
                        inSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
                        startActivity(inSMS);
                        //EXTRAS-- datos primitivos dentro del intento Mapa (KEY, VALOR)
                        inSMS.putExtra("sms_body", sSMS );
                    }
                }
        );
    }
}
