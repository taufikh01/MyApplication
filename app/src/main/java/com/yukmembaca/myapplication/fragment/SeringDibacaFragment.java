package com.yukmembaca.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.yukmembaca.myapplication.R;
import com.yukmembaca.myapplication.adapter.Beranda.RvAdapter;
import com.yukmembaca.myapplication.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SeringDibacaFragment extends Fragment {
    private String URL_JSON = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private List<Anime> lstAnime = new ArrayList<>();
    private RecyclerView myrv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sering_dibaca, container, false);
        myrv = (RecyclerView) view.findViewById(R.id.rv);
        jsoncall();
        return view;
    }

    public void jsoncall() {


        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();

                        anime.setName(jsonObject.getString("name"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setImage_url(jsonObject.getString("img"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                        lstAnime.add(anime);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setRvadapter(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(ArrayRequest);
    }

    private void setRvadapter(List<Anime> lstAnime) {
        RvAdapter myAdapter = new RvAdapter(getActivity(),lstAnime) ;
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(myAdapter);
    }

}