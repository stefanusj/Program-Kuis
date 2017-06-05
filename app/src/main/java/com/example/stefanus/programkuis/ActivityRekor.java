package com.example.stefanus.programkuis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityRekor extends AppCompatActivity {

    Button btn_reset;
    TextView tv_detailJuara1, tv_detailJuara2, tv_detailJuara3;

    DataHelper dbHelper;
    Cursor cursor;

    String daftarNama[], daftarSkor[];
    private static int banyakJuara = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekor);

        dbHelper = new DataHelper(this);

        //Ambil data rekor
        getDataRekor();

        btn_reset = (Button) findViewById(R.id.btn_reset);
        tv_detailJuara1 = (TextView) findViewById(R.id.tv_detailJuara1);
        tv_detailJuara2 = (TextView) findViewById(R.id.tv_detailJuara2);
        tv_detailJuara3 = (TextView) findViewById(R.id.tv_detailJuara3);
        tv_detailJuara1.setText(daftarNama[0] + "      " + daftarSkor[0]);
        tv_detailJuara2.setText(daftarNama[1] + "      " + daftarSkor[1]);
        tv_detailJuara3.setText(daftarNama[2] + "      " + daftarSkor[2]);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                finish();
            }
        });
    }

    //Reset rekor
    public void reset() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("delete from rekor");
        for (int i = 0; i < banyakJuara; i++) {
            db.execSQL("insert into rekor values ('null','0')");
        }
    }

    //Ambil data rekor
    public void getDataRekor() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM rekor order by total desc", null);
        daftarNama = new String[3];
        daftarSkor = new String[3];
        cursor.moveToFirst();
        for (int cc = 0; cc < banyakJuara; cc++) {
            cursor.moveToPosition(cc);
            daftarNama[cc] = cursor.getString(0);
            daftarSkor[cc] = cursor.getString(1);
        }
    }
}
