package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.About
import id.davidpratama.a160419103_ubayaculinary.viewmodel.AboutViewModel
import id.davidpratama.a160419103_ubayaculinary.viewmodel.ProfileViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_about.*
import java.util.concurrent.TimeUnit

class AboutFragment : Fragment() {
    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AboutViewModel::class.java)
        viewModel.refreshAbout()

        btnSupport.setOnClickListener {
            val action = AboutFragmentDirections.actionItemAboutToSupportFragment()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
       viewModel.aboutLD.observe(viewLifecycleOwner){
           val aboutData = it
           aboutData?.let {
               txtAbout.text = it.about
           }

           var aboutNotif = it
           btnNotification.setOnClickListener {
               Observable.timer(5, TimeUnit.SECONDS)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe {
                       Log.d("Messages", "five seconds")
                       MainActivity.showNotification(aboutNotif.about.toString(),
                           "A new notification created",
                           R.drawable.ic_baseline_info_24)
                   }
           }
       }
    }
}