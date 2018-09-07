package com.example.asus.techoorganize;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class halHasil extends AppCompatActivity {

    TextView textDivisi;
    String dia;
    ImageView gmbDivisi;
    TextView descDiv;
    SQLiteDatabase dbAmbil;
    aksesDatabase dbHelper;
    Intent getIn;
    Cursor kursorku;

    String insertDiv = "INSERT INTO `divisi` VALUES (2,'Dokumentasi','Dokumentasi(Kominfo) ini bertugas mengambil gambar atau video pada setiap event')," +
            "(3,'Online','Online(kominfo) bertugas menyebarkan atau membagikan informasi melalui blog atau social media, biasanya di divisi ini selalu aktif di social media')," +
            "(4,'Multimedia','Multimedia(kominfo) ini bertugas membuat desain poster, poster digital, atau desain banner untuk suatu event')," +
            "(5,'Pengembangan SDM','pada divisi ini bertugas untuk mengajak anggota-anggota untuk mengikuti suatu event')," +
            "(6,'Logistik dan Akomodasi','pada divisi ini bertugas menyiapkan peralatan yang ingin digunakan pada suatu event, serta yang memberi tahu arah lokasi ke venue pada setiap event')," +
            "(7,'Advokasi dan Pendanaan','pada divisi ini bertugas mencari dana untuk setiap event dan untuk mencari sponsor untuk suatu acara atau menjalin hubungan dengan komunitas lain')," +
            "(8,'Humas','bertugas memberi tahu atau menjarkom para anggota earth hour depok bila ada informasi ');";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_hasil);

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        getIn = getIntent();

        textDivisi = (TextView) findViewById(R.id.Rdivisi);
        textDivisi.setText(getIn.getExtras().getString("divisi"));
        descDiv = (TextView) findViewById(R.id.descDiv);

        dbHelper = new aksesDatabase(this);
        getDescipsi();

        gmbDivisi = (ImageView) findViewById(R.id.Gdivisi);

        switch (getIn.getExtras().getString("divisi")) {
            case "Pengembangan SDM":
                gmbDivisi.setImageResource(R.drawable.ppsdm);
                break;
            case "Humas":
                gmbDivisi.setImageResource(R.drawable.kominfo);
                break;
            case "Multimedia":
                gmbDivisi.setImageResource(R.drawable.kominfo);
                break;
            case "Dokumentasi":
                gmbDivisi.setImageResource(R.drawable.kominfo);
                break;
            case "Research":
                gmbDivisi.setImageResource(R.drawable.kominfo);
                break;
            case "Logistik dan Akomodasi":
                gmbDivisi.setImageResource(R.mipmap.ic_launcher);
                break;
            case "Advokasi dan Pendanaan":
                gmbDivisi.setImageResource(R.drawable.adpen);
                break;
            case "Online":
                gmbDivisi.setImageResource(R.drawable.kominfo);
                break;
            default:
                Toast.makeText(getApplicationContext(),"Tidak terdapat deskripsi",Toast.LENGTH_SHORT).show();
        }

    }

    public void getDescipsi() {
        String div;
        SQLiteDatabase tulisDivisi = dbHelper.getWritableDatabase();
        dbAmbil = dbHelper.getReadableDatabase();
        kursorku = dbAmbil.rawQuery("select * from divisi",null);
        if (kursorku.getCount() < 2) {
            tulisDivisi.execSQL(insertDiv);
            kursorku = dbAmbil.rawQuery("select * from divisi",null);
            kursorku.moveToFirst();
        } else {
            kursorku.moveToFirst();
        }

        div = getIn.getExtras().getString("divisi");
        for (int i = 0; i < kursorku.getCount(); i++) {
            kursorku.moveToPosition(i);
            dia = kursorku.getString(1).toString();
            if ( div.equalsIgnoreCase(dia)) {
                dia = kursorku.getString(2).toString();
                descDiv.setText(dia);
                break;
            }
        }

    }

    public void balik(View view) {
        Intent inet = new Intent(halHasil.this,MainActivity.class);
        startActivity(inet);
        finish();
    }
}
