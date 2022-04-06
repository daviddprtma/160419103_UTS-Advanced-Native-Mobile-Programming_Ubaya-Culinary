package id.davidpratama.a160419103_ubayaculinary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.davidpratama.a160419103_ubayaculinary.R
import id.davidpratama.a160419103_ubayaculinary.viewmodel.HomeListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel:HomeListViewModel
    private var homeAdapter =HomeAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(HomeListViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = homeAdapter

        refreshLayout()

        refreshHomeLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            txtErrorHome.visibility = View.GONE
            progressLoadHome.visibility = View.VISIBLE
            viewModel.refresh()
            refreshHomeLayout.isRefreshing = false
        }

    }

    fun refreshLayout() {
        viewModel.kulinerLD.observe(viewLifecycleOwner, Observer {
            homeAdapter.updaterestaurantList(it)
        })

        viewModel.kulinerLoadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtErrorHome.visibility = View.VISIBLE
            } else {
                txtErrorHome.visibility = View.GONE
            }
        })

        viewModel.kulinerloadingSuccessLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressLoadHome.visibility = View.GONE
                recView.visibility = View.VISIBLE
            } else {
                progressLoadHome.visibility = View.VISIBLE
                recView.visibility = View.GONE

            }
        })
    }
}