package br.com.renanmenegheti.appconsumidorfilmestmdb.network

import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmesService {

    // recebe a lista com os 20 melhores filmes avaliados pela TMDB
    @GET("movies")
    fun getTopFilmes(): Call<List<Filme>>

    @GET("movies/{id}")
    fun getFilmeById(@Path ("id")id: String): Call<Filme>


}