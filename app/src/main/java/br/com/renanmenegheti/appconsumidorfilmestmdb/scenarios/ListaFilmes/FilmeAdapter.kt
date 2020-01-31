package br.com.renanmenegheti.appconsumidorfilmestmdb.scenarios.ListaFilmes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.renanmenegheti.appconsumidorfilmestmdb.R
import br.com.renanmenegheti.appconsumidorfilmestmdb.entities.Filme
import br.com.renanmenegheti.appconsumidorfilmestmdb.utils.GlideApp
import kotlinx.android.synthetic.main.filmes_item.view.*


class FilmeAdapter(val context: Context, val filmes: List<Filme>): RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

//    var itemClickListener: ((index: Int) -> Unit)? = null
//
//    fun setOnClickListener(clique: ((index: Int) -> Unit)){
//        this.itemClickListener = clique
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filmes_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, filmes[position])
    }



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindView(context: Context, filme: Filme) {
            itemView.tvNomeFilme.text = filme.title

            System.out.println(filme.poster_url)

            GlideApp.with(context)
                .load(filme.poster_url)
                .placeholder(R.mipmap.ic_broken_image)
                .centerCrop()
                .into(itemView.imgFilme)


//            if(itemClickListener != null) {
//                itemView.setOnClickListener {
//                    itemClickListener.invoke(adapterPosition)
//                }
//            }

        }

    }

}