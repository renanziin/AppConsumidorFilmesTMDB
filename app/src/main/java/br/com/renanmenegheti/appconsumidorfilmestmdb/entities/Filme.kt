package br.com.renanmenegheti.appconsumidorfilmestmdb.entities

data class Filme(
    val id: String,
    val original_title: String,
    val overview: String,
    val genres: List<String>,
    val poster_url: String,
    val vote_average: String,
    val release_date: String
)