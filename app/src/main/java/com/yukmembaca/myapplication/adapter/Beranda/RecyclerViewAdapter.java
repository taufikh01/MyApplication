package com.yukmembaca.myapplication.adapter.Beranda;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yukmembaca.myapplication.R;
import com.yukmembaca.myapplication.activity.BukuActivity;
import com.yukmembaca.myapplication.model.buku;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<buku> mData;

    public RecyclerViewAdapter(Context mContext, List<buku> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_book,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.tv_judul.setText(mData.get(i).getJudul());
        myViewHolder.img_buku.setImageResource(mData.get(i).getGambarBuku());


        //set click listener
        myViewHolder.cv_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BukuActivity.class);

                //passing data to the BukuActivity
                intent.putExtra("Gambar",mData.get(i).getGambarBuku());
                intent.putExtra("Judul",mData.get(i).getJudul());
                intent.putExtra("Pengarang",mData.get(i).getPengarang());
                intent.putExtra("Penerbit",mData.get(i).getPenerbit());
                intent.putExtra("Tahun Terbit",mData.get(i).getTahunTerbit());
                intent.putExtra("Deskripsi",mData.get(i).getDeskripsi());
                //start the activity
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_buku;
        TextView tv_judul;
        CardView cv_book;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_buku = (ImageView) itemView.findViewById(R.id.imgCoverBuku);
            tv_judul = (TextView) itemView.findViewById(R.id.tvJudul);
            cv_book = (CardView) itemView.findViewById(R.id.card_view_book_id);


        }
    }

}
