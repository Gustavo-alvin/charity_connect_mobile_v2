package com.inf3fm.elden.charityconnect;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inf3fm.elden.charityconnect.placeholder.PlaceholderContent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ProdutoFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProdutoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProdutoFragment newInstance(int columnCount) {
        ProdutoFragment fragment = new ProdutoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
            recyclerView.setAdapter(new MyONGRecyclerViewAdapter(pesquisarONGs()));
        }
        return view;
    }

    public Connection conexaoBD() {
        Connection conexao = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        //    conexao = DriverManager.getConnection("jdbc:jtds:sqlserver://bd_CharityConnect_INF3FM.mssql.somee.com;databaseName=bd_CharityConnect_INF3FM;user=gustavo;password=41943419;");
            conexao = DriverManager.getConnection("jdbc:jtds:sqlserver://bd_CharityConnect_INF3FM.mssql.somee.com;databaseName=bd_CharityConnect_INF3FM;user=gustavo;password=41943419;");
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return conexao;

    }

    public List<ONG> pesquisarONGs() {
        List<ONG> listaONGs = new ArrayList<>();
        try {
            PreparedStatement pst = conexaoBD().prepareStatement("select id, nome, nomeRep, email, telefone, cep, uf, foto from ONG");

            ResultSet res = pst.executeQuery();

            while (res.next()) {
                listaONGs.add(new ONG(
                        res.getLong(1),
                        res.getString(2),
                        res.getBytes(8)
                ));
            }

            Toast.makeText(getContext(), "CARREGANDO ONGs", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listaONGs;
    }

    public interface OnListFragmentInteractionListener {
    }
}