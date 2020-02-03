package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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

        val spanCount = calculaSpans()

        val adapter = FilmeAdapter(this, filmes)
        rvListaFilmes.adapter = adapter
        rvListaFilmes.layoutManager = GridLayoutManager(this, spanCount)
    }

    fun calculaSpans(): Int {
        val displayMetrics: DisplayMetrics = this.getResources().getDisplayMetrics()
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        // Where 180 is the width of your grid item. You can change it as per your convention.
        // Where 180 is the width of your grid item. You can change it as per your convention.
        val spanCount = (dpWidth / 180).toInt()
        return spanCount
    }
}
