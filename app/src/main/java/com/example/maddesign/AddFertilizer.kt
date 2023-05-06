package com.example.maddesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.maddesign.model.FertilizerModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddFertilizer : AppCompatActivity() {

    private lateinit var editTextTextPersonName: EditText
    private lateinit var editTextNumber: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var buttonsave: Button

    private lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_fertilizer)

        editTextTextPersonName=findViewById(R.id.editTextTextPersonName)
        editTextNumber=findViewById(R.id.editTextNumber)
        editTextNumber2=findViewById(R.id.editTextNumber2)
       buttonsave=findViewById(R.id.button2)

        dbRef = FirebaseDatabase.getInstance().getReference("Fertilizer")

        buttonsave.setOnClickListener{
            saveFertilizer()
        }

    }

    private fun saveFertilizer(){
        //getting values
        val fertileName = editTextTextPersonName.text.toString()
        val fertileAmount =editTextNumber.text.toString()
        val fertilePrice= editTextNumber2.text.toString()

        if(fertileName.isEmpty()){
            editTextTextPersonName.error="Please Enter Fertilizer Name"
        }
        if(fertileAmount.isEmpty()){
            editTextNumber.error="Please Enter the Amount"
        }
        if(fertilePrice.isEmpty()){
            editTextNumber2.error="Please Enter the Price"
        }

        val fertileId=dbRef.push().key!!

        val fertile = FertilizerModel(fertileId,fertileName,fertileAmount,fertilePrice)

        dbRef.child(fertileId).setValue(fertile)
            .addOnCompleteListener{
                Toast.makeText(this,"Data Inserted Successfuly", Toast.LENGTH_LONG).show()

                editTextTextPersonName.text.clear()
                editTextNumber.text.clear()
                editTextNumber2.text.clear()

            }.addOnFailureListener{err->
                Toast.makeText(this,"Error ${err.message}", Toast.LENGTH_LONG).show()

            }
    }
}