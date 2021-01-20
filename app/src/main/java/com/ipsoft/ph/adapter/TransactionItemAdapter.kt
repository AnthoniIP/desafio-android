package com.ipsoft.ph.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ipsoft.ph.R
import com.ipsoft.ph.databinding.TransactionItemBinding
import com.ipsoft.ph.repository.model.Transaction

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Ph
 *  Date:       18/01/2021
 */

class TransactionItemAdapter(transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionItemAdapter.ViewHolder>() {

    private lateinit var transactionBinding: TransactionItemBinding

    private var transactionList: List<Transaction> = transactions


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val isPix = transactionList[position].tType == "PIXCASHIN"

        holder.pixTag.visibility =
            if (isPix) View.VISIBLE else View.INVISIBLE
        holder.root.setBackgroundColor(if (isPix) Color.LTGRAY else Color.WHITE)
        holder.transactionDate.text = transactionList[position].createdAd
        holder.transactionDescription.text = transactionList[position].description
        holder.transactionSender.text = transactionList[position].sender
        holder.transactionValue.text = transactionList[position].amount.toString()
    }

    override fun getItemCount() = transactionList.count()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val root: View = transactionBinding.transactionCard
        val pixTag: TextView = transactionBinding.txtPixTag
        val transactionDescription: TextView = transactionBinding.txtTransactionDescription
        val transactionSender: TextView = transactionBinding.txtTransactionSender
        val transactionValue: TextView = transactionBinding.txtTransactionValue
        val transactionDate: TextView = transactionBinding.txtTransactionDate


    }
}

