package ltc.ru.feed.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import ltc.ru.domain.models.ItemFeedPhotos
import ltc.ru.domain.models.ItemXFeedPhotos
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
    }


    private fun setPostData(holder: FeedPhotosViewHolder, position: Int) {
        if (!items.isEmpty()) {
            holder.rvDate.text =
                ConverterDate().getTimePublication(items[position].date.toString(), holder.rvDate.context)

            val photosArr: List<ItemXFeedPhotos>

            if (items[position].type == "photo_tag") {
                photosArr = items[position].photoTags!!.items
            } else {
                photosArr = items[position].photos!!.items
            }

            addGridImages(photosArr, holder)
        }
    }

    private fun addGridImages(items: List<ItemXFeedPhotos>, holder: FeedPhotosViewHolder) {
        val horizontalLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.rvPhotos.layoutManager = horizontalLayoutManager
        holder.rvPhotos.adapter = FeedPhotoPagerAdapter(context, items, openImageScreen)
    }


    private fun setUserData(holder: FeedPhotosViewHolder, position: Int) {
            val id = items[position].sourceId
            for (objectUser in users) {
                if (objectUser.id == id) {
                    val url = objectUser.photoMaxOrig
                    holder.rvName.text = objectUser.firstName + " " + objectUser.lastName

                    Picasso
                        .get()
                        .load(url)
                        .into(holder.rvAvatar)
                    break
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