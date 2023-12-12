package com.example.love_calculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw4.LoveViewModel
import com.example.love_calculator.databinding.FragmentNameBinding
import com.example.love_calculator.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NameFragment : Fragment() {
    private lateinit var binding : FragmentNameBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveData(
                    firstName = firstEt.text.toString(),
                    secondName = secondEt.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer {

                        App.appDatabase.getDao().insert(it)

                        Log.d("ololo", "initListener: $it")
                        findNavController().navigate(
                            R.id.resultFragment, bundleOf(
                                "result" to it
                            )
                        )
                    })
                utils.showToast(requireContext())
            }
        }
    }
}