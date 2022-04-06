package id.davidpratama.a160419103_ubayaculinary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.Food
import id.davidpratama.a160419103_ubayaculinary.model.Restaurant
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import kotlinx.android.synthetic.main.fragment_food.view.*
import kotlinx.android.synthetic.main.list_food.view.*
import kotlinx.android.synthetic.main.list_restaurant_item.view.*

class FoodAdapter(val foodList:ArrayList<Food>):RecyclerView.Adapter<FoodAdapter.FoodViewAdapter>() {
    class FoodViewAdapter(var view:View) :RecyclerView.ViewHolder(view)

    fun updatefoodList(newFoodList: List<Food>){
        foodList.clear()
        foodList.addAll(newFoodList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewAdapter {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.list_food,parent,false)

        return FoodViewAdapter(view)
    }

    override fun onBindViewHolder(holder: FoodViewAdapter, position: Int) {
        val food = foodList[position]
        with(holder.view){
            txtNamaResto.text = food.namaResto
            txtMakananResto.text =food.namaMakanan
            txtHarga.text = food.harga.toString()
            imgViewFood.loadImage(food.urlFood,progressBarFood)

            btnDrink.setOnClickListener {
                val action = food.namaResto?.let { id->
                    FoodFragmentDirections.actionItemFoodToItemDrink()
                }
                if(action!=null){
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

    override fun getItemCount(): Int {
       return foodList.size
    }
}