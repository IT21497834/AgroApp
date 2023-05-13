package com.example.maddesign


object Validator  {
    fun validateInput ( fertileName:String, fertileAmount:String, fertilePrice:String): Boolean {

        return !( fertileName.isEmpty() || fertileAmount.isEmpty())
    }

//    fun validateInput1 ( name:String, cropName:String, location:String, amount:Int): Boolean {
//
//        return !( cropName.isEmpty() || location.isEmpty())
//    }
}