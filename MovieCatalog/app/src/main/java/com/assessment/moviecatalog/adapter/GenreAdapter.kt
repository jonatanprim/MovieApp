package com.assessment.moviecatalog.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.moviecatalog.R
import com.assessment.moviecatalog.model.Genre
import com.assessment.moviecatalog.view.MovieActivity
import kotlinx.android.synthetic.main.card_genre.view.*

class GenreAdapter(private val context: Context) : RecyclerView.Adapter<GenreAdapter.GenreHolder>() {

    private var list: List<Genre> = ArrayList()

    fun setGenreList(list: ArrayList<Genre> ){

        this.list = list
        notifyDataSetChanged()
    }

    class GenreHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val genre_name = itemView.tv_genre_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_genre,parent,false)

        return GenreHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {

        holder.genre_name.text = list[position].name
        val id = list[position].id

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra("genre_id", id)
            context.startActivity(intent)
        }

    }
}