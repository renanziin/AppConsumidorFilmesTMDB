package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import android.content.Context
import android.util.Log
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.network.RetrofitInicializer
import io.paperdb.Paper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaFilmesPresenter(val view: ListaFilmesContract.View): ListaFilmesContract.Presenter {


    override fun onGetListaTopFilmes(){

        Paper.init(view as Context)

        val filmesService = RetrofitInicializer().createFilmesService()

        val call = filmesService.getTopFilmes()

        call.enqueue(object: Callback<List<Filme>>{
            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {

                val cacheFilmes: List<Filme>? = Paper.book().read("filmes")

                if (cacheFilmes == null){
                    view.exibirMensagem("Falha na conexão.")
                } else {
                    view.exibirMensagem("Mostrando dados em cache.")
                    view.mostraLista(cacheFilmes)
                }

            }

            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                if (response.body() == null){

                    val cacheFilmes: List<Filme>? = Paper.book().read("filmes")

                    if (cacheFilmes == null){
                        view.exibirMensagem("Sem filmes para hoje.")
                    } else {
                        view.exibirMensagem("Mostrando dados em cache.")
                        view.mostraLista(cacheFilmes)
                    }

                } else {
                    Paper.book().write("filmes", response.body()!!)
                    view.mostraLista(response.body()!!)
                }
            }

        })








    }


}