package com.example.stefanus.programkuis;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySelesai extends AppCompatActivity {

    TextView tv_benar;
    Button btn_selesai;

    DataHelper dbHelper;

    String nama, jmlBenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai);

        dbHelper = new DataHelper(this);

        tv_benar = (TextView) findViewById(R.id.tv_benar);
        btn_selesai = (Button) findViewById(R.id.btn_selesai);

        jmlBenar = getIntent().getStringExtra("benar");
        nama = getIntent().getStringExtra("nama");

        tv_benar.setText(jmlBenar);

        btn_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanDataRekor();
                Intent i = new Intent(ActivitySelesai.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void simpanDataRekor() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into rekor values ('" + nama + "','" + jmlBenar + "');");
    }
}
