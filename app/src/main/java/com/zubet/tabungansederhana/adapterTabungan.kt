package com.zubet.tabungansederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterTabungan(private val dataSet: MutableList<DataSaldo>):
        RecyclerView.Adapter<adapterTabungan.SaldoHolder>(){
    class SaldoHolder (view: View): RecyclerView.ViewHolder(view){
    val hasil = view.findViewById<TextView>(R.id.CVsaldo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterTabungan.SaldoHolder {
    val view = LayoutInflater.from(parent.context).inflate(
        R.layout.activity_adapter_tabungan,parent,false
    )
        return  SaldoHolder(view)
    }

    override fun onBindViewHolder(holder: adapterTabungan.SaldoHolder, position: Int) {
    val datta = dataSet[position]
        holder.hasil.text = dataSet[position].hasile
    }

    override fun getItemCount(): Int {
    return dataSet.size
    }

}