package com.example.customspinnerkothlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.country_spinner_item.view.*

class CountryAdapter(context: Context, var countries:ArrayList<CountryItem>) :
    ArrayAdapter<CountryItem>(context, 0,countries) {

    val countryList=ArrayList<CountryItem>(countries);

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCountriesView(position,convertView,parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCountriesView(position,convertView,parent)
    }

    private fun getCountriesView( position: Int,convertView: View?,parent: ViewGroup):View{

       val convertView1=LayoutInflater.from(parent.context).inflate(R.layout.country_spinner_item,parent,false)

        val country = getItem(position) as CountryItem

        convertView1.image_view_flag.setImageResource(country.imageResource)
        convertView1.text_view_name.setText(country.countryName)

        return convertView1

    }

}