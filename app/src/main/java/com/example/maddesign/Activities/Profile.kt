package com.example.maddesign.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.maddesign.R
import com.example.maddesign.model.SellerModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Profile : AppCompatActivity() {

    private lateinit var sellername: EditText
    private lateinit var selleremail: EditText
    private lateinit var sellerlocation: EditText
    private lateinit var sellermobile: EditText
    private lateinit var button00: Button

    private lateinit var dbRef: DatabaseReference


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sellername=findViewById(R.id.sellername)
        selleremail=findViewById(R.id.selleremail)
        sellerlocation=findViewById(R.id.sellerlocation)
        sellermobile=findViewById(R.id.sellermobile)
        button00=findViewById(R.id.button00)


        dbRef = FirebaseDatabase.getInstance().getReference("Seller_Details")

        button00.setOnClickListener{
            saveDetails()
        }

    }

    private fun saveDetails(){
    //getting values
    val sellerName = sellername.text.toString().trim()
    val sellerEmail =selleremail.text.toString().trim()
    val sellerLocation= sellerlocation.text.toString().trim()
    val sellerMobile= sellermobile.text.toString().trim()

    if(sellerName.isEmpty()){
        sellername.error="Please Enter User Name"
        return@saveDetails
    }
//    if(sellerEmail.isEmpty()){
//        selleremail.error="Please Enter the Amount"
//    }
        if(!Patterns.EMAIL_ADDRESS.matcher(sellerEmail).matches()){
            selleremail.error="Please Enter Valid Email Address"
            return@saveDetails
        }

    if(sellerLocation.isEmpty()){
        sellerlocation.error="Please Enter the Price"
        return@saveDetails

    }

//        if(sellerMobile.isEmpty()){
//            sellermobile.error="Please Enter the Price"
//            return@saveDetails
//        }

        val mobilePattern = "^[+]?[0-9]{10,13}\$"
        if(!sellerMobile.matches(mobilePattern.toRegex())){
            sellermobile.error="Please Enter Valid Mobile Number"
            return
        }

    val SellerId=dbRef.push().key!!

    val seller = SellerModel(SellerId,sellerName,sellerEmail,sellerLocation,sellerMobile)

    dbRef.child(SellerId).setValue(seller)

    .addOnCompleteListener{
        Toast.makeText(this,"Data Inserted Successfuly", Toast.LENGTH_LONG).show()


    }.addOnFailureListener{err->
        Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()

    }
}

}