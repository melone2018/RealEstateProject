package com.example.sravanreddy.realestateproject.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sravanreddy.realestateproject.R
import com.example.sravanreddy.realestateproject.view.fragment.BoundaryFragment.BoundaryContract
import com.example.sravanreddy.realestateproject.view.fragment.BoundaryFragment.BoundaryFragment
import com.example.sravanreddy.realestateproject.view.fragment.BoundaryFragment.BoundaryPresenter
import com.example.sravanreddy.realestateproject.view.fragment.PropertyListFragment.PropertyListFragment
import kotlinx.android.synthetic.main.activity_seller.*

class SellerActivity : AppCompatActivity() {
    private lateinit var boundaryPresenter:BoundaryContract.IPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seller)
        var cityName:String?=null

        button_search_seller.setOnClickListener{
            // Data base search for properties in city name is needed here
            if(et_searchbar_seller.text.isNotEmpty()){
                cityName = et_searchbar_seller.text.toString()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.fragmentSellerContainer, PropertyListFragment()).commit()
        tv_mapView_seller.setOnClickListener{
            var boundaryFragment = BoundaryFragment()
            var b=Bundle()
            b.putString("CITYNAME", cityName)
            boundaryFragment.arguments = b
            boundaryPresenter = BoundaryPresenter(boundaryFragment, this)
            supportFragmentManager.beginTransaction().replace(R.id.
                    fragmentSellerContainer, boundaryFragment).commit()
        }

    }
}
