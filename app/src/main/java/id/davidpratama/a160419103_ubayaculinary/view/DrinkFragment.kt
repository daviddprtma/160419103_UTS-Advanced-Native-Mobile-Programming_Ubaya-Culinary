package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.viewmodel.DrinkListViewModel
import id.davidpratama.a160419103_ubayaculinary.viewmodel.FoodListViewModel
import kotlinx.android.synthetic.main.fragment_drink.*
import kotlinx.android.synthetic.main.fragment_food.*

class DrinkFragment : Fragment() {

    private lateinit var viewModel: DrinkListViewModel
    private var drinkAdapter =DrinkAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DrinkListViewModel::class.java)
        viewModel.refreshDrink()

        recViewDrink.layoutManager = LinearLayoutManager(context)
        recViewDrink.adapter = drinkAdapter

        refreshLayoutDrink()

        drinkRefreshLayout.setOnRefreshListener {
            recViewDrink.visibility = View.GONE
            txtErrorLoadDrink.visibility = View.GONE
            progressBarLoadDrink.visibility = View.VISIBLE
            viewModel.refreshDrink()
            drinkRefreshLayout.isRefreshing = false
        }
    }

    private fun refreshLayoutDrink() {
        viewModel.drinkLD.observe(viewLifecycleOwner){
            drinkAdapter.updateDrinkList(it)
        }

        viewModel.loadingErrorDrinkLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorLoadDrink.visibility = View.VISIBLE
            } else {
                txtErrorLoadDrink.visibility = View.GONE
            }
        })

        viewModel.loadingSuccessDrinkLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBarLoadDrink.visibility = View.GONE
                recViewDrink.visibility = View.VISIBLE
            } else {
                progressBarLoadDrink.visibility = View.VISIBLE
                recViewDrink.visibility = View.GONE
            }
        })
    }
}