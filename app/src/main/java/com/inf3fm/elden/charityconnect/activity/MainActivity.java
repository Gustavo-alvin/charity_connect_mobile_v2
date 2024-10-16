package com.inf3fm.elden.charityconnect.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.inf3fm.elden.charityconnect.ProdutoFragment;
import com.inf3fm.elden.charityconnect.R;
import com.inf3fm.elden.charityconnect.fragments.CatalogoFragment;
import com.inf3fm.elden.charityconnect.fragments.HomeFragment;
import com.inf3fm.elden.charityconnect.fragments.MenuFragment;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity
    implements ProdutoFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;

    private ImageButton buttonHome, buttonCatalogo, buttonMenu, buttonProduto;

    private Button buttonFaleConosco;
    private HomeFragment homeFragment;
    private CatalogoFragment catalogoFragment;
    private MenuFragment menuFragment;
    private ProdutoFragment produtoFragment;

    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonHome = findViewById(R.id.buttonHome);
        buttonCatalogo = findViewById(R.id.buttonCatalogo);
        buttonMenu = findViewById(R.id.buttonMenu);
      //  buttonProduto = findViewById(R.id.buttonProduto);

        homeFragment = new HomeFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, homeFragment);
        transaction.commit();

//        buttonCatalogo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//           catalogoFragment = new CatalogoFragment();
//
//           FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//           transaction.replace(R.id.frameConteudo, catalogoFragment);
//           transaction.commit();
//            }
//        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFragment = new HomeFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, homeFragment);
                transaction.commit();

            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuFragment = new MenuFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, menuFragment);
                transaction.commit();

            }
        });

        buttonCatalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produtoFragment = new ProdutoFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, produtoFragment);
                transaction.commit();

            }
        });

    }

}