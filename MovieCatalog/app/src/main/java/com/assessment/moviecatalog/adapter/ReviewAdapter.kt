package com.assessment.moviecatalog.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.moviecatalog.R
import com.assessment.moviecatalog.model.Review
import kotlinx.android.synthetic.main.card_review.view.*

class ReviewAdapter(private val context: Context) : RecyclerView.Adapter<ReviewAdapter.ReviewHolder>() {

    private var list: List<Review> = ArrayList()

    fun setReviewList(list: ArrayList<Review> ){

        this.list = list
        notifyDataSetChanged()
    }

    class ReviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val reviewAuthor = itemView.tv_author_name
        val reviewContent = itemView.tv_content_review

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_review,parent,false)
        val holder = ReviewHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {

        holder.reviewAuthor.text = list[position].author
        holder.reviewContent.text = list[position].content


    }
}


