package br.com.renanmenegheti.appconsumidorfilmestmdb.entities

data class Filme(
    val id: String,
    val vote_average: String,
    val title: String,
    val poster_url: String,
    val genres: List<String>,
    val release_date: String,
    val overview: String,
    val backdrop_url: String
)