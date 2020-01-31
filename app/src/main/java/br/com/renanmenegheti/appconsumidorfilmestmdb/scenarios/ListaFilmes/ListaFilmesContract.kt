package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme

interface ListaFilmesContract {

    interface View{
        fun exibirMensagem(msg: String)
        fun mostraLista(filmes: List<Filme>)
    }

    interface Presenter{
        fun onGetListaTopFilmes()
    }

}