package ltc.ru.feed.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.photo_item.view.*

internal class FeedPhotosViewHolder(view: View): RecyclerView.ViewHolder(view){
    var rvImage = view.photo
    var rvDate = view.date
}
