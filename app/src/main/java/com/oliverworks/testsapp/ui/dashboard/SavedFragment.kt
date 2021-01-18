package com.oliverworks.testsapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oliverworks.testsapp.R

class SavedFragment : Fragment() {

    private lateinit var savedViewModel: SavedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedViewModel = ViewModelProvider(this).get(SavedViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_saved, container, false)

        return view
    }
}