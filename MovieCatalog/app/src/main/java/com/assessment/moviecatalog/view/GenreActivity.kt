package com.assessment.moviecatalog.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.assessment.moviecatalog.R
import com.assessment.moviecatalog.adapter.GenreAdapter
import com.assessment.moviecatalog.viewModel.GenreActivityViewModel
import kotlinx.android.synthetic.main.activity_genre.*

class GenreActivity : AppCompatActivity() {

    private lateinit var  viewModel : GenreActivityViewModel
    private lateinit var mGenreAdapter : GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)

        recycler_genre.setHasFixedSize(true)
        recycler_genre.layoutManager = GridLayoutManager(this,2)

        viewModel = ViewModelProvider(this).get(GenreActivityViewModel::class.java)

        viewModel.getGenreList()

        viewModel.showProgress.observe(this, Observer {
            if(it)
                genre_progress.visibility = VISIBLE
            else
                genre_progress.visibility = GONE
        })

        viewModel.genreList.observe(this, Observer{
            mGenreAdapter.setGenreList(it)
        })

        mGenreAdapter = GenreAdapter(this)
        recycler_genre.adapter = mGenreAdapter

    }

}