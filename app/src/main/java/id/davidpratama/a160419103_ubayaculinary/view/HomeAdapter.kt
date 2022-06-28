package id.davidpratama.a160419103_ubayaculinary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.Restaurant
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import kotlinx.android.synthetic.main.list_restaurant_item.view.*

class HomeAdapter(val restaurantList: ArrayList<Restaurant>) :RecyclerView.Adapter<HomeAdapter.HomeViewAdapter>() {
    class HomeViewAdapter(var view:View) :RecyclerView.ViewHolder(view)

    fun updaterestaurantList(newRestaurantList: List<Restaurant>){
        restaurantList.clear()
        restaurantList.addAll(newRestaurantList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewAdapter {
        val inflater =LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.list_restaurant_item,parent,false)

        return HomeViewAdapter(view)
    }

    override fun onBindViewHolder(holder: HomeViewAdapter, position: Int) {
        val restoran = restaurantList[position]

        with(holder.view){
//            txtIDKuliner.text =restoran.idRestaurant
            txtNamarestaurant.text = restoran.namaRestaurant
            txtRating.text = restoran.ratingRestaurant
            txtLokasi.text = restoran.lokasiRestaurant
            txtKategori.text = restoran.kategoriRestaurant

            btnDetailRestaurant.setOnClickListener {
                val action = restoran.idRestaurant?.let{id->
                    HomeFragmentDirections.actionHomeFragmentToRestaurantDetailFragment(id.toString())
                }
                if(action!=null){
                    Navigation.findNavController(it).navigate(action)
                }
            }

            imgKuliner.loadImage(restoran.urlRestaurant, progressBarLoad)
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }
}