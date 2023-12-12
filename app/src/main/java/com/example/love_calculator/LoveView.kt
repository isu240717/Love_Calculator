package com.example.love_calculator

import com.example.love_calculator.remote.LoveModel

interface LoveView {

    fun showResponse(response: String)

    fun showError(error: String?)

    fun navigationToResultScreen(LoveModel: LoveModel)



}