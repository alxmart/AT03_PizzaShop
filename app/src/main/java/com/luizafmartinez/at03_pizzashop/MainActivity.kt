package com.luizafmartinez.at03_pizzashop

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luizafmartinez.at03_pizzashop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onPlaceOrderButtonClicked(view: View) {

        var pizzaSizePrice = 0.0
        var toppingsTotal = 0.0

        when {
            binding.smallpizza.isChecked -> pizzaSizePrice = 5.0
            binding.mediumpizza.isChecked -> pizzaSizePrice = 7.0
            binding.largepizza.isChecked -> pizzaSizePrice = 9.0
        }

        if (binding.OnionsCheckBox.isChecked) {
            toppingsTotal += 1
        }

        if (binding.OlivesCheckBox.isChecked) {
            toppingsTotal += 2
        }

        if (binding.TomatoesCheckBox.isChecked) {
            toppingsTotal += 3
        }

        binding.totalPrice.text = "Total Order Price= $" + (pizzaSizePrice + toppingsTotal)
    }

}