package com.assessment.moviecatalog.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.assessment.moviecatalog.R
import com.assessment.moviecatalog.adapter.ReviewAdapter
import com.assessment.moviecatalog.viewModel.MovieDetailActivityViewModel
import com.assessment.moviecatalog.viewModel.ReviewActivityViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*


class DetailMovieActivity : AppCompatActivity() {

    private lateinit var  viewModel : MovieDetailActivityViewModel
    private lateinit var viewModel2 : ReviewActivityViewModel
    private lateinit var mReviewAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        setSupportActionBar(toolbar)
        supportActionBar?.title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getStringExtra("movie_id")
        recycler_review.setHasFixedSize(true)
        val horizontalLayoutManagaer = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_review.layoutManager = horizontalLayoutManagaer

        viewModel = ViewModelProvider(this).get(MovieDetailActivityViewModel::class.java)
        viewModel2 = ViewModelProvider(this).get(ReviewActivityViewModel::class.java)

        viewModel.getMovieDetail(id)
        viewModel2.getReviewList(id)

        viewModel.showProgress.observe(this, Observer {
            if(it)
                detail_progress.visibility = View.VISIBLE
            else
                detail_progress.visibility = View.GONE
        })

        viewModel.movieDetail.observe(this,Observer {
            tv_title.text = it.title
            tv_overview.text = it.overview
            rb_movie_rating.rating = it.voteAverage.toFloat() / 2
            Glide.with(this).load("http://image.tmdb.org/t/p/w342" + it.backdropPath).into(imgv_poster)
        })

        viewModel2.reviewList.observe(this, Observer{
            mReviewAdapter.setReviewList(it)
        })

        mReviewAdapter = ReviewAdapter(this)
        recycler_review.adapter = mReviewAdapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}