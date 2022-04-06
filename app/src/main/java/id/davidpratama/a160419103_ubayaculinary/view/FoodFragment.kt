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
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import id.davidpratama.a160419103_ubayaculinary.viewmodel.FoodListViewModel
import id.davidpratama.a160419103_ubayaculinary.viewmodel.RestaurantDetailListViewModel
import kotlinx.android.synthetic.main.fragment_food.*
import kotlinx.android.synthetic.main.fragment_home.*

class FoodFragment : Fragment() {

    private lateinit var viewModel: FoodListViewModel
    private var foodAdapter =FoodAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FoodListViewModel::class.java)
        viewModel.refreshFood()

        recViewFood.layoutManager = LinearLayoutManager(context)
        recViewFood.adapter = foodAdapter

        refreshLayout()

        refreshFoodLayout.setOnRefreshListener {
            recViewFood.visibility = View.GONE
            txtErrorFood.visibility = View.GONE
            progressBarFragFood.visibility = View.VISIBLE
            viewModel.refreshFood()
            refreshFoodLayout.isRefreshing = false
        }
    }

    private fun refreshLayout() {
        viewModel.foodLD.observe(viewLifecycleOwner, Observer {
            foodAdapter.updatefoodList(it)
        })

        viewModel.loadingErrorFoodLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorFood.visibility = View.VISIBLE
            } else {
                txtErrorFood.visibility = View.GONE
            }
        })

        viewModel.loadingSuccessFoodLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBarFragFood.visibility = View.GONE
                recViewFood.visibility = View.VISIBLE
            } else {
                progressBarFragFood.visibility = View.VISIBLE
                recViewFood.visibility = View.GONE
            }
        })
    }

}