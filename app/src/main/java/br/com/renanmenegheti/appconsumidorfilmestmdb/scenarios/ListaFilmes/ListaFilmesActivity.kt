package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.renanmenegheti.appconsumidorfilmestmdb.R
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import kotlinx.android.synthetic.main.lista_filmes.*

class ListaFilmesActivity : AppCompatActivity(), ListaFilmesContract.View {

    val presenter: ListaFilmesContract.Presenter = ListaFilmesPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_filmes)

        presenter.onGetListaTopFilmes()

    }


    override fun exibirMensagem(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun mostraLista(filmes: List<Filme>) {
        val adapter = FilmeAdapter(this, filmes)
        rvListaFilmes.adapter = adapter
        rvListaFilmes.layoutManager = LinearLayoutManager(this)
    }
}
