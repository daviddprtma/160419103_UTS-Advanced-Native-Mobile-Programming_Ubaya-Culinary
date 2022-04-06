package id.davidpratama.a160419103_ubayaculinary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.ReviewRestaurant
import kotlinx.android.synthetic.main.fragment_restaurant_detail.view.*

class RestaurantDetailAdapter(val restaurantDetailList: ArrayList<ReviewRestaurant>):RecyclerView.Adapter<RestaurantDetailAdapter.RestaurantDetailViewHolder>() {
    class RestaurantDetailViewHolder(var view:View) : RecyclerView.ViewHolder(view)

    fun updateDetailReviewRestaurant(newReviewRestaurantDetail:ArrayList<ReviewRestaurant>){
        restaurantDetailList.clear()
        restaurantDetailList.addAll(newReviewRestaurantDetail)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantDetailViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_restaurant_detail,parent,false)
        return RestaurantDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantDetailViewHolder, position: Int) {
        val restaurantDetail = restaurantDetailList[position]
        with(holder.view){
            txtNamaReview.text = restaurantDetail.nama
            txtKomentarReview.text = restaurantDetail.komentar
        }
    }

    override fun getItemCount(): Int {
        return restaurantDetailList.size
    }
}