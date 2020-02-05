package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.DetalheFilme

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.renanmenegheti.appconsumidorfilmestmdb.R
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.utils.GlideApp
import kotlinx.android.synthetic.main.detalhe_filme.*


class DetalheFilmeActivity : AppCompatActivity(), DetalheFilmeContract.View {

    companion object {

        // código de comunicação entre activities
        private const val ID_FILME: String = "idFilme"

    }

    var idFilme: String? = null
    val presenter: DetalheFilmeContract.Presenter = DetalheFilmePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe_filme)

        // recebendo o id do filme clicado na lista
        idFilme = intent.getStringExtra(ID_FILME)
        if (idFilme != null){
            presenter.onGetFilmeById(idFilme!!)
        }
    }

    override fun exibeMensagem(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    // carrega foto de backdrop e informações formatadas do filme
    override fun mostraFilme(filme: Filme) {

        GlideApp.with(this)
            .load(filme.backdrop_url)
            .error(R.mipmap.ic_broken_image)
            .into(imgFilme)

        pbCarregandoDetalheFilme.visibility = ProgressBar.INVISIBLE
        tvTituloFilme.text = filme.title
        tvGenerosFilme.text = filme.genres.toString()
        tvAvaliacaoFilme.text = filme.vote_average
        tvDuracaoFilme.text = "${filme.runtime} min"
        // data formatada do padrão americano para o brasileiro
        tvLancamentoFilme.text = "${filme.release_date.slice(8..9)}/${filme.release_date.slice(5..6)}/${filme.release_date.slice(0..3)}"
        tvOverview.text = filme.overview

    }
}
