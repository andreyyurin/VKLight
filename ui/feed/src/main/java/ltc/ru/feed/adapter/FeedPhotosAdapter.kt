package ltc.ru.feed.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.facebook.drawee.drawable.ScalingUtils
import ltc.ru.domain.models.ItemFeedPhotos
import ltc.ru.domain.models.ResponseUser
import ltc.ru.feed.R
import ltc.ru.sharedui.date.ConverterDate

internal class FeedPhotosAdapter(
    private val context: Context,
    private val openImageScreen: (String) -> Unit
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
        initPhotoClickListener(holder, position)
    }

    private fun initPhotoClickListener(holder: FeedPhotosViewHolder, position: Int) {
        holder.rvImage.setOnClickListener {
            if (items[position].type.equals("photo_tag")) {
                val photosArr = items[position].photoTags!!.items
                val url = photosArr[0].sizes[photosArr[0].sizes.size - 1].url
                openImageScreen(url)
            } else {
                val photosArr = items[position].photos!!.items
                val url = photosArr[0].sizes[photosArr[0].sizes.size - 1].url
                openImageScreen(url)
            }
        }
    }

    private fun setPostData(holder: FeedPhotosViewHolder, position: Int) {
        if (!items.isEmpty()) {
            holder.rvDate.text =
                ConverterDate().getTimePublication(items[position].date.toString(), holder.rvDate.context)
            val url: String
            if (items[position].type.equals("photo_tag")) {
                val photosArr = items[position].photoTags!!.items
                url = photosArr[0].sizes[photosArr[0].sizes.size - 1].url
            } else {
                val photosArr = items[position].photos!!.items
                url = photosArr[0].sizes[photosArr[0].sizes.size - 1].url
            }

            Glide
                .with(context)
                .load(url)
                .into(holder.rvImage)
        }
    }

    private fun setUserData(holder: FeedPhotosViewHolder, position: Int) {
        if (!users.isEmpty() && position < users.size) {
            val url = users[position].photoMaxOrig
            holder.rvName.text = users[position].firstName + " " + users[position].lastName

            Glide
                .with(context)
                .load(url)
                .into(holder.rvAvatar)
        } else {
            val id = items[position].sourceId
            for (objectUser in users) {
                if (objectUser.id == id) {
                    val url = objectUser.photoMaxOrig
                    holder.rvName.text = objectUser.firstName + " " + objectUser.lastName

                    Glide
                        .with(holder.rvAvatar.context)
                        .load(url)
                        .into(holder.rvAvatar)
                    break
                }
            }
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