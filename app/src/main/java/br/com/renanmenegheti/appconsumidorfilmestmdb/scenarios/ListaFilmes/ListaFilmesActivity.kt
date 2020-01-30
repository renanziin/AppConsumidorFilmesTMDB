package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.renanmenegheti.appconsumidorfilmestmdb.R
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import kotlinx.android.synthetic.main.activity_main.*

class ListaFilmesActivity : AppCompatActivity() {


    val filme1 = Filme("240", "Poderoso Chefao", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        listOf("Drama", "Suspense"),"https://image.tmdb.org/t/p/w200/bVq65huQ8vHDd1a4Z37QtuyEvpA.jpg", "8.5", "1974-12-20")

    val filme2 = Filme("12", "Procurando Nemo", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        listOf("Drama", "Animação"),"https://image.tmdb.org/t/p/w600_and_h900_bestv2/wc6k6nqoo5kAOMnkJsvUGuDScd8.jpg", "7.8", "2002-12-20")

    val filmes = listOf(filme1, filme2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = FilmeAdapter(this, filmes)
        rvListaFilmes.adapter = adapter
        rvListaFilmes.layoutManager = LinearLayoutManager(this)
    }


}
