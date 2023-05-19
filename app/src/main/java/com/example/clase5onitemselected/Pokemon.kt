package com.example.clase5onitemselected

data class Pokemon
    (

        val id: Int,  /*El Id debería ir siempre, porque después es lo que uso para
        ubicar a cada uno inequívocamente dentro del recyclerView*/
        val name: String,
        val vida: Int,
        val fuerza: Int,
        val defensa: Int,
        val velocidad: Int,
        val imagenTipo: TipoPokemon,
        val url: String
)

enum class TipoPokemon
    {
        PLANTA, AGUA, FUEGO, LUCHA, ELECTRICO
    }