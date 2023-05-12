package com.example.maddesign

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.maddesign.model.FertilizerModel
import com.google.firebase.database.FirebaseDatabase


class FertilizerDetailsActivity : AppCompatActivity() {

    private lateinit var tvFertileID: TextView
    private lateinit var tvFertileName: TextView
    private lateinit var tvFertileAmount: TextView
    private lateinit var tvFertilePrice: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fertilizer_details)

        initView()
        setValuesToViews()

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("fertileId").toString(),
                intent.getStringExtra("fertileName").toString()
            )
        }

        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("fertileId").toString()
            )
        }

    }

    private fun initView() {
        tvFertileID= findViewById(R.id.tvFertileID)
        tvFertileName = findViewById(R.id.tvFertileName)
        tvFertileAmount = findViewById(R.id.tvFertileAmount)
        tvFertilePrice = findViewById(R.id.tvFertilePrice)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setValuesToViews() {
        tvFertileID.text = intent.getStringExtra("fertileId")
        tvFertileName.text = intent.getStringExtra("fertileName")
        tvFertileAmount.text = intent.getStringExtra("fertileAmount")
        tvFertilePrice.text = intent.getStringExtra("fertilePrice")

    }

    private fun deleteRecord(
        id: String
    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("Fertilizer").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this, "Fertilizer data deleted", Toast.LENGTH_LONG).show()

            val intent = Intent(this, FetchingActivity::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{ error ->
            Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun openUpdateDialog(
        FertileId: String,
        FertiName: String
    ) {
        val mDialog = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val mDialogView = inflater.inflate(R.layout.update_dialog, null)

        mDialog.setView(mDialogView)

        val etFertiName = mDialogView.findViewById<EditText>(R.id.editTextTextPersonName)
        val etFertiAmount = mDialogView.findViewById<EditText>(R.id.editTextNumber)
        val etFertiPrice = mDialogView.findViewById<EditText>(R.id.editTextNumber2)

        val btnUpdateData = mDialogView.findViewById<Button>(R.id.button2)

        etFertiName.setText(intent.getStringExtra("fertileName").toString())
        etFertiAmount.setText(intent.getStringExtra("fertileAmount").toString())
        etFertiPrice.setText(intent.getStringExtra("fertilePrice").toString())


        mDialog.setTitle("Updating $FertiName Record")

        val alertDialog = mDialog.create()
        alertDialog.show()

        btnUpdateData.setOnClickListener {
            updateEmpData(
                FertileId,
                etFertiName.text.toString(),
                etFertiAmount.text.toString(),
                etFertiPrice.text.toString()
            )

            Toast.makeText(applicationContext, "Fertilizer Data Updated", Toast.LENGTH_LONG).show()

            //we are setting updated data to our textviews
            tvFertileName.text = etFertiName.text.toString()
            tvFertileAmount.text = etFertiAmount.text.toString()
            tvFertilePrice.text = etFertiPrice.text.toString()

            alertDialog.dismiss()
        }
    }

    private fun updateEmpData(
        id: String,
        name: String,
        amount: String,
        price: String
    ) {
        val dbRef = FirebaseDatabase.getInstance().getReference("Fertilizer").child(id)
        val empInfo = FertilizerModel(id, name, amount, price)
        dbRef.setValue(empInfo)
    }

}

