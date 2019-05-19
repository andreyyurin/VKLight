package ltc.ru.feed.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import ltc.ru.domain.models.ItemXFeedPhotos
import ltc.ru.feed.R


internal class FeedPhotoPagerAdapter(
    private val context: Context,
    private val objects: List<ItemXFeedPhotos>,
    private val openImageScreen: (String) -> Unit
) : RecyclerView.Adapter<FeedPhotoPagerViewHolder>() {

    override fun onBindViewHolder(holder: FeedPhotoPagerViewHolder, position: Int) {
        initPhotoClickListener(position, holder)
        initPhoto(position, holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedPhotoPagerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        return FeedPhotoPagerViewHolder(view)
    }

    private fun initPhoto(position: Int, viewHolder: FeedPhotoPagerViewHolder) {
        Picasso
            .get()
            .load(objects[position].sizes[objects[position].sizes.size - 1].url)
            .into(viewHolder.gridPhoto)
    }

    private fun initPhotoClickListener(position: Int, viewHolder: FeedPhotoPagerViewHolder) {
        val url = objects[position].sizes[objects[0].sizes.size - 1].url
        viewHolder.gridPhoto.setOnClickListener { openImageScreen(url) }
    }


    override fun getItemCount(): Int {
        return objects.size
    }

}