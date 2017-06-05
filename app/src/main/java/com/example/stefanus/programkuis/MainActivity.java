package com.example.stefanus.programkuis;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_mulai, btn_rekor;
    EditText et_nama;

    DataHelper dbHelper;

    int jmlSoalTerjawab = 0;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DataHelper(this);

        btn_mulai = (Button) findViewById(R.id.btn_mulai);
        btn_rekor = (Button) findViewById(R.id.btn_rekor);
        et_nama = (EditText) findViewById(R.id.et_nama);
        et_nama.setText("");

        btn_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = et_nama.getText().toString();
                if (nama.equals("")) {
                    Toast.makeText(v.getContext(), "Input nama dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    masukSoal();
                }
            }
        });
        btn_rekor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityRekor.class);
                startActivity(i);
            }
        });
    }

    //Mulai soal
    public void masukSoal() {
        Intent i = new Intent(MainActivity.this, ActivitySoal.class);
        i.putExtra("jml", "" + jmlSoalTerjawab);
        i.putExtra("benar", "0");
        i.putExtra("nama", nama);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apakah anda ingin keluar dari App?");
        builder.setCancelable(true);
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
