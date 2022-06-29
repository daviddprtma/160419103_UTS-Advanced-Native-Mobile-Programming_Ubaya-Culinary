package id.davidpratama.a160419103_ubayaculinary.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.davidpratama.a160419103_ubayaculinary.model.Restaurant
import id.davidpratama.a160419103_ubayaculinary.model.RestaurantDatabase
import id.davidpratama.a160419103_ubayaculinary.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeListViewModel(application: Application):AndroidViewModel(application),CoroutineScope {
    val restaurantLD = MutableLiveData<List<Restaurant>>()
    val restaurantLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = true
        restaurantLoadErrorLD.value = false
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                RestaurantDatabase::class.java, "restaurantdb").build()

            restaurantLD.value = db.restaurantDao().selectAllRestaurant()
        }
    }
}
//
//    fun refresh(){
//        kulinerLoadingErrorLD.value = false
//        kulinerloadingSuccessLD.value = true
//
//        queue =Volley.newRequestQueue(getApplication())
//        val url = "https://daviddprtma.github.io/kulinerubaya/listrestaurant.json"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                    response ->
//                val sType = object : TypeToken<List<Restaurant>>() { }.type
//                val result = Gson().fromJson<List<Restaurant>>(response, sType)
//                kulinerLD.value = result
//                kulinerloadingSuccessLD.value = true
//
//                Log.d("showvoley", result.toString())
//            },
//            {
//                Log.d("showvoley", it.toString())
//                kulinerLoadingErrorLD.value = true
//                kulinerloadingSuccessLD.value = false
//            })
//
//        stringRequest.tag = tag
//        queue?.add(stringRequest)
//
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        queue?.cancelAll(tag)
//    }
//
//
//    val kulinerLD =MutableLiveData<List<Restaurant>>()
//    val kulinerLoadingErrorLD = MutableLiveData<Boolean>()
//    val kulinerloadingSuccessLD = MutableLiveData<Boolean>()
//
//    val tag = "volleyTag"
//    private var queue: RequestQueue? =null
//}