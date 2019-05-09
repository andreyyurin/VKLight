package ltc.ru.feed.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ltc.ru.domain.models.ItemFeedPhotos
import ltc.ru.domain.models.ResponseUser
import ltc.ru.domain.models.VKUser
import ltc.ru.feed.R
import ltc.ru.sharedui.date.ConverterDate

internal class FeedPhotosAdapter(
    private val context: Context
) : RecyclerView.Adapter<FeedPhotosViewHolder>() {


    private var items: List<ItemFeedPhotos> = emptyList()
    private var users: List<ResponseUser> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedPhotosViewHolder {
        return FeedPhotosViewHolder(LayoutInflater.from(context).inflate(R.layout.photo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FeedPhotosViewHolder, position: Int) {
        setUserData(holder, position)
        setPostData(holder, position)
    }

    private fun setPostData(holder: FeedPhotosViewHolder, position: Int){
        if(!items.isEmpty()) {
            holder.rvDate.text =
                ConverterDate().getTimePublication(items[position].date.toString(), holder.rvDate.context)
            if (items[position].type.equals("photo_tag")) {
                val photosArr = items[position].photoTags!!.items
                if (photosArr[0].sizes[photosArr[0].sizes.size - 1].url != null) {
                    val url = photosArr[0].sizes[photosArr[0].sizes.size - 1].url
                    Glide
                        .with(holder.rvImage.context)
                        .load(url)
                        .into(holder.rvImage)
                }
            } else {
                val photosArr = items[position].photos!!.items
                if (photosArr[0].sizes[photosArr[0].sizes.size - 1].url != null) {
                    val url = photosArr[0].sizes[photosArr[0].sizes.size - 1].url
                    Glide
                        .with(holder.rvImage.context)
                        .load(url)
                        .into(holder.rvImage)
                }
            }
        }
    }

    private fun setUserData(holder: FeedPhotosViewHolder, position: Int){
        if(!users.isEmpty() && position < users.size)
        {
            val url = users[position].photoMaxOrig
            holder.rvName.text = users[position].firstName+" "+users[position].lastName

            Glide
                .with(holder.rvAvatar.context)
                .load(url)
                .into(holder.rvAvatar)
        }else{
            holder.rvName.text = "empty need to fix"
        }
    }

    fun swapPhotoItems(items: List<ItemFeedPhotos>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun swapUserItems(users: List<ResponseUser>) {
        this.users = users
        notifyDataSetChanged()
    }


}