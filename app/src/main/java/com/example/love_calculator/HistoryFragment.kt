package com.example.love_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.love_calculator.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = App.appDatabase.getDao().getAll()

        list.forEach {
            binding.tvListHistory.text = list.joinToString(separator = "", prefix = "", postfix = "")
        }
    }

}