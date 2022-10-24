package com.ksharshembie.lovecalculator

import android.app.Application
import com.ksharshembie.lovecalculator.model.LoveApi
import com.ksharshembie.lovecalculator.model.RetrofitService

class App: Application() {

    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().api
    }
}