package id.davidpratama.a160419103_ubayaculinary.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.davidpratama.a160419103_ubayaculinary.model.Restaurant

class RestaurantDetailListViewModel(application:Application):AndroidViewModel(application) {
    val detailRestaurant = MutableLiveData<Restaurant>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun fetchDetailRestaurant(idRestaurant:String){
        queue = Volley.newRequestQueue(getApplication())

        var url = "https://daviddprtma.github.io/kulinerubaya/listrestaurant.json"

        val stringReq = StringRequest(
            Request.Method.GET,url,{
                response ->
                val sType = object:TypeToken<ArrayList<Restaurant>>() {}.type
               val result = Gson().fromJson<ArrayList<Restaurant>>(response,sType)

                for(detail in result) {
                    if(detail.idRestaurant == idRestaurant){
                        detailRestaurant.value = detail
                    }
                }

                Log.d("showvolley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            }
        ).apply {
            tag = "TAG"
        }

        queue?.add(stringReq)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}