package ltc.ru.feed.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ltc.ru.domain.models.ItemFeedPhotos
import ltc.ru.feed.R
import ltc.ru.sharedui.date.ConverterDate

internal class FeedPhotosAdapter(
    private val context: Context
    /*private val onNewsPostClick: (String) -> Unit*/
) : RecyclerView.Adapter<FeedPhotosViewHolder>() {

    private var items: List<ItemFeedPhotos> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedPhotosViewHolder {
        return FeedPhotosViewHolder(LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FeedPhotosViewHolder, position: Int) {

        holder.rvDate.text =
            ConverterDate().getTimePublication(items[position].date.toString(), holder.rvDate.context)
        if(items[position].type.equals("photo_tag")){
            val photosArr = items[position].photoTags!!.items
            if (photosArr[0].sizes[photosArr[0].sizes.size-1].url != null) {
                val url = photosArr[0].sizes[photosArr[0].sizes.size-1].url
                Glide
                    .with(holder.rvImage.context)
                    .load(url)
                    .into(holder.rvImage)
            }
        }else{
            val photosArr = items[position].photos!!.items
            if (photosArr[0].sizes[photosArr[0].sizes.size-1].url != null) {
                val url = photosArr[0].sizes[photosArr[0].sizes.size-1].url
                Glide
                    .with(holder.rvImage.context)
                    .load(url)
                    .into(holder.rvImage)
            }
        }
    }

    fun swapItems(items: List<ItemFeedPhotos>) {
        this.items = items
        notifyDataSetChanged()
    }


}