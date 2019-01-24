package com.yukmembaca.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yukmembaca.myapplication.R;
import com.yukmembaca.myapplication.adapter.Beranda.RecyclerViewAdapter;
import com.yukmembaca.myapplication.model.buku;

import java.util.ArrayList;
import java.util.List;


public class BerandaFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    List<buku> listBuku;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_beranda, container, false);
        listBuku = new ArrayList<>();
        listBuku.add(new buku("Fairy Tail ","Tata Risnawan","flexy","2010","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                "\n" +
                "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",R.drawable.aa));
        listBuku.add(new buku("Avatar The Last AirBender","Fabian Arman","flexy","2013","Deskripsi",R.drawable.av));
        listBuku.add(new buku("Judul Buku 3","Pengarang","Penerbit","2019","Deskripsi",R.drawable.db_n));
        listBuku.add(new buku("Judul Buku 4","Pengarang","Penerbit","2019","Deskripsi",R.drawable.jd));
        listBuku.add(new buku("Judul Buku 5","Pengarang","Penerbit","2019","Deskripsi",R.drawable.love));
        listBuku.add(new buku("Merah Muda & Biru","Kakashi","Elex Media","1994","Deskripsi",R.drawable.mb));
        listBuku.add(new buku("Judul Buku 8","Pengarang","Penerbit","2019","Deskripsi",R.drawable.mb));

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_id);

        mAdapter = new RecyclerViewAdapter(getActivity(),listBuku);
        mLayoutManager = new GridLayoutManager(getActivity(),3);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


}
