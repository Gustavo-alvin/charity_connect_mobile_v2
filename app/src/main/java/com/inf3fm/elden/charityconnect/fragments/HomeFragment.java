package com.inf3fm.elden.charityconnect.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.inf3fm.elden.charityconnect.R;
import com.inf3fm.elden.charityconnect.activity.MainActivity2;
import com.inf3fm.elden.charityconnect.adapters.HomeAdapter;
import com.inf3fm.elden.charityconnect.models.HomeItem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private Button buttonFaleConosco;
    private ViewPager2 viewPager;
    private List<HomeItem> homeItems;
    private Button buttonNext, buttonPrevious;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        buttonNext = view.findViewById(R.id.buttonNext);
        buttonPrevious = view.findViewById(R.id.buttonPrevious);
        buttonFaleConosco = view.findViewById(R.id.teste);

        homeItems = new ArrayList<>();
        homeItems.add(new HomeItem(R.drawable.imagem1, "Fome.", "O Brasil retornou ao mapa da fome..."));
        homeItems.add(new HomeItem(R.drawable.imagem2, "Abusos.", "Milhares de crianças sofrem abusos..."));
        homeItems.add(new HomeItem(R.drawable.imagem3, "Inclusão.", "Garantimos uma vida digna para idosos..."));

        HomeAdapter adapter = new HomeAdapter(homeItems, getContext());
        viewPager.setAdapter(adapter);


        buttonNext.setOnClickListener(v -> viewPager.setCurrentItem(viewPager.getCurrentItem() + 1));
        buttonPrevious.setOnClickListener(v -> viewPager.setCurrentItem(viewPager.getCurrentItem() - 1));

        buttonFaleConosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getActivity(), MainActivity2.class);
                startActivity(it);
            }
        });


        return view;
    }

}