package ltc.ru.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.photo_item.view.*

internal class FeedPhotosViewHolder(view: View): RecyclerView.ViewHolder(view){
    val rvImage = view.photo
    val rvDate = view.date
    val rvName = view.name
    val rvAvatar = view.avatar
}
