package com.example.maddesign.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maddesign.R
import com.example.maddesign.adapter.FertilizerAdapter
import com.example.maddesign.model.FertilizerModel
import com.google.firebase.database.*


class FetchingActivity : AppCompatActivity() {

    private lateinit var empRecycleView:RecyclerView
    private lateinit var tvLoadingData :TextView
    private lateinit var empList: ArrayList<FertilizerModel>
    private  lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)


        empRecycleView = findViewById(R.id.rvEmp)
        empRecycleView.layoutManager = LinearLayoutManager(this)
        empRecycleView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        empList = arrayListOf<FertilizerModel>()

        getEmployeeData()


    }
    private fun getEmployeeData(){
        empRecycleView.visibility = View.GONE
        tvLoadingData.visibility  = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Fertilizer")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val empData = empSnap.getValue(FertilizerModel::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = FertilizerAdapter(empList)
                    empRecycleView.adapter = mAdapter

                    mAdapter.setOnItemClickListner(object :FertilizerAdapter.onItemClickLisner{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FetchingActivity, FertilizerDetailsActivity::class.java)

                            //put extras
                            intent.putExtra("fertileId",empList[position].fertileId)
                            intent.putExtra("fertileName",empList[position].fertileName)
                            intent.putExtra("fertileAmount",empList[position].fertileAmount)
                            intent.putExtra("fertilePrice",empList[position].fertileprice)
                            startActivity(intent)

                        }

                    })

                    empRecycleView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}