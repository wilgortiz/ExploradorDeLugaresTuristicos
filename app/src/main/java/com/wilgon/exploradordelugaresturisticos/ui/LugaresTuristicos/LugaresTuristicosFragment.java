package com.wilgon.exploradordelugaresturisticos.ui.LugaresTuristicos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wilgon.exploradordelugaresturisticos.R;

import java.util.ArrayList;

public class LugaresTuristicosFragment extends Fragment {

    private LugaresTuristicosViewModel lugaresTuristicosViewModel;
    private RecyclerView recyclerView;
    private LugaresTuristicosAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        lugaresTuristicosViewModel =
                new ViewModelProvider(this).get(LugaresTuristicosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_lugaresturisticos, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //adapter = new LugaresTuristicosAdapter(new ArrayList<LugaresTuristicos>());
        adapter = new LugaresTuristicosAdapter(requireContext(), new ArrayList<LugaresTuristicos>());

        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // aca puedo obtener los lugares turísticos desde el ViewModel y actualizar el adaptador
        lugaresTuristicosViewModel.getLugaresTuristicos().observe(getViewLifecycleOwner(), lugaresTuristicos -> {
            adapter.setLugaresTuristicos(lugaresTuristicos);
            adapter.notifyDataSetChanged();
        });
    }
}
