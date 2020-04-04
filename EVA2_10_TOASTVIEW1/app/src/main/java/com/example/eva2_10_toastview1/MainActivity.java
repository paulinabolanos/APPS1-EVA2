package com.example.eva2_10_toastview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtVwPosToast;
    EditText edTxtXoff, edTxtYoff;
    Button btnShowToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwPosToast = findViewById(R.id.txtVwPosToast);
        edTxtXoff = findViewById(R.id.edTxtXoff);
        edTxtYoff = findViewById(R.id.edTxtYoff);
        btnShowToast = findViewById(R.id.btnShowToast);

        int dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        int width= Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        txtVwPosToast.append("\n Screen size= " + width + "x" + height
                +" Density=" + dpi + "dpi");

        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try { Toast myToast = Toast.makeText(getApplicationContext(), "Here", Toast.LENGTH_LONG);
                    myToast.setGravity( Gravity.CENTER,
                            Integer.valueOf(edTxtXoff.getText().toString()),
                            Integer.valueOf(edTxtYoff.getText().toString()));
                    myToast.show();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
