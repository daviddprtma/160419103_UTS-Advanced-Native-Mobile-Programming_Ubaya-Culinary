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
import id.davidpratama.a160419103_ubayaculinary.model.RecommendedRestaurant

class RecommendedViewModel(application: Application):AndroidViewModel(application) {
    val recommendLD = MutableLiveData<List<RecommendedRestaurant>>()
    val recommendLoadingErrorLD = MutableLiveData<Boolean>()
    val recommendloadingSuccessLD = MutableLiveData<Boolean>()

    val tag = "volleyTag"
    private var queue: RequestQueue? =null
    fun refreshRecommend(){
        recommendLoadingErrorLD.value = false
        recommendloadingSuccessLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://daviddprtma.github.io/kulinerubaya/recommended.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val sType = object : TypeToken<List<RecommendedRestaurant>>() { }.type
                val result = Gson().fromJson<List<RecommendedRestaurant>>(response, sType)
                recommendLD.value = result
                recommendloadingSuccessLD.value = true

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
               recommendLoadingErrorLD.value = true
                recommendloadingSuccessLD.value = false
            })

        stringRequest.tag = tag
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(tag)
    }
}