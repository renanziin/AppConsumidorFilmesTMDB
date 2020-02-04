package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.DetalheFilme

import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme

interface DetalheFilmeContract {

    interface View{
        fun exibeMensagem(msg: String)
        fun mostraFilme(body: Filme)

    }


    interface Presenter{

        fun onGetFilmeById(id: String)
    }
}