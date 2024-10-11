package com.inf3fm.elden.charityconnect.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.net.Uri;

import com.inf3fm.elden.charityconnect.R;
import com.inf3fm.elden.charityconnect.activity.MainActivity2;

public class MenuFragment extends Fragment {

    private Button buttonFale;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // Configurando o clique no botão "Fale Conosco"
        View faleConosco = view.findViewById(R.id.faleconosco);
        faleConosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaleConosco();
            }
        });

        // Configurando o clique no botão "Sobre Nós"
        View sobreNos = view.findViewById(R.id.sobrenos);
        sobreNos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSobre(); // Chama openSobre
            }
        });

        // Configurando o clique no botão "Website"
        View website = view.findViewById(R.id.website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });

        // Configurando o clique no botão "Termos de Uso"
        View termosDeUso = view.findViewById(R.id.termosdeuso);
        termosDeUso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTerms();
            }
        });

        return view;
    }

    private void openFaleConosco() {
        // Aqui você pode definir a lógica para abrir a tela "Fale Conosco"
        Intent intent = new Intent(getActivity(), MainActivity2.class);
        intent.putExtra("action", "fale_conosco"); // Passando a ação
        startActivity(intent); // Iniciando a nova atividade
    }

    private void openWebsite() {
        // Aqui você pode definir a lógica para abrir o site
        String url = "https://charity-connect-chi.vercel.app"; // URL do site
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent); // Iniciando o navegador
    }

    private void openTerms() {
        String url = "https://charity-connect-chi.vercel.app/termos"; // URL do site
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent); // Iniciando o navegador
    }
    private void openSobre() {
        String url = "https://charity-connect-chi.vercel.app/sobre"; // URL do site
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent); // Iniciando o navegador
    }
}
