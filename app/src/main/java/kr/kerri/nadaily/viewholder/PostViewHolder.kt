package kr.kerri.nadaily.viewholder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kr.kerri.nadaily.R
import kr.kerri.nadaily.models.Post

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val postTitle: TextView = itemView.findViewById(R.id.postTitle)
    private val postAuthor: TextView = itemView.findViewById(R.id.postAuthor)
    private val postNumStars: TextView = itemView.findViewById(R.id.postNumHearts)
    private val postBody: TextView = itemView.findViewById(R.id.postBody)
    private val heart: ImageView = itemView.findViewById(R.id.heart)

    fun bindToPost(post: Post, starClickListener: View.OnClickListener) {
        postTitle.text = post.title
        postAuthor.text = post.author
        postNumStars.text = post.heartCount.toString()
        postBody.text = post.body

        heart.setOnClickListener(starClickListener)
    }

    fun setLikedState(liked: Boolean) {
        if (liked) {
            heart.setImageResource(R.drawable.ic_fill_heart)
        } else {
            heart.setImageResource(R.drawable.ic_empty_heart)
        }
    }
}
