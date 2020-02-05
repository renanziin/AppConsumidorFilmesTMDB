package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.renanmenegheti.appconsumidorfilmestmdb.R
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.DetalheFilme.DetalheFilmeActivity
import kotlinx.android.synthetic.main.lista_filmes.*


class ListaFilmesActivity : AppCompatActivity(), ListaFilmesContract.View {

    companion object {

        // código de comunicação entre activities
        private const val ID_FILME: String = "idFilme"

    }

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

        val spanCount = calculaSpans()

        val adapter = FilmeAdapter(this, filmes)
        adapter.setOnClickListener { position ->
            val abrirActivityDetalheFilme = Intent(this, DetalheFilmeActivity::class.java)
            abrirActivityDetalheFilme.putExtra(ID_FILME, filmes[position].id)
            startActivity(abrirActivityDetalheFilme)

        }
        rvListaFilmes.adapter = adapter
        rvListaFilmes.layoutManager = GridLayoutManager(this, spanCount)
    }

    fun calculaSpans(): Int {
        val displayMetrics: DisplayMetrics = this.getResources().getDisplayMetrics()
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val spanCount = (dpWidth / 160).toInt()
        // Where 160 is the width of your grid item. You can change it as per your convention.
        return spanCount
    }
}
