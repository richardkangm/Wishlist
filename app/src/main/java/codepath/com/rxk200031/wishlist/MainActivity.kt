package codepath.com.rxk200031.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishes = mutableListOf<WishlistItems>()
        val rvWishlist = findViewById<RecyclerView>(R.id.rvWishlist)
        val wishesAdapter = WishlistAdapter(wishes)
        rvWishlist.adapter = wishesAdapter
        rvWishlist.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnEnter).setOnClickListener {


            // when button is clicked, add the new wishlist item to the view
            val etItemName = findViewById<EditText>(R.id.etItemName)
            val newItemName = etItemName.text.toString()
            etItemName.setText("")

            val etItemPrice = findViewById<EditText>(R.id.etItemPrice)
            val newItemPrice = etItemPrice.text.toString()
            etItemPrice.setText("")

            val etItemUrl = findViewById<EditText>(R.id.etItemUrl)
            val newItemUrl = etItemUrl.text.toString()
            etItemUrl.setText("")

            wishes.add(WishlistItems(newItemName, newItemPrice, newItemUrl))
            wishesAdapter.notifyItemInserted(wishes.size)
        }
    }

}