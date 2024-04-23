package com.wilgon.exploradordelugaresturisticos.ui.Configuracion;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.os.ConfigurationCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.GoogleMap;
import com.wilgon.exploradordelugaresturisticos.MainActivity;
import com.wilgon.exploradordelugaresturisticos.R;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.GoogleMap;
import com.wilgon.exploradordelugaresturisticos.R;
import com.wilgon.exploradordelugaresturisticos.databinding.FragmentMapsBinding;
import com.wilgon.exploradordelugaresturisticos.ui.Mapa.MapsFragment;
import com.wilgon.exploradordelugaresturisticos.ui.Mapa.MapsFragmentViewModel;

import java.util.Locale;


public class ConfiguracionFragment extends Fragment {


    private FragmentMapsBinding binding;

    private MapsFragmentViewModel mapsViewModel; // ViewModel para comunicarse con MapsFragment

    private Locale myLocale;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_config, container, false);
        binding = FragmentMapsBinding.bind(root);

        // Inicializar ViewModel para comunicarse con MapsFragment
        mapsViewModel = new ViewModelProvider(requireActivity()).get(MapsFragmentViewModel.class);

        //  botones de idioma
        Button btnEspañol = root.findViewById(R.id.radioButtonEspañol);
        Button btnIngles = root.findViewById(R.id.radioButtonIngles);

        btnEspañol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).setAppLocale("es");
            }
        });

        btnIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) requireActivity()).setAppLocale("en");
            }
        });


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Button buttonCambiarMapa = view.findViewById(R.id.buttonCambiarMapa);

        // Botones para cambiar el tipo de mapa
        Button buttonNormal = view.findViewById(R.id.buttonNormal);
        Button buttonSatelite = view.findViewById(R.id.buttonSatelite);
        Button buttonHibrido = view.findViewById(R.id.buttonHibrido);
        Button buttonTerreno = view.findViewById(R.id.buttonTerreno);


        //Button buttonNormal = view.findViewById(R.id.buttonNormal);
        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapsViewModel.cambiarTipoMapa(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        //Button buttonSatelite = view.findViewById(R.id.buttonSatelite);
        buttonSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapsViewModel.cambiarTipoMapa(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });


        // Button buttonHibrido = view.findViewById(R.id.buttonHibrido);
        buttonHibrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapsViewModel.cambiarTipoMapa(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        //Button buttonTerreno = view.findViewById(R.id.buttonTerreno);
        buttonTerreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapsViewModel.cambiarTipoMapa(GoogleMap.MAP_TYPE_TERRAIN);
                Log.d("entra", "cambia terreno");
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}


    /*
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_config, container, false);
        binding = FragmentMapsBinding.bind(root);
        // Inicializar ViewModel para comunicarse con MapsFragment
        mapsViewModel = new ViewModelProvider(requireActivity()).get(MapsFragmentViewModel.class);

        return root;
    }
*/


/*
    @Nullable
     @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_configuracion, container, false);

         // Referencias a los checkboxes
         CheckBox checkBoxEspañol = root.findViewById(R.id.checkBoxEspañol);
         CheckBox checkBoxIngles = root.findViewById(R.id.checkBoxIngles);

         // Escuchadores para los checkboxes
         checkBoxEspañol.setOnCheckedChangeListener((buttonView, isChecked) -> {
             if (isChecked) {
                 setLocale("es");
             }
         });

         checkBoxIngles.setOnCheckedChangeListener((buttonView, isChecked) -> {
             if (isChecked) {
                 setLocale("en");
             }
         });

         return root;
     }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        requireActivity().recreate(); // Reinicia la actividad para aplicar los cambios de idioma
    }
}
*/


















/*
    private void updateLocaleConfiguration(Locale selectedLocale) {
        // actualizaria completamente
        ((MainActivity) requireActivity()).updateLocaleConfiguration();    }
*/













