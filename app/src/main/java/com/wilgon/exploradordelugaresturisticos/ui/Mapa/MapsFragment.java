package com.wilgon.exploradordelugaresturisticos.ui.Mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wilgon.exploradordelugaresturisticos.R;
import com.wilgon.exploradordelugaresturisticos.ui.Configuracion.ConfigViewModel;

public class MapsFragment extends Fragment {


    private GoogleMap map;
    private ConfigViewModel configViewModel;
    private MapsFragmentViewModel mapsViewModel;
    private Marker ultimoMarcador; // variable para mantener el utimo marcador agregado


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("entra", "onViewCreated");

        // obtenemos el ViewModel del fragmento de mapa
        // mapsViewModel = new ViewModelProvider(this).get(MapsFragmentViewModel.class);


        // obtenemos el ViewModel compartido(con el requireActivity funciona)
        mapsViewModel = new ViewModelProvider(requireActivity()).get(MapsFragmentViewModel.class);


        // inicializar el fragmento de mapa
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                    Log.d("entra", "onMapReady");

                    map = googleMap;

                    // Habilitar los controles de zoom
                    map.getUiSettings().setZoomControlsEnabled(true);


                    //marcadores para el mapa:
                    if (map != null) {
                        LatLng cabildoLP = new LatLng(-33.183653, -66.312708);
                        map.addMarker(new MarkerOptions()
                                .position(cabildoLP)
                                .title("Réplica del Cabildo(La Punta)"));

                        // otro marcador
                        LatLng pdf = new LatLng(-33.2167, -66.2333);
                        map.addMarker(new MarkerOptions()
                                .position(pdf)
                                .title("Potrero de Los Funes"));

                        // otro mas
                        LatLng eV = new LatLng(-33.25, -66.2);
                        map.addMarker(new MarkerOptions()
                                .position(eV)
                                .title("El Volcan"));


                        // otro mas
                        LatLng eT = new LatLng(-33.11631, -66.06268);
                        map.addMarker(new MarkerOptions()
                                .position(eT)
                                .title("El Trapiche"));


                        LatLng lF = new LatLng(-33.113889, -66.022778);
                        map.addMarker(new MarkerOptions()
                                .position(lF)
                                .title("La Florida"));


                        LatLng mH = new LatLng(-33.303540, -66.336048);
                        map.addMarker(new MarkerOptions()
                                .position(mH)
                                .title("Museo Historico de SL(MUHSAL)"));
                    }


                    // configuramos el tipo de mapa inicial como "hibrido"
                    map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                    // observamoscambios en el tipo de mapa desde el ViewModel compartido
                    mapsViewModel.getMapType().observe(getViewLifecycleOwner(), new Observer<Integer>() {

                        @Override
                        public void onChanged(Integer tipoMapa) {
                            Log.d("entra", "lo cambiamos?");
                            map.setMapType(tipoMapa);
                        }
                    });

                    // observamos el LiveData del ViewModel del fragmento de mapa para actualizar la ubicación
                    mapsViewModel.getMLocation().observe(getViewLifecycleOwner(), new Observer<LatLng>() {
                        @Override
                        public void onChanged(LatLng location) {
                            updateLocation(location);
                        }
                    });

                    // obtener la iltima ubicacion conocida
                    mapsViewModel.obtenerUltimaUbicacion();

                    // iniciar actualizaciones de ubicacion en tiempo real
                    mapsViewModel.iniciarActualizacionUbicacion();

                    map.setOnMarkerClickListener(marker -> {
                        String snippet = marker.getSnippet(); // podemos mostrarlo en un Toast

                        return false; // devolver true si consumimos el evento, de lo contrario, false
                    });
                }
            });
        }
    }


    //forma para que el marcador este en tiempo real
    private void updateLocation(LatLng location) {
        if (location != null && map != null) {
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(location)
                    .title("Mi ubicación")
                    .snippet("Lat: " + location.latitude + "Long: " + location.longitude)
                    // cambiamos el color del marcador
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));

            // Añade el marcador al mapa
            ultimoMarcador = map.addMarker(markerOptions);

            // mueve la cam al nuevo marcador con un zoom suave
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10f), 2000, new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    // muestra el InfoWindow automaticamente una vez finalizada la animacion de la cam
                    if (ultimoMarcador != null) {
                        ultimoMarcador.showInfoWindow();
                    }
                }

                @Override
                public void onCancel() {
                    // no hago nada en caso de que se cancele la cam
                }
            });
        }
    }


}

