package com.santosgo.recetapp

import android.content.Context

object RecetasProvider {

    // Función para obtener la lista de recetas con el contexto pasado como parámetro
    fun getListaRecetas(context: Context): List<RecetasItem> {
        return listOf(
            RecetasItem(
                context.getString(R.string.paella),
                context.getString(R.string.almuerzo),
                context.getString(R.string.espana),
                "https://imag.bonviveur.com/paella-de-pollo.jpg"
            ),
            RecetasItem(
                context.getString(R.string.sushi),
                context.getString(R.string.almuerzo),
                context.getString(R.string.japon),
                "https://hisupo.es/wp-content/uploads/2023/03/menu-poru.webp"
            ),
            RecetasItem(
                context.getString(R.string.sisig),
                context.getString(R.string.cena),
                context.getString(R.string.filipinas),
                "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjoeSA_7MahFx69ymeHQJPhA9vmvCqz2DMJi_jMAP9IOK2fe_sGMi0BV1hbCeMM_auX4aTMHyayvtFvpH1EHZGjHgkppR46VtVWrY0NdQ8QlyqEvBal96xRw_vhT7MJ5Ur3x6bYVg3GkA/s320/sisig.jpg"
            ),
            RecetasItem(
                context.getString(R.string.cocido_madrileno),
                context.getString(R.string.almuerzo),
                context.getString(R.string.espana),
                "https://www.laespanolaaceites.com/wp-content/uploads/2019/06/cocido-madrileno-1080x671.jpg"
            ),
            RecetasItem(
                context.getString(R.string.tacos_al_pastor),
                context.getString(R.string.merienda),
                context.getString(R.string.mexico),
                "https://imag.bonviveur.com/tacos-al-pastor.jpg"
            ),
            RecetasItem(
                context.getString(R.string.pizza_margherita),
                context.getString(R.string.cena),
                context.getString(R.string.italia),
                "https://es.giallozafferano.com/images/3-364/Pizza-napolitana_1200x800.jpg"
            ),
            RecetasItem(
                context.getString(R.string.hamburguesa),
                context.getString(R.string.cena),
                context.getString(R.string.estados_unidos),
                "https://imag.bonviveur.com/hamburguesa-clasica.jpg"
            ),
            RecetasItem(
                context.getString(R.string.ceviche),
                context.getString(R.string.cena),
                context.getString(R.string.peru),
                "https://es.cravingsjournal.com/wp-content/uploads/2018/08/ceviche-con-leche-de-tigre-2.jpg"
            )
        )
    }
}
