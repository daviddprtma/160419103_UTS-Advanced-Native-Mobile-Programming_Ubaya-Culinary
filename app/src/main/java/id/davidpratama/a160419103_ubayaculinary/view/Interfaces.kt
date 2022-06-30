package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

interface TodoCheckedChangeListener {
    fun onCheckChanged(

    )
}

interface ButtonAddRestaurantClickListener{
    fun onAddRestaurantClickListener(v:View)
}
