package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.DetalheFilme

import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalheFilmePresenter(val view: DetalheFilmeContract.View): DetalheFilmeContract.Presenter {

    override fun onGetFilmeById(id: String){

        val filmesService = RetrofitInicializer().createFilmesService()

        val call = filmesService.getFilmeById(id)

        call.enqueue(object: Callback<Filme>{

            override fun onFailure(call: Call<Filme>, t: Throwable) {
                view.exibeMensagem("Falha na conexão")
            }

            override fun onResponse(call: Call<Filme>, response: Response<Filme>) {
                if (response.body() == null){
                    view.exibeMensagem("Não foi possível acessar ao filme")
                } else {
                    view.mostraFilme(response.body()!!)
                }
            }



        })

    }

}