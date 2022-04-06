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
import id.davidpratama.a160419103_ubayaculinary.model.About
import id.davidpratama.a160419103_ubayaculinary.model.Support

class SupportListViewModel(application: Application) : AndroidViewModel(application) {
    val supportLD = MutableLiveData<Support>()
    val loadingErrorSupportLD = MutableLiveData<Boolean>()
    val loadingSuccessSupportLD = MutableLiveData<Boolean>()

    private val TAG = "tag"
    private var queue: RequestQueue? = null

    fun refreshSupport(){
        loadingErrorSupportLD.value = false
        loadingSuccessSupportLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://daviddprtma.github.io/kulinerubaya/support.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val result = Gson().fromJson(response, Support::class.java)
                supportLD.value = result
                loadingSuccessSupportLD.value = true

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorSupportLD.value = true
                loadingSuccessSupportLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}