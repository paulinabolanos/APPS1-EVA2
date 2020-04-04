package com.example.eva2_9_alertdialog1;


import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAlertDialogBox, btnCusDialogBox,btnAlertDialogFrag;
    TextView txtVwDemo;
    Context activityContext;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityContext = this;

        btnAlertDialogBox = findViewById(R.id.btnAlertDialogBox);
        btnCusDialogBox = findViewById(R.id.btnCusDialogBox);
        btnAlertDialogFrag = findViewById(R.id.btnAlertDialogFrag);
        txtVwDemo = findViewById(R.id.txtVwDemo);

        btnAlertDialogBox.setOnClickListener(this);
        btnCusDialogBox.setOnClickListener(this);
        btnAlertDialogFrag.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == btnAlertDialogBox.getId()) {
            showMyAlertDialog(this);
        }
        if (v.getId() == btnCusDialogBox.getId()) {
            showCustomDialogBox();
        }
        if (v.getId() == btnAlertDialogFrag.getId()) {
            showMyAlertDialogFragment(this);
        }
    }
    private void showMyAlertDialog(MainActivity mainActivity) {
        new AlertDialog.Builder(mainActivity)
                .setTitle("Terminator")
                .setMessage("Are you sure that you want to quit?")
                .setIcon(R.drawable.alert)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                msg = "YES " + Integer.toString(whichButton);
                                txtVwDemo.setText(msg);
                            }
                        })
                .setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                msg = "CANCEL " + Integer.toString(whichButton);
                                txtVwDemo.setText(msg);
                            }
                        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        msg = "NO " + Integer.toString(whichButton);
                        txtVwDemo.setText(msg);
                    }
                })
                .create()
                .show();
    }
    private void showCustomDialogBox() {
        final Dialog customDialog = new Dialog(activityContext);
        customDialog.setTitle("Custom Dialog Title");
        customDialog.setContentView(R.layout.custom_dialog);
        ((TextView) customDialog.findViewById(R.id.txtVwCD))
                .setText("\nMessage line1\nMessage line2\n"
                        +"Dismiss: Back btn, Close, or touch outside");
        final EditText sd_txtInputData = (EditText) customDialog
                .findViewById(R.id.edTxtCD);
        ((Button) customDialog.findViewById(R.id.btnCerrar))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtVwDemo.setText(sd_txtInputData.getText().toString());
                        customDialog.dismiss();
                    }
                });
        customDialog.show();
    }
    private void showMyAlertDialogFragment(MainActivity mainActivity) {
        DialogFragment dialogFragment = MyAlertDialogFragment.newInstance(R.string.title);
        dialogFragment.show(getFragmentManager(),"TAG_MYDIALOGFRAGMENT1");
     }
     public void doPositiveClick(Date time) {
         txtVwDemo.setText("POSITIVE - DialogFragment picked @ " + time);
    }
    public void doNegativeClick(Date time) {
        txtVwDemo.setText("NEGATIVE - DialogFragment picked @ " + time);
    }
    public void doNeutralClick(Date time) {
        txtVwDemo.setText("NEUTRAL - DialogFragment picked @ " + time);
    }
}
