package com.example.travelappdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_countries.*

class CountriesFragment : Fragment(), OnItemClickListener {

    private val adapter = RecyclerAdapter(CountriesDataSource.createCountriesList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        countries_rc.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = this@CountriesFragment.adapter
        }
        adapter.setOnItemClickListener(this)
    }

    override fun onIteClick(country: Country, position: Int) {
        findNavController().navigate(R.id.action_countriesFragment_to_countryDetailsFragment)
    }
}