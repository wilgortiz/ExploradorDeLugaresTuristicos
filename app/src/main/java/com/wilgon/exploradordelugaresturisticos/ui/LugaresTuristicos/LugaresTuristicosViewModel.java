package com.wilgon.exploradordelugaresturisticos.ui.LugaresTuristicos;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.wilgon.exploradordelugaresturisticos.R;

import java.util.ArrayList;
import java.util.List;

public class LugaresTuristicosViewModel extends AndroidViewModel {

    private MutableLiveData<List<LugaresTuristicos>> lugaresTuristicosLiveData;

    public LugaresTuristicosViewModel(@NonNull Application application) {
        super(application);
        lugaresTuristicosLiveData = new MutableLiveData<>();
        cargarLugaresTuristicos();
    }

    public LiveData<List<LugaresTuristicos>> getLugaresTuristicos() {
        return lugaresTuristicosLiveData;
    }

    private void cargarLugaresTuristicos() {
        List<LugaresTuristicos> lista = new ArrayList<>();


        // creamo y agregamos los objetos LugaresTuristicos a la lista
       /*
        LugaresTuristicos lugar1 = new LugaresTuristicos("Machu Picchu", "Antigua ciudad inca en Perú", -13.1631, -72.5450);
        LugaresTuristicos lugar2 = new LugaresTuristicos("Torre Eiffel", "Torre de hierro forjado en París", 48.8584, 2.2945);
        LugaresTuristicos lugar3 = new LugaresTuristicos("Gran Muralla China", "Antigua muralla defensiva en China", 40.6769, 117.2319);

        lugaresTuristicos.add(lugar1);
        lugaresTuristicos.add(lugar2);
        lugaresTuristicos.add(lugar3);
*/

        lista.add(new LugaresTuristicos("todo el dia", 1, "Potrero de Los funes", "Sin dudas Potrero es de los lugares turísticos de San Luis más lindos." +
                " Es tan única que tiene embalse en medio de la ciudad rodeada de un autódromo (si si, así de rara). El autódromo se inaguró en el 2008, y tiene diferentes salidas que te llevan a algún punto de la ciudad", 26.0584, 51.21054, R.drawable.potrero1, R.drawable.potrero2));
        lista.add(new LugaresTuristicos("todo el dia", 2, "El Volcan", "\n" +
                "El Volcán es un destacado destino turístico ubicado en la provincia de San Luis, Argentina. Con una altura de aproximadamente 2,116 metros sobre el nivel del mar, ofrece a los visitantes la oportunidad de disfrutar de impresionantes vistas panorámicas" +
                "y de realizar actividades como senderismo y montañismo. Su entorno natural ofrece una experiencia única para los amantes de la naturaleza y los deportes al aire libre. Además, su acceso relativamente accesible lo convierte en un destino popular para aquellos que" +
                "buscan aventuras en la montaña.", 26.0584, 51.21054, R.drawable.elvolcan1, R.drawable.elvolcan2));
        lista.add(new LugaresTuristicos("todo el dia", 3, "El Trapiche", "El pueblo cuenta con un balneario natural y con establecimientos hoteleros, además de servicios turísticos complementarios.\n" +
                "\n" + "Cada verano, desde 1984, la municipalidad del pueblo organiza la Fiesta de Los Ríos, que tiene carácter provincial. Se complementa con actividades culturales" +
                "(exposición de cuadros y artesanías) y deportivas (competencias de triatlón, maratón y carreras de bicicletas). En la última noche del festival se realiza la elección y coronación de la Reina Provincial de Los Ríos, con la participación de postulantes de todo el ejido municipal, y un gran baile popular. También, desde la década de 1960, de celebra el festejo del día del estudiante y el comienzo de la primavera, cada 21 de septiembre.\n" +
                "\n" +
                "Cuenta con una Estación de Piscicultura y una Reserva Florofaunística. En el ingreso de la localidad se encuentra la Secretaría de Turismo, en donde se contemplan dos monumentos artísticos que caracterizan el lugar", 26.0584, 51.21054, R.drawable.eltrapiche2, R.drawable.rioeltrapiche));
        lista.add(new LugaresTuristicos("de 09 a 18 hs", 4, "Réplica del Cabildo", "\n" +
                "El Cabildo de La Punta, en San Luis, es una réplica exacta del histórico Cabildo de Buenos Aires, construido en conmemoración del Bicentenario" +
                "de la Revolución de Mayo. Este impresionante edificio colonial de 2.008 m2 cuenta con una arquitectura fiel a la original, incluyendo detalles" +
                "como carpintería, herrería y muebles artesanales. Ofrece actividades recreativas, culturales y educativas, así como visitas guiadas para conocer la historia argentina desde sus inicios." + "" +
                "Un espacio sobresaliente que sirve como casa cultural y escenario para eventos artísticos y culturales variados.", 26.0584, 51.21054, R.drawable.cabildo1, R.drawable.cabildoulp));

        lista.add(new LugaresTuristicos("todo el dia", 5, "Embalse La Florida", "\n" +
                "Al pie de las Sierras de San Luis, toma las aguas del río Grande y del río Trapiche. A partir de allí, da nacimiento al río Quinto. Cubre unas 704 ha (652, según algunas fuentes,1\u200B 725 según otras\u200B) con un ancho máximo de 4 km y una profundidad media de 12 m, aunque la máxima alcanza los 45 m." +
                "Tiene una capacidad de 105 hm³, su capacidad de riego es de 10 000 ha, y su superficie de cuenca es de unos 500 km².\u200B\n" +
                "\n" +
                "Es la principal fuente de agua dulce de las ciudades de San Luis y Villa Mercedes. A partir de su construcción, en su vera nació la localidad de La Florida.\u200B\n" +
                "\n" +
                "Actividades turísticas\n" +
                "En la costa oeste se ubican diversos cámpines y la Estación de Piscicultura. La Reserva de flora y fauna La Florida ocupa 340 ha a orillas del embalse; allí se protege fauna autóctona, como el lagarto overo." +

                "\n" + "Actividades Turisticas:" +
                "En las aguas del embalse se realizan diversos deportes náuticos, como Buceo, Windsurf, Kayak. También es posible pescar y bañarse en determinados sectores."
                , 26.0584, 51.21054, R.drawable.laflorida1, R.drawable.laflorida2));

        lista.add(new LugaresTuristicos("de 09 a 18 hs", 6, "Museo Histórico San Luis", "El Museo Histórico de San Luis (MUHSAL) es un museo ubicado en la ciudad de San Luis, capital de la provincia homónima, en el centro oeste de Argentina, destinado a la historia provincial" +
                "El espacio exhibe la historia provincial a lo largo de diez salas temáticas, desde la era precolombina hasta el presente. Cada sala ofrece una experiencia sensorial mediante recursos audiovisuales y objetos donados por familias locales.\n" +
                "\n" +
                "Las salas son:\n" +
                "\n" +
                "1 El anaquel de la memoria: Una biblioteca a gran escala con libros ficticios que evocan hitos históricos.\n" +
                "2 América sin nombre: Desde el 8500 AC hasta la llegada de los colonizadores españoles.\n" +
                "3 Conquista y Colonización: Desde los primeros exploradores españoles hasta la Revolución de Mayo.\n" +
                "4 El llamado de la libertad: La gesta por la independencia de Argentina.\n" +
                "5 Poncho celeste, vincha punzó: Los enfrentamientos entre unitarios y federales.\n" +
                "6 Por el camino de la Constitución: El acto de jura de la Constitución provincial en 1855.\n" +
                "7 Para todos los hombres del mundo: La llegada de inmigrantes a partir de 1880.\n" +
                "8 Argentina: luces y sombras: Desde el primer centenario (1910) hasta el fin de la última dictadura.\n" +
                "9 Autopistas al porvenir: Avances desde la recuperación de la democracia en 1983.\n" +
                "10 Puntanos inolvidables: Homenaje a personalidades destacadas nacidas en la provincia.", -33.303540, -66.336048, R.drawable.muhsal4, R.drawable.muhsal2));
        lugaresTuristicosLiveData.setValue(lista);
    }

/*
    public LugaresTuristicos getLugarTuristicoById(int lugarTuristicoId) {
        List<LugaresTuristicos> lugaresTuristicos = lugaresTuristicosLiveData.getValue();
        if (lugaresTuristicos != null) {
            for (LugaresTuristicos lugar : lugaresTuristicos) {
                if (lugar.getId() == lugarTuristicoId) {
                    return lugar;
                }
            }
        }
        return null; // si no se encuentra ningn lugar turistico con el id especificado
    }
*/

}


// public void verDetalle(){
//   Intent intent = new Intent(getApplication().getApplicationContext(),Detalle.class);
//        intent.putExtra("detalle",actores);
//}

