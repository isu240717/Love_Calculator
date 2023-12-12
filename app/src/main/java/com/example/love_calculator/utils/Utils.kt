package com.example.love_calculator.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class Utils {

    fun showToast(context: Context){
        Toast.makeText(context, "Hello lucky boy/girl", Toast.LENGTH_SHORT).show()
    }
    fun Fragment.showToast(msg: String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    fun ImageView.loadImage(url: String?){
        Glide.with(this).load(url).into(this)
    }

}