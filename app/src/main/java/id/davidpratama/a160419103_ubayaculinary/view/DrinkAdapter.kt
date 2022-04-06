package id.davidpratama.a160419103_ubayaculinary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.Drink
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import kotlinx.android.synthetic.main.list_drink.view.*

class DrinkAdapter(val drinkList:ArrayList<Drink>):RecyclerView.Adapter<DrinkAdapter.DrinkViewAdapter>() {
    class DrinkViewAdapter(var view: View):RecyclerView.ViewHolder(view)

    fun updateDrinkList(newDrinkList: List<Drink>){
        drinkList.clear()
        drinkList.addAll(newDrinkList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewAdapter {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.list_drink,parent,false)

        return DrinkViewAdapter(view)
    }

    override fun onBindViewHolder(holder: DrinkViewAdapter, position: Int) {
        val drink = drinkList[position]
        with(holder.view){
            txtNamaMinuman.text = drink.namaMinuman
            txtHargaMinuman.text = drink.hargaMinuman.toString()
            imgViewDrink.loadImage(drink.urlMinuman, progressBarListDrink)
        }
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }
}