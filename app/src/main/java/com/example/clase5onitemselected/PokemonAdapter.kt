package com.example.clase5onitemselected

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonAdapter(val context: Context) : ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Pokemon) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewNombre: TextView = view.findViewById(R.id.textViewNombre)
        private val textViewVida: TextView = view.findViewById(R.id.textViewVida)
        private val textViewFuerza: TextView = view.findViewById(R.id.textViewFuerza)
        private val textViewDefensa: TextView = view.findViewById(R.id.textViewDefensa)
        private val textViewVelocidad: TextView = view.findViewById(R.id.textViewVelocidad)
        private val imagenTipo: ImageView = view.findViewById(R.id.imageViewTipo)
        private val imagenPokemon: ImageView = view.findViewById(R.id.imageViewImagen)

        fun bind (pokemon: Pokemon) {
            textViewNombre.text = "Nombre: " + pokemon.name
            textViewVida.text = "Vida: " + pokemon.vida.toString()
            textViewFuerza.text = "| Fuerza: " + pokemon.fuerza.toString()
            textViewDefensa.text = "| Defensa: " + pokemon.defensa.toString()
            textViewVelocidad.text = "| Velocidad: " + pokemon.velocidad.toString()

            val image = when(pokemon.imagenTipo) {
                TipoPokemon.AGUA -> R.drawable.agua
                TipoPokemon.PLANTA -> R.drawable.planta
                TipoPokemon.FUEGO -> R.drawable.fuego
                TipoPokemon.ELECTRICO -> R.drawable.electrico
                TipoPokemon.LUCHA -> R.drawable.fighter
            }

            imagenTipo.setImageResource(image)

            Glide.with(context)
                .load(pokemon.url)
                .into(imagenPokemon)

            view.setOnClickListener{
                onItemClickListener(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}