package com.assessment.moviecatalog.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.moviecatalog.R
import com.assessment.moviecatalog.model.Movie
import com.assessment.moviecatalog.view.DetailMovieActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_movie.view.*

class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    private var list: List<Movie> = ArrayList()

    fun setMovieList(list: ArrayList<Movie> ){

        this.list = list
        notifyDataSetChanged()
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val movieTitle = itemView.tv_movie_title!!
        val moviePoster = itemView.imgv_movie_poster!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_movie,parent,false)
        val holder = MovieHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.movieTitle.text = list[position].title
        val url: String = list[position].posterPath
        val id = list[position].id
        Glide.with(context).load("http://image.tmdb.org/t/p/w342$url").into(holder.moviePoster)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra("movie_id", id)
            context.startActivity(intent)
        }

    }
}


