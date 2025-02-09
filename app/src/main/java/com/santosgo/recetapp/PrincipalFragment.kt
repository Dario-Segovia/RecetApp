package com.santosgo.recetapp

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.santosgo.recetapp.databinding.FragmentPrincipalBinding


class PrincipalFragment : Fragment() {
    private var _binding : FragmentPrincipalBinding? = null
    private val binding get() = _binding!!
    private var nombreUsuario: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPrincipalBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val navHostFragment = childFragmentManager.findFragmentById(R.id.titulo) as? NavHostFragment
        if (navHostFragment != null) {

        } else {

            Log.e("Fragment Error", "Fragment is not a NavHostFragment")
        }
        val navController = navHostFragment?.navController


        if (navController != null) {
            binding.barramenu.setupWithNavController(navController)
        }



        binding.barramenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(ItemListFragment())
                    true
                }
                R.id.nav_favorites -> {
                    replaceFragment(FavItemListFragment())
                    true
                }
                R.id.nav_userinfo -> {
                    replaceFragment(UserInfoFragment())
                    true
                }
                else -> false
            }
        }

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext())
        nombreUsuario = sharedPreferences.getString("username", "Usuario")



    }
    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.titulo, fragment)
            .commit()
    }





}
