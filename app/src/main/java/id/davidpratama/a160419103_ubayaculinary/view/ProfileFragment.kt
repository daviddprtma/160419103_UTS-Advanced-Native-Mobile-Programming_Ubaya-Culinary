package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.model.Profile
import id.davidpratama.a160419103_ubayaculinary.util.loadImage
import id.davidpratama.a160419103_ubayaculinary.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.refresh()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.profileLD.observe(viewLifecycleOwner){
            val profilData = it
            profilData.let {
                txtIDPRofile.text = it.idProfile
                txtNamaProfile.text = it.namaProfile
                txtUsername.text = it.usernameProfile
                imgProfile.loadImage(it.url, progressBarProfile)
            }
        }
    }

}