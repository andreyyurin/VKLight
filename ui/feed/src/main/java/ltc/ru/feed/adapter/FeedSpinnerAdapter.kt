package ltc.ru.feed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import ltc.ru.feed.R

class FeedSpinnerAdapter(context: Context, var objects: Array<String>) : BaseAdapter() {
    override fun getItem(position: Int): Any {
        return objects[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return objects.size
    }

    val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: FeedSpinnerViewHolder
        val view: View
        if (convertView == null) {
            view = mInflater.inflate(R.layout.spinner_item, parent, false)
            viewHolder = FeedSpinnerViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as FeedSpinnerViewHolder
        }

        viewHolder.spTextView.text = objects[position]

        return view
    }


}