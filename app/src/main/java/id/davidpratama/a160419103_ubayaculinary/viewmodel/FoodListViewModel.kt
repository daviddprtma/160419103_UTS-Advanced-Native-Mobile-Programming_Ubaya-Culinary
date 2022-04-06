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
import id.davidpratama.a160419103_ubayaculinary.model.Food

class FoodListViewModel(application: Application) : AndroidViewModel(application) {
    val foodLD = MutableLiveData<List<Food>>()
    val loadingErrorFoodLD = MutableLiveData<Boolean>()
    val loadingSuccessFoodLD = MutableLiveData<Boolean>()

    private val TAG = "tag"
    private var queue: RequestQueue? = null
    fun refreshFood(){
        loadingErrorFoodLD.value = false
        loadingSuccessFoodLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://daviddprtma.github.io/kulinerubaya/food.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val sType = object : TypeToken<List<Food>>() { }.type
                val result = Gson().fromJson<List<Food>>(response, sType)
                foodLD.value = result
                loadingSuccessFoodLD.value = true

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorFoodLD.value = true
                loadingSuccessFoodLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}