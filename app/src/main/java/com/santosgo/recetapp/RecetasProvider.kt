package com.santosgo.recetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

object RecetasProvider {
    val listaRecetas = listOf(
        RecetasItem(
            "Paella", "Almuerzo", "España",
            "https://imag.bonviveur.com/paella-de-pollo.jpg"
        ),
        RecetasItem(
            "Sushi", "Almuerzo", "Japón",
            "https://hisupo.es/wp-content/uploads/2023/03/menu-poru.webp"
        ),
        RecetasItem(
            "Sisig", "Cena", "Filipinas",
            "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjoeSA_7MahFx69ymeHQJPhA9vmvCqz2DMJi_jMAP9IOK2fe_sGMi0BV1hbCeMM_auX4aTMHyayvtFvpH1EHZGjHgkppR46VtVWrY0NdQ8QlyqEvBal96xRw_vhT7MJ5Ur3x6bYVg3GkA/s320/sisig.jpg"
        ),
        RecetasItem(
            "Cocido madrileño", "Almuerzo", "España",
            "https://www.laespanolaaceites.com/wp-content/uploads/2019/06/cocido-madrileno-1080x671.jpg"
        ),
        RecetasItem(
            "Tacos al pastor", "Merienda", "México",
            "https://imag.bonviveur.com/tacos-al-pastor.jpg"
        ),
        RecetasItem(
            "Pizza Margherita", "Cena", "Italia",
            "https://es.giallozafferano.com/images/3-364/Pizza-napolitana_1200x800.jpg"
        ),
        RecetasItem(
            "Hamburguesa", "Cena", "Estados Unidos",
            "https://imag.bonviveur.com/hamburguesa-clasica.jpg"
        ),
        RecetasItem(
            "Ceviche", "Cena", "Perú",
            "https://es.cravingsjournal.com/wp-content/uploads/2018/08/ceviche-con-leche-de-tigre-2.jpg"
        )
    )
}