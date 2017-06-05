package com.example.stefanus.programkuis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stefanus on 21/05/2017.
 */

public class DataHelper extends SQLiteOpenHelper {
    //Membuat database awal
    private static final String DB_NAME = "programkuis.db";
    private static final int DB_VER = 1;

    //Membuat database
    public DataHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Membuat table soalsoal
        String sql = "create table soalsoal(no integer primary key,soal text null,jawaban_a text null,jawaban_b text null, jawaban_c text null,jawaban_d text null,jawaban text null);";
        db.execSQL(sql);

        //Membuat table rekor
        sql = "create table rekor(nama text null, total integer null);";
        db.execSQL(sql);

        //Input soal-soal ke table soalsoal
        db.execSQL("insert into soalsoal values ('1','2*2+1','1','3','5','7','C');");
        db.execSQL("insert into soalsoal values ('2','16/2-1','1','3','5','7','D');");
        db.execSQL("insert into soalsoal values ('3','4*2-5','1','3','5','7','A');");
        db.execSQL("insert into soalsoal values ('4','100/2','20','30','40','50','D');");
        db.execSQL("insert into soalsoal values ('5','9/3-3','0','2','4','8','A');");
        db.execSQL("insert into soalsoal values ('6','9*(9-7)','82','74','18','81','C');");
        db.execSQL("insert into soalsoal values ('7','8/2','2','3','4','5','C');");
        db.execSQL("insert into soalsoal values ('8','3*2-1','2','3','4','5','D');");
        db.execSQL("insert into soalsoal values ('9','10/2-3','2','3','4','5','A');");
        db.execSQL("insert into soalsoal values ('10','4/2-1','1','3','5','7','A');");
        db.execSQL("insert into soalsoal values ('11','5/0','~','0','1','2','A');");
        db.execSQL("insert into soalsoal values ('12','6/2','2','3','4','5','B');");
        db.execSQL("insert into soalsoal values ('13','9+9','8','18','28','38','B');");
        db.execSQL("insert into soalsoal values ('14','7*9','89','88','63','81','C');");
        db.execSQL("insert into soalsoal values ('15','9*9','82','74','18','81','D');");
        db.execSQL("insert into soalsoal values ('16','100/25','3','4','5','6','B');");
        db.execSQL("insert into soalsoal values ('17','100/50','3','2','5','6','B');");
        db.execSQL("insert into soalsoal values ('18','4*4','16','25','36','49','A');");
        db.execSQL("insert into soalsoal values ('19','4*9*0','3','0','2','1','B');");
        db.execSQL("insert into soalsoal values ('20','3^3','3','9','27','81','B');");
        db.execSQL("insert into soalsoal values ('21','4^4','16','25','36','49','A');");
        db.execSQL("insert into soalsoal values ('22','5/0','~','0','1','2','A');");
        db.execSQL("insert into soalsoal values ('23','2*3-2','2','3','4','5','C');");
        db.execSQL("insert into soalsoal values ('24','6/3+1','2','3','4','5','B');");
        db.execSQL("insert into soalsoal values ('25','20*5/2','50','25','21','33','A');");
        db.execSQL("insert into soalsoal values ('26','2/2*2','2','0','1','3','A');");
        db.execSQL("insert into soalsoal values ('27','7^2-3','20','31','49','46','D');");
        db.execSQL("insert into soalsoal values ('28','10/2-1','0','2','4','8','C');");
        db.execSQL("insert into soalsoal values ('29','5*2-8','0','2','4','8','B');");
        db.execSQL("insert into soalsoal values ('30','7+7+1-2+1-5-2+1','0','2','4','8','D');");
        db.execSQL("insert into soalsoal values ('31','9*9','89','88','82','81','D');");
        db.execSQL("insert into soalsoal values ('32','6*9','36','54','72','81','B');");
        db.execSQL("insert into soalsoal values ('33','8*9','36','54','72','81','C');");
        db.execSQL("insert into soalsoal values ('34','9*0','0','1','2','3','A');");
        db.execSQL("insert into soalsoal values ('35','5^2-7','12','22','18','19','C');");
        db.execSQL("insert into soalsoal values ('36','2^3','4','8','2','1','B');");
        db.execSQL("insert into soalsoal values ('37','2*5-2','2','6','8','10','C');");
        db.execSQL("insert into soalsoal values ('38','7*7-9','23','52','21','40','D');");
        db.execSQL("insert into soalsoal values ('39','100/2/2','32','25','51','67','B');");
        db.execSQL("insert into soalsoal values ('40','1/2','0.2','0.3','0.4','0.5','D');");

        //Input default rekor values
        db.execSQL("insert into rekor values ('null','0')");
        db.execSQL("insert into rekor values ('null','0')");
        db.execSQL("insert into rekor values ('null','0')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
