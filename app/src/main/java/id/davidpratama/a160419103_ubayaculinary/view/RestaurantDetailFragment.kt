package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.util.Global
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import id.davidpratama.a160419103_ubayaculinary.viewmodel.RestaurantDetailListViewModel
import kotlinx.android.synthetic.main.fragment_restaurant_detail.*

class RestaurantDetailFragment : Fragment() {
    private lateinit var viewModel: RestaurantDetailListViewModel
    private val detailReview = RestaurantDetailAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    var restaurantID = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestaurantDetailListViewModel::class.java)
        viewModel.fetchDetailRestaurant(restaurantID)

        Global.restaurantID = restaurantID

        observeViewModelDetailRestaurant()
    }

    private fun observeViewModelDetailRestaurant() {
        //viewModel.detailRestaurant.observe(viewLifecycleOwner, Observer {
            //val detailReviewRestaurant = viewModel.detailRestaurant.value
            //txtIDDetail.text = it.idRestaurant
            //txtNamaDetail.text = it.namaRestaurant
            //txtRatingDetail.text = it.ratingRestaurant
            //txtLokasiDetail.text = it.lokasiRestaurant
            //detailReviewRestaurant?.let {
                //detailReview.updateDetailReviewRestaurant(it.review)
            //}
            //imgPhotoDetailrestaurant.loadImage(it.urlRestaurant, progressBarDetailPhotoRestaurant)
        //})
    }
}