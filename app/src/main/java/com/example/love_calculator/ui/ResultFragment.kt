package com.example.love_calculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.love_calculator.databinding.FragmentResultBinding
import com.example.love_calculator.model.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getResult()
    }

    private fun getResult(){
        with(binding){
            val result = arguments?.getSerializable("model.key") as LoveModel
            numberText.text = result.percentage
            resultText.text= result.result
        }
    }
}
