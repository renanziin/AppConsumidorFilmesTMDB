package br.com.renanmenegheti.appconsumidorfilmestmdb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializer() {

    companion object{

        // url base da REST API consumida
        private const val BASE_URL =  "https://desafio-mobile.nyc3.digitaloceanspaces.com/"

    }

    // GsonConverterFactory é o conversor de objeto para JSON (e JSON para objeto)
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createFilmesService() = retrofit.create(FilmesService::class.java)

}