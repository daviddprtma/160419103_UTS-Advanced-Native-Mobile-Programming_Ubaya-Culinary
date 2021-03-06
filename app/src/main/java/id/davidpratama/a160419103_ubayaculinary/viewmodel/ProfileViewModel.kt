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
import id.davidpratama.a160419103_ubayaculinary.model.Profile

class ProfileViewModel(application:Application): AndroidViewModel(application) {

    val profileLD =MutableLiveData<Profile>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingSuccessLD = MutableLiveData<Boolean>()

    private val TAG = "tag"
    private var queue: RequestQueue? = null

    fun refresh(){
        loadingErrorLD.value = false
        loadingSuccessLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://daviddprtma.github.io/kulinerubaya/profile.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val result = Gson().fromJson(response, Profile::class.java)
                profileLD.value = result
                loadingSuccessLD.value = true

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorLD.value = true
                loadingSuccessLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}