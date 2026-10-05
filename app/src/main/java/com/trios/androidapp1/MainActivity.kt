package com.trios.androidapp1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect the Kotlin code to the views in activity_main.xml
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val drinkSpinner = findViewById<Spinner>(R.id.drinkSpinner)
        val sizeSpinner = findViewById<Spinner>(R.id.sizeSpinner)
        val orderButton = findViewById<Button>(R.id.orderButton)
        val orderResult = findViewById<TextView>(R.id.orderResult)

        // Drink choices
        val drinks = arrayOf(
            "Coffee",
            "Tea",
            "Hot Chocolate",
            "Iced Coffee"
        )

        // Size choices
        val sizes = arrayOf(
            "Small",
            "Medium",
            "Large",
            "Extra Large"
        )

        // Add the drink choices to the drink spinner
        val drinkAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            drinks
        )
        drinkAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        drinkSpinner.adapter = drinkAdapter

        // Add the size choices to the size spinner
        val sizeAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            sizes
        )
        sizeAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        sizeSpinner.adapter = sizeAdapter

        // Run this code when the Place Order button is pressed
        orderButton.setOnClickListener {

            val customerName = nameInput.text.toString().trim()
            val selectedDrink = drinkSpinner.selectedItem.toString()
            val selectedSize = sizeSpinner.selectedItem.toString()

            // Make sure the customer entered a name
            if (customerName.isEmpty()) {
                nameInput.error = "Please enter your name"
            } else {
                // Display the completed order
                orderResult.text =
                    "Order for $customerName:\n$selectedSize $selectedDrink"
            }
        }
    }
}