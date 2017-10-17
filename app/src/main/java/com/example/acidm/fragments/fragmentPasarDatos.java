package com.example.acidm.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragmentPasarDatos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_pasar_datos, container, false);

        TextView txtPasado = (TextView)view.findViewById(R.id.txtDatosPasados);

        SharedPreferences sp2 = getActivity().getSharedPreferences("prefe", Activity.MODE_PRIVATE);
        String inicioComo = sp2.getString("APIkey","");

        if (inicioComo != null ) {
            txtPasado.setText(inicioComo);
        }

        if (getArguments() != null ){

            txtPasado.setText(getArguments().getString("texto"));


            SharedPreferences sp = getActivity().getSharedPreferences("prefe", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("APIkey", getArguments().getString("texto"));

            editor.commit();
        }

        return view;

    }
}
