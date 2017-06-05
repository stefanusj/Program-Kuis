package com.example.stefanus.programkuis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Stefanus on 21/05/2017.
 */

public class ActivitySoal extends AppCompatActivity {

    TextView soal;
    Button jawaban_a, jawaban_b, jawaban_c, jawaban_d;

    DataHelper dbHelper;
    Cursor cursor;

    String jawaban, nama;
    int jmlSoalTerjawab, jmlBenar;
    Random r;
    int noSoalPertama = 1;
    int noSoalTerakhir = 40;
    int banyakSoal = 10;

    int noSoal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        dbHelper = new DataHelper(this);
        r = new Random();
        noSoal = r.nextInt(noSoalTerakhir - noSoalPertama + 1) + noSoalPertama;

        soal = (TextView) findViewById(R.id.soal);
        jawaban_a = (Button) findViewById(R.id.jawaban_A);
        jawaban_b = (Button) findViewById(R.id.jawaban_B);
        jawaban_c = (Button) findViewById(R.id.jawaban_C);
        jawaban_d = (Button) findViewById(R.id.jawaban_D);

        jmlSoalTerjawab = Integer.parseInt(getIntent().getStringExtra("jml")) + 1;
        jmlBenar = Integer.parseInt(getIntent().getStringExtra("benar"));
        nama = getIntent().getStringExtra("nama");

        //Ambil data soal
        setDataSoal();

        jawaban_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jawaban.equals("A")) jmlBenar++;
                gantiSoal();
            }
        });
        jawaban_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jawaban.equals("B")) jmlBenar++;
                gantiSoal();
            }
        });
        jawaban_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jawaban.equals("C")) jmlBenar++;
                gantiSoal();
            }
        });
        jawaban_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jawaban.equals("D")) jmlBenar++;
                gantiSoal();
            }
        });
    }

    //Disable BackButton
    @Override
    public void onBackPressed() {

    }

    public void gantiSoal() {
        Intent i;
        if (jmlSoalTerjawab < banyakSoal) {
            i = new Intent(ActivitySoal.this, ActivitySoal.class);
            i.putExtra("jml", "" + jmlSoalTerjawab);
        } else
            i = new Intent(ActivitySoal.this, ActivitySelesai.class);
        i.putExtra("benar", "" + jmlBenar);
        i.putExtra("nama", nama);
        startActivity(i);
        finish();
    }

    //Ambil soal dan tampilin
    public void setDataSoal() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("select * from soalsoal where no='" + noSoal + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            soal.setText(cursor.getString(1));
            jawaban_a.setText(cursor.getString(2));
            jawaban_b.setText(cursor.getString(3));
            jawaban_c.setText(cursor.getString(4));
            jawaban_d.setText(cursor.getString(5));
            jawaban = cursor.getString(6);
        }
    }
}
