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
import id.davidpratama.a160419103_ubayaculinary.model.Drink
import id.davidpratama.a160419103_ubayaculinary.model.Food

class DrinkListViewModel(application: Application):AndroidViewModel(application) {
    val drinkLD = MutableLiveData<List<Drink>>()
    val loadingErrorDrinkLD = MutableLiveData<Boolean>()
    val loadingSuccessDrinkLD = MutableLiveData<Boolean>()

    private val TAG = "tag"
    private var queue: RequestQueue? = null

    fun refreshDrink(){
        loadingErrorDrinkLD.value = false
        loadingSuccessDrinkLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://daviddprtma.github.io/kulinerubaya/drink.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val sType = object : TypeToken<List<Drink>>() { }.type
                val result = Gson().fromJson<List<Drink>>(response, sType)
                drinkLD.value = result
                loadingSuccessDrinkLD.value = true

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorDrinkLD.value = true
                loadingSuccessDrinkLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}