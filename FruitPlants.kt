package com.sanjivani.nurseryplantmanagement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FruitPlants : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_plant) // Corrected layout file name

        // Find the RecyclerView in the layout
        val recyclerView = findViewById<RecyclerView>(R.id.fruitplant)

        // List of fruit plant stores to display
        val stores = listOf(
            Store("Mango", "Kopargaon, Maharashtra", "4.5", R.drawable.fruit1),
            Store("Dragon fruit", "Kopargaon, Maharashtra", "4.5", R.drawable.fruit2),
            Store("Jackfruit", "Kopargaon, Maharashtra", "4.5", R.drawable.fruit3)
        )

        // Set up the RecyclerView with a linear layout manager and adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StoreAdapter(this, stores) { store ->
            // Open DescriptionActivity with the selected store details
            val intent = Intent(this, DescriptionActivity::class.java).apply {
                putExtra("PLANT_NAME", store.name)
                putExtra("PLANT_DESCRIPTION", "Location: ${store.location}, Rating: ${store.rating}")
                putExtra("PLANT_IMAGE", store.imageRes)
            }
            startActivity(intent)
        }
    }
}
