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
import id.davidpratama.a160419103_ubayaculinary.viewmodel.RecommendedViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_recommended.*

class RecommendedFragment : Fragment() {

    private lateinit var viewModel: RecommendedViewModel
    private var recommendAdapter = RecommendedAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommended, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecommendedViewModel::class.java)
        viewModel.refreshRecommend()

        recViewRecommended.layoutManager = LinearLayoutManager(context)
        recViewRecommended.adapter = recommendAdapter

        refreshLayoutRecommended()

        refreshRecommendedLayout.setOnRefreshListener {
            recViewRecommended.visibility = View.GONE
            txtViewErrorRecommended.visibility = View.GONE
            progressBarLoadRecommended.visibility = View.VISIBLE
            viewModel.refreshRecommend()
            refreshRecommendedLayout.isRefreshing = false
        }
    }

    private fun refreshLayoutRecommended() {
        viewModel.recommendLD.observe(viewLifecycleOwner){
            recommendAdapter.updaterecommendedList(it)
        }

        viewModel.recommendLoadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                txtViewErrorRecommended.visibility = View.VISIBLE
            } else {
                txtViewErrorRecommended.visibility = View.GONE
            }
        })

        viewModel.recommendloadingSuccessLD.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBarLoadRecommended.visibility = View.GONE
                recViewRecommended.visibility = View.VISIBLE
            } else {
                progressBarLoadRecommended.visibility = View.VISIBLE
                recViewRecommended.visibility = View.GONE
            }
        })
    }
}