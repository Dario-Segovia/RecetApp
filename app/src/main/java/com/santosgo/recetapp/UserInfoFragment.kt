package com.santosgo.recetapp

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val nombreUsuario = sharedPreferences.getString("username", "Usuario")

        val welcomeText = view.findViewById<TextView>(R.id.welcomeText)

        // Usamos la cadena definida en strings.xml con el nombre de usuario dinámico
        welcomeText.text = getString(R.string.welcome_message, nombreUsuario)
    }
}
