package com.yukmembaca.myapplication.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.yukmembaca.myapplication.R;

public class BukuActivity extends AppCompatActivity {

    private TextView txJudul,txpegarang,txpenerbit,txthn,txdesk;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);

        Toolbar ToolBarAtas2 = (Toolbar)findViewById(R.id.toolbar_detailbuku);
        setSupportActionBar(ToolBarAtas2);
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txJudul = (TextView) findViewById(R.id.tvJudul);
        txpegarang = (TextView) findViewById(R.id.tvPengarang);
        txpenerbit = (TextView) findViewById(R.id.tvPenerbit);
        txthn = (TextView) findViewById(R.id.tvTahunTerbit);
        txdesk = (TextView) findViewById(R.id.tvDeskripsi);
        img = (ImageView) findViewById(R.id.ivbuku_id);


        //receive data
        Intent intent = getIntent();
        String judul = intent.getExtras().getString("Judul");
        String pengarang = intent.getExtras().getString("Pengarang");
        String penerbit = intent.getExtras().getString("Penerbit");
        String thn_terbit = intent.getExtras().getString("Tahun Terbit");
        String deskripsi = intent.getExtras().getString("Deskripsi");
        int img_buku = intent.getExtras().getInt("Gambar");

        //Setting Values
        txJudul.setText(judul);
        txpegarang.setText(pengarang);
        txpenerbit.setText(penerbit);
        txthn.setText(thn_terbit);
        txdesk.setText(deskripsi);
        img.setImageResource(img_buku);
    }
}
