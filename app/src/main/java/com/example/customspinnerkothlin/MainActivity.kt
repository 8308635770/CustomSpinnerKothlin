package com.example.customspinnerkothlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var spinner : Spinner
     var students =ArrayList<StudentInfo>()
    var countries=ArrayList<CountryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        students=getStudentInfo()
        countries=getCountyList()


        spinner=spinner_view;

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapter1=ArrayAdapter<StudentInfo>(this,android.R.layout.simple_spinner_item,students)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val adapter2=CountryAdapter(this,countries)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


//        spinner.adapter=adapter
//        spinner.adapter=adapter1
        spinner.adapter=adapter2
        spinner.onItemSelectedListener = this




    }

    companion object{
        val colors = arrayOf<String>("red","green","yellow","blue","orange","black","white","brown");
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

//        val selectedItem = parent?.getItemAtPosition(position).toString()
//        Toast.makeText(parent?.context,selectedItem,Toast.LENGTH_SHORT).show()

//        val student : StudentInfo= parent?.getItemAtPosition(position) as StudentInfo
//        val studentDetails : String=student.name+"\n"+student.middleName+"\n"+student.surname+"..."
//        Toast.makeText(parent?.context,studentDetails,Toast.LENGTH_SHORT).show()


        val country : CountryItem= parent?.getItemAtPosition(position) as CountryItem
        Toast.makeText(parent?.context,country.countryName,Toast.LENGTH_SHORT).show()
    }

    private fun getStudentInfo() : ArrayList<StudentInfo>{

        val students = ArrayList<StudentInfo>()

        students.add(StudentInfo(1,"Yash","Ramgopal","Tapade"))
        students.add(StudentInfo(2,"Shivam","Ramgopal","Tapade"))
        students.add(StudentInfo(3,"Rakhi","Ramgopal","Tapade"))
        students.add(StudentInfo(4,"Srt","Ramgopal","Tapade"))
        students.add(StudentInfo(5,"YashRaj","Ramgopal","Tapade"))

        return students
    }

    private fun getCountyList():ArrayList<CountryItem>{

        val countries=ArrayList<CountryItem>()

        countries.add(CountryItem(R.drawable.ic_flag_of_india,"India"))
        countries.add(CountryItem(R.drawable.ic_flag_of_argentina,"argentina"))
        countries.add(CountryItem(R.drawable.ic_flag_of_australia,"australia"))
        countries.add(CountryItem(R.drawable.ic_flag_of_denmark,"denmark"))
        countries.add(CountryItem(R.drawable.ic_flag_of_germany,"germany"))
        countries.add(CountryItem(R.drawable.ic_flag_of_brazil,"brazil"))
        return countries

    }
}
