package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaFilmesPresenter(val view: ListaFilmesContract.View): ListaFilmesContract.Presenter {


    override fun onGetListaTopFilmes(){

        val filmesService = RetrofitInicializer().createFilmesService()

        val call = filmesService.getTopFilmes()

        call.enqueue(object: Callback<List<Filme>>{
            override fun onFailure(call: Call<List<Filme>>, t: Throwable) {
                view.exibirMensagem("Falha na conexao")
            }

            override fun onResponse(call: Call<List<Filme>>, response: Response<List<Filme>>) {
                if (response.body() == null){
                    view.exibirMensagem("Sem filmes para hoje")
                } else {
                    view.mostraLista(response.body()!!)
                }
            }


        })


    }


}