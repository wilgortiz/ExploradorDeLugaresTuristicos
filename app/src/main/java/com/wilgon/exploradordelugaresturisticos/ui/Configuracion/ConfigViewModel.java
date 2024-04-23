package com.wilgon.exploradordelugaresturisticos.ui.Configuracion;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfigViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConfigViewModel() {
       // super();
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }





    /*
    private MutableLiveData<Integer> mapTypeData = new MutableLiveData<>();

    public ConfigViewModel(@NonNull Application application) {
        super(application);
        Log.d("ConfigViewModel", "ViewModel creado correctamente");
    }

    public LiveData<Integer> getMapTypeData() {
        return mapTypeData;
    }

    public void setMapType(int mapType) {
        mapTypeData.setValue(mapType);
        Log.d("ConfigViewModel", "Tipo de mapa cambiado a: " + mapType);
    }

     */
}