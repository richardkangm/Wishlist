package codepath.com.rxk200031.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wlItems: List<WishlistItems>):
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val name: TextView
        val price: TextView
        val url: TextView

        init {
            name = view.findViewById<TextView>(R.id.tvName)
            price = view.findViewById<TextView>(R.id.tvPrice)
            url = view.findViewById<TextView>(R.id.tvURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wishlist_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wlItems[position]

        holder.name.text = wish.name
        holder.price.text = wish.price
        holder.url.text = wish.url
    }

    override fun getItemCount() = wlItems.size
}