package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.viewmodel.CreateRestaurantViewModel

class createRestaurantFragment : Fragment() {
    private lateinit var viewModel : CreateRestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(CreateRestaurantViewModel::class.java)
    }
}