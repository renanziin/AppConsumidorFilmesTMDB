package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.DetalheFilme

import android.content.Context
import android.util.Log
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.network.RetrofitInicializer
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalheFilmePresenter(val view: DetalheFilmeContract.View): DetalheFilmeContract.Presenter {

    override fun onGetFilmeById(id: String){

        Paper.init(view as Context)

        val filmesService = RetrofitInicializer().createFilmesService()

        val call = filmesService.getFilmeById(id)

        call.enqueue(object: Callback<Filme>{

            override fun onFailure(call: Call<Filme>, t: Throwable) {

                // conferindo se o filme está em cache
                val filmeEmCache: Filme? = Paper.book().read(id)

                if (filmeEmCache == null) {
                    view.exibeMensagem("Falha na conexão.")
                } else {
                    view.exibeMensagem("Mostrando dados em cache.")
                    view.mostraFilme(filmeEmCache!!)
                }
            }

            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {

                // mesmo obtendo a resposta, seu corpo pode ser nulo, entao conferimos no cache novamente
                if (response.body() == null){

                    val filmeEmCache: Filme? = Paper.book().read(id)

                    if (filmeEmCache == null){
                        view.exibeMensagem("Filme indisponível.")
                    } else{
                        view.exibeMensagem("Mostrando dados em cache.")
                        view.mostraFilme(filmeEmCache!!)
                    }

                } else {
                    // estamos gravando como chave o id do filme recebido, e estamos considerando que ele NÃO É NULO e É ÚNICO e que nunca será "filmes"
                    Paper.book().write(response.body()!!.id, response.body()!!)
                    view.mostraFilme(response.body()!!)
                }
            }



        })

    }

}