package br.com.fabio.junior.zupflix.presentation.genres.animation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fabio.junior.zupflix.BuildConfig
import br.com.fabio.junior.zupflix.R
import br.com.fabio.junior.zupflix.data.response.GenresResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class AnimationFragmentAdapter(val genres: List<GenresResults>): RecyclerView.Adapter<AnimationFragmentAdapter.AnimationAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimationFragmentAdapter.AnimationAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return AnimationAdapterViewHolder(itemView)
    }

    override fun getItemCount() = genres.count()

    override fun onBindViewHolder(holder: AnimationFragmentAdapter.AnimationAdapterViewHolder, position: Int) {
        holder.bind(genres[position])
    }

    class AnimationAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textNameMovie = itemView.textNameMovie
        private val textVoteAverage = itemView.textVoteAverage
        private val imageViewMovie = itemView.imageViewMovie
        private val textReleaseDate = itemView.textReleaseDate
        private val picasso = Picasso.get()

        fun bind(movie: GenresResults) {

            textNameMovie.text = movie.originalTitle
            textVoteAverage.text = movie.voteAverage.toString()
            textReleaseDate.text = movie.releaseDate

            movie.posterPath.let {
                picasso.load("""${BuildConfig.BASE_URL_IMAGE}${movie.posterPath}""")
                    .into(imageViewMovie)
            }
        }
    }
}