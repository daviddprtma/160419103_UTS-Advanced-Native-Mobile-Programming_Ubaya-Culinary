package id.davidpratama.a160419103_ubayaculinary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.RecommendedRestaurant
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import kotlinx.android.synthetic.main.fragment_recommended.view.*
import kotlinx.android.synthetic.main.list_recommend_restaurant.view.*

class RecommendedAdapter(val recommendedList:ArrayList<RecommendedRestaurant>):RecyclerView.Adapter<RecommendedAdapter.RecommendedViewAdapter>(){
    class RecommendedViewAdapter(var view: View):RecyclerView.ViewHolder(view)

    fun updaterecommendedList(newRecommendedList: List<RecommendedRestaurant>){
        recommendedList.clear()
        recommendedList.addAll(newRecommendedList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewAdapter {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.list_recommend_restaurant,parent,false)

        return RecommendedViewAdapter(view)
    }

    override fun onBindViewHolder(holder: RecommendedViewAdapter, position: Int) {
        val recommended = recommendedList[position]

        with(holder.view){
            txtNamaRestaurantRecommended.text = recommended.namaRecommended
            imgViewRecommended.loadImage(recommended.urlRecommended, progressBarRecommendedRestaurant)
        }
    }

    override fun getItemCount(): Int {
        return recommendedList.size
    }
}