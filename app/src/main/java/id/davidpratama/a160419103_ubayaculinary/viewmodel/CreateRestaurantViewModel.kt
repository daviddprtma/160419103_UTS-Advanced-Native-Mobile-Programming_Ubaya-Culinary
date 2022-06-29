package id.davidpratama.a160419103_ubayaculinary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import id.davidpratama.a160419103_ubayaculinary.model.Restaurant
import id.davidpratama.a160419103_ubayaculinary.model.RestaurantDatabase
import id.davidpratama.a160419103_ubayaculinary.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CreateRestaurantViewModel(application:Application):AndroidViewModel(application),CoroutineScope {
    private val job = Job()

    fun addRestaurant(restaurant: List<Restaurant>) {
        launch {
            val db = buildDb(getApplication())
            db.restaurantDao().insertAllRestaurant(*restaurant.toTypedArray())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}