package com.ksharshembie.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ksharshembie.lovecalculator.databinding.ActivityMainBinding
import com.ksharshembie.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btCalculate.setOnClickListener {
                App.api.calculate(
                    binding.firstNameEt.text.toString(),
                    binding.secondNameEt.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            Log.e(
                                "ololo",
                                "onResponse: Percentage: ${response.body()?.percentage} Result: ${response.body()?.result}"
                            )
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "onFailure: ${t.message}")
                        }

                    })
            }
        }
    }
}