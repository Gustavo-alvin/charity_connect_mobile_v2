package com.inf3fm.elden.charityconnect.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import com.inf3fm.elden.charityconnect.R;
import com.inf3fm.elden.charityconnect.activity.conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class CatalogoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView bancoTeste;

    public CatalogoFragment() {
        // Required empty public constructor
    }

    public static CatalogoFragment newInstance(String param1, String param2) {
        CatalogoFragment fragment = new CatalogoFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalogo, container, false);

        bancoTeste = view.findViewById(R.id.bancoTeste);

        // Configurando o TextView para acionar a conexão
        bancoTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conectarAoBanco();
            }
        });

        return view;
    }

    private void conectarAoBanco() {
        Connection conn = conexao.conectar(); // Certifique-se de que esta é a sua classe de conexão
        try {
            if (conn != null) {
                if (!conn.isClosed())
                    bancoTeste.setText("Conexão realizada com sucesso");
                else
                    bancoTeste.setText("A conexão está fechada");
            } else {
                bancoTeste.setText("Conexão nula, não estabelecida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            bancoTeste.setText("Conexão falhou\n" + e.getMessage());
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);-

        // Encontrar o SearchView pelo ID dentro do layout do fragmento
        SearchView searchView = view.findViewById(R.id.search_view);

        // Configurar o SearchView conforme necessário
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Ação quando o usuário submeter a query
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Ação quando o texto da query é alterado
                return false;
            }
        });
    }
}
