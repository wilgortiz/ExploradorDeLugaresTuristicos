package com.wilgon.exploradordelugaresturisticos.ui.salir;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Dialogo {

    //una forma
    public static void mostrarDialogo(Context context) {

            new AlertDialog.Builder(context)
                    .setTitle("Confirmar salida")
                    .setMessage("¿Desea salir? ")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //System.exit(0);
                            //requireActivity().finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }

        //otra forma
        public static void mostrarDialogo(Context context, final Activity activity) {
            new AlertDialog.Builder(context)
                    .setTitle("Confirmar salida")
                    .setMessage("¿Desea salir? ")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            activity.finish(); // Cierra la actividad actual
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // No hacer nada, solo cerrar el diálogo
                        }
                    })
                    .show();
        }

    }
