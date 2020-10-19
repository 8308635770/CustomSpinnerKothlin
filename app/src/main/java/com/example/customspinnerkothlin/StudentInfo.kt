package com.example.customspinnerkothlin

data class StudentInfo(var rollNumber : Int,var name:String,var middleName:String,var surname:String) {

    override fun toString(): String {
        return name;
    }
}