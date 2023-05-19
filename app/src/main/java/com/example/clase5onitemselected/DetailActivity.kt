package com.example.clase5onitemselected

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewName = findViewById(R.id.textViewName)
        imageView = findViewById(R.id.imageViewDetalle)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val url = bundle?.getString("url") ?: ""

        textViewName.text = nombre
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }
}