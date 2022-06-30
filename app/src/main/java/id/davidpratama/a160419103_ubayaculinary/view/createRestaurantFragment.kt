package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.lifecycle.ViewModelProvider
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.viewmodel.CreateRestaurantViewModel
import kotlinx.android.synthetic.main.fragment_create_restaurant.*
import java.util.Observer

class createRestaurantFragment : Fragment() {
    private lateinit var viewModel : CreateRestaurantViewModel
    private lateinit var dataBinding : createRestaurantFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //dataBinding = createRestaurantFragment.inflate<createRestaurantFragment>(inflater, R.layout.fragment_create_restaurant, container, false)
        //return dataBinding.root
    return inflater.inflate(R.layout.fragment_create_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateRestaurantViewModel::class.java)
    }

    fun observeViewModel()
    {
        //viewModel.restaurantLD.observe(viewLifecycleOwner, Observer {
            //dataBinding.todo = it
        //}
    }

}