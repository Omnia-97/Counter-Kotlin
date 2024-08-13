package com.example.counterkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.counterkotlin.databinding.ActivityMainBinding
import com.example.counterkotlin.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        counterViewModel.count.observe(this, Observer { count ->
            binding.textViewNum.text = count.toString()
        })


        binding.startButton.setOnClickListener {
            counterViewModel.start()
        }
        binding.stopButton.setOnClickListener {
            counterViewModel.stop()
        }
        binding.resetButton.setOnClickListener {
            counterViewModel.reset()
        }
    }


}