package com.wilgon.exploradordelugaresturisticos.ui.Mapa;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.model.LatLng;

public class MapsFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<LatLng> mLocation;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;

    //modificar el mapa
    private MutableLiveData<Integer> mapType = new MutableLiveData<>();


    public MapsFragmentViewModel(@NonNull Application application) {
        super(application);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(application);
    }

    public LiveData<LatLng> getMLocation() {
        if (mLocation == null) {
            mLocation = new MutableLiveData<>();
        }
        return mLocation;
    }

    public void obtenerUltimaUbicacion() {
        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                mLocation.setValue(new LatLng(location.getLatitude(), location.getLongitude()));
            }
        });
    }


    public void iniciarActualizacionUbicacion() {
        LocationRequest locationRequest = new LocationRequest.Builder(5000) // intervalo de 5000 milisegundos (5 segundos)
                //.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY) // precision equilibrada
                .setPriority(Priority.PRIORITY_HIGH_ACCURACY) // precision alta

                //.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY) // prioridad alta de precision
                .setMinUpdateIntervalMillis(5000) // 5 segundos
                .build();
        //cambiarlo, esta muy rapido
        /*
        LocationRequest locationRequest = new LocationRequest.Builder()
                .setInterval(5000) // 5 segundos
                .setFastestInterval(2000) // 2 segundos
                .Priority.PRIORITY_HIGH_ACCURACY
                .build();
*/
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                if (locationResult != null) {
                    for (Location location : locationResult.getLocations()) {
                        mLocation.setValue(new LatLng(location.getLatitude(), location.getLongitude()));
                    }
                }
            }
        };

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }


    public void detenerActualizacionUbicacion() {
        if (locationCallback != null) {
            fusedLocationClient.removeLocationUpdates(locationCallback);
        }
    }


    //modificacion del mapa


    public LiveData<Integer> getMapType() {

        return mapType;
    }

    public void cambiarTipoMapa(int tipoMapa) {
        mapType.setValue(tipoMapa);
        Log.d("entra", "cambia a " + tipoMapa);
    }


}
