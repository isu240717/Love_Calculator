package com.example.love_calculator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.love_calculator.R
import com.example.love_calculator.RetrofitService
import com.example.love_calculator.databinding.FragmentMainBinding
import com.example.love_calculator.model.LoveModel
import retrofit2.Call
import retrofit2.Response

class MainFragment : Fragment() {

    lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {

                RetrofitService.api.calculateMatching(
                    firstEt.text.toString(),
                    secondEt.text.toString()
                ).enqueue(object :retrofit2.Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        findNavController().navigate(R.id.resultFragment, bundleOf("model.key" to  response.body()))
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Toast.makeText(requireContext(), "Error ${t.message}", Toast.LENGTH_SHORT).show()
                    }


                })
            }
        }
    }

}/*findNavController.navigate(R.id.resultFragment)
RetrofitService.api.calculateMatching(
firstEt.text.toString(),
secondEt.text.toString()
).enqueue(object : retrofit2.Callback<LoveModel> {
    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
        Log.e("ololo", "onResponse: ${response.body()}")
    }

    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
        Log.e("ololo", "onFailure: ${t.message}")
    }

})*/