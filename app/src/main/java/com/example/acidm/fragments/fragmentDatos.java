package com.example.acidm.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fragmentDatos extends Fragment {

    Button btnCambiarTexto, btnCambiarPantalla, btnPasarDatos;
    TextView txtDato;
    EditText edtDato;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_datos, container, false);

        btnCambiarTexto = (Button)view.findViewById(R.id.btnCambiarTexto);
        txtDato = (TextView)view.findViewById(R.id.txtDato);

        btnCambiarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDato.setText("Ya se usar Fragments");
            }
        });

        btnCambiarPantalla = (Button)view.findViewById(R.id.btnCambiarPantalla);
        btnCambiarPantalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment nombreX = new fragmentPasarDatos();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.actividad, nombreX, "tag");
                ft.addToBackStack("tag");
                ft.commit();
            }
        });

        edtDato = (EditText)view.findViewById(R.id.edtDato);
        btnPasarDatos = (Button)view.findViewById(R.id.button3);
        btnPasarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment nombreY = new fragmentPasarDatos();
                Bundle args = new Bundle();

                args.putString("texto", "Ya sabes pasar datos entre fragmentos, tu dato es: " + edtDato.getText());

                nombreY.setArguments(args);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.actividad, nombreY, "tag");
                ft.addToBackStack("tag");
                ft.commit();
            }
        });

        return view;

    }
}
