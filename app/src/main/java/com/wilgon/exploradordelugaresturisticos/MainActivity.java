package com.wilgon.exploradordelugaresturisticos;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.LocaleListCompat;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import androidx.core.os.ConfigurationCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.os.LocaleListCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.wilgon.exploradordelugaresturisticos.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        solicitarPermisos();

        // Configurar idioma predeterminado (por ejemplo, español)
        // Locale.setDefault(new Locale("es"));
        //updateLocaleConfiguration();

        // Configurar idioma predeterminado (por ejemplo, español)
        setAppLocale("es");


        setSupportActionBar(binding.appBarMain.toolbar);
        /*
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         */
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_mapa, R.id.nav_config, R.id.nav_slideshow, R.id.nav_salir)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

/*
    //metodo que actualiza la configuracion del idioma
    public void updateLocaleConfiguration() {
        //Configuration configuration = getResources().getConfiguration();
        // Obtener el idioma seleccionado
        // Locale selectedLocale = new Locale("es"); // Reemplaza "es" con el idioma seleccionado
        // Actualizar la configuración regional
        // ConfigurationCompat.setLocale(configuration, selectedLocale);
        // Recrear la actividad para aplicar los cambios de idioma
        // recreate();
        //Configuration configuration = getResources().getConfiguration();
        // Recrear la actividad para aplicar los cambios de idioma
        //recreate();
    }
*/

    public void setAppLocale(String localeCode) {
        Locale locale = new Locale(localeCode);
        Locale.setDefault(locale);

        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.locale = locale;
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        recreate(); // reiniciamos la actividad para aplicar los cambios de idioma
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void solicitarPermisos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && (checkSelfPermission(ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) ||
                (checkSelfPermission(ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 1000);
        }

    }

}
