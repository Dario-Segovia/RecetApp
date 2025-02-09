package com.santosgo.recetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




data class RecetasItem(
    val nombre: String,
    val Tipo: String,
    val Origen: String,
    val foto: String
)