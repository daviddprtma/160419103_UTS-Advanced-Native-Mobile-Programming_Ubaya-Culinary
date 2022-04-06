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

class HomeListViewModel(application: Application):AndroidViewModel(application) {

    fun refresh(){
        kulinerLoadingErrorLD.value = false
        kulinerloadingSuccessLD.value = true

        queue =Volley.newRequestQueue(getApplication())
        val url = "https://daviddprtma.github.io/kulinerubaya/listrestaurant.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val sType = object : TypeToken<List<Restaurant>>() { }.type
                val result = Gson().fromJson<List<Restaurant>>(response, sType)
                kulinerLD.value = result
                kulinerloadingSuccessLD.value = true

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                kulinerLoadingErrorLD.value = true
                kulinerloadingSuccessLD.value = false
            })

        stringRequest.tag = tag
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(tag)
    }


    val kulinerLD =MutableLiveData<List<Restaurant>>()
    val kulinerLoadingErrorLD = MutableLiveData<Boolean>()
    val kulinerloadingSuccessLD = MutableLiveData<Boolean>()

    val tag = "volleyTag"
    private var queue: RequestQueue? =null
}