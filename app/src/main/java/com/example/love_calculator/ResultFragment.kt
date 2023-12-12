package com.example.love_calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.love_calculator.databinding.FragmentResultBinding
import com.example.love_calculator.remote.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            val result = arguments?.getSerializable("result") as LoveModel
            resultText.text = result.percentage + "%"
            numberText.text = result.result
        }
    }


}