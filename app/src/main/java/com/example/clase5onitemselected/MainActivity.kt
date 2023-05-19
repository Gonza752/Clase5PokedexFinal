package com.example.clase5onitemselected

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = PokemonAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoPokemon())
        //adapter.onItemClickListener = { pokemon -> Toast.makeText(this, pokemon.name, Toast.LENGTH_SHORT).show() }
        //ESTO SERIA SOLO PARA MOSTRAR UN TOAST, AHORA VAMOS A HACER QUE NOS LLEVE A UNA NUEVA VENTANA Y NOS DE DETALLES
        adapter.onItemClickListener = { pokemon ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", pokemon.name)
            intent.putExtra("url", pokemon.url)
            startActivity(intent)
        }
    }
    private fun getListadoPokemon(): MutableList<Pokemon> {
        return mutableListOf(
            Pokemon(1,"Bulbasaur", 45, 56, 53, 44, TipoPokemon.PLANTA,"https://archives.bulbagarden.net/media/upload/f/fb/0001Bulbasaur.png"),
            Pokemon(2,"Charmaleon", 46, 46, 83,40, TipoPokemon.FUEGO, "https://archives.bulbagarden.net/media/upload/0/05/0005Charmeleon.png"),
            Pokemon(3,"Pikachu", 60, 50, 38,70, TipoPokemon.ELECTRICO, "https://archives.bulbagarden.net/media/upload/4/4a/0025Pikachu.png"),
            Pokemon(4,"Squirtle", 47, 66, 30,55, TipoPokemon.AGUA, "https://archives.bulbagarden.net/media/upload/thumb/5/54/0007Squirtle.png/1200px-0007Squirtle.png")
        )
    }

}