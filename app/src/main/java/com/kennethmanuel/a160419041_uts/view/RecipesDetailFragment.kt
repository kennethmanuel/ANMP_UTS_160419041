package com.kennethmanuel.a160419041_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kennethmanuel.a160419041_uts.R
import kotlinx.android.synthetic.main.fragment_recipes_detail.*

class RecipesDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonShare.setOnClickListener{
            val action = RecipesDetailFragmentDirections.actionRecipesDetailFragmentToShareDialogFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}