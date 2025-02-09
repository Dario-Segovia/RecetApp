package com.santosgo.recetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.santosgo.recetapp.databinding.FragmentTab2NoticeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Tab2NoticeFragment : Fragment() {

    private var _binding : FragmentTab2NoticeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTab2NoticeBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_tab2_notice, container, false)
        return binding.root
    }
}

