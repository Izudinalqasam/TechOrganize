package com.example.asus.techoorganize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class halamanBeranda extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_beranda);

        Button btnPindah = (Button) findViewById(R.id.mulaiPer);
        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inet = new Intent(halamanBeranda.this,MainActivity.class);
                startActivity(inet);
                finish();
            }
        });
    }
}
