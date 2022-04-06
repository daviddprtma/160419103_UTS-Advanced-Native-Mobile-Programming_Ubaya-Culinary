package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.viewmodel.AboutViewModel
import id.davidpratama.a160419103_ubayaculinary.viewmodel.SupportListViewModel
import kotlinx.android.synthetic.main.fragment_support.*

class SupportFragment : Fragment() {
    private lateinit var viewModel: SupportListViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_support, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SupportListViewModel::class.java)
        viewModel.refreshSupport()

        observeViewModelSupport()
    }

    private fun observeViewModelSupport() {
        viewModel.supportLD.observe(viewLifecycleOwner){
            val supportData = it
            supportData?.let {
                txtPhone.text = it.phone
                txtEmail.text = it.email
            }
        }
    }
}