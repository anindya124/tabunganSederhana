package com.zubet.tabungansederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var bilgn1 : EditText
    private lateinit var bilgn2 : EditText
    private lateinit var TV1 : TextView
    private lateinit var TV2 : TextView
    private lateinit var TV3 : TextView
    private lateinit var TV4 : TextView
    private lateinit var TV5 : TextView
    private lateinit var AngkaHasil : TextView
    private lateinit var btncetak : Button
    private lateinit var rbtambah : RadioButton
    private lateinit var rbtarik : RadioButton
    private lateinit var btnproses : Button
    private lateinit var recyclerview : RecyclerView
    private lateinit var recycleradapter : RecyclerView.Adapter<*>
    private lateinit var viewmanager : RecyclerView.LayoutManager

    private var hasil : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bilgn1 = findViewById(R.id.bil1)
        bilgn2 = findViewById(R.id.bil2)
        TV1 = findViewById(R.id.tv1)
        TV2 = findViewById(R.id.tv2)
        TV3 = findViewById(R.id.tv3)
        TV4 = findViewById(R.id.tv4)
        TV5 = findViewById(R.id.tv5)
        AngkaHasil = findViewById(R.id.angkahasil)
        btncetak = findViewById(R.id.BTNcetak)
        rbtambah = findViewById(R.id.RBtambah)
        rbtarik = findViewById(R.id.RBtarik)
        btnproses = findViewById(R.id.BTNproses)
        recyclerview = findViewById(R.id.listdata)

        val data = mutableListOf<DataSaldo>()
        viewmanager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        recycleradapter = adapterTabungan(data)
        recyclerview.adapter = recycleradapter
        recyclerview.layoutManager = viewmanager

        btnproses.setOnClickListener{
        val bilangan1 = bilgn1.text.toString().toInt()
        val bilangan2 = bilgn2.text.toString().toInt()



            if (rbtambah.isChecked){
                hasil =  (bilangan1 + bilangan2)
                AngkaHasil.setText(hasil.toString())
            }else{
                hasil =  (bilangan1 - bilangan2)
                AngkaHasil.setText(hasil.toString())
            }
        }

        btncetak.setOnClickListener{

            val hasill = AngkaHasil.text.toString()

            val datacalcu = DataSaldo( hasill)
            data.add(datacalcu)
            recycleradapter.notifyDataSetChanged()

        }

    }


}