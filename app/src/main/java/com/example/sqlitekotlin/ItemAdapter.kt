package com.example.sqlitekotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitekotlin.R.color.colorLightGray
import com.example.sqlitekotlin.R.color.colorWhite
import kotlinx.android.synthetic.main.item_row.view.*


class ItemAdapter (val context: Context, val items: ArrayList<EmpModelClass>):
        RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item = items.get(position)
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email
        holder.ivEdit.setOnClickListener {view ->
            if(context is MainActivity){
                context.updateRecordDialog(item)
            }

        }

        holder.ivDelete.setOnClickListener { view ->

            if (context is MainActivity) {
                context.deleteRecordAlertDialog(item)
            }
        }

        // updating color according to the odd/even positions in list.
        if (position % 2 == 0){
            holder.llMain.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    colorLightGray
                )
            )
        } else  {
            holder.llMain.setBackgroundColor(ContextCompat.getColor(context, colorWhite))
        }

    }

    override fun getItemCount(): Int {
         return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val llMain = view.llMain
        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val ivEdit = view.ivEdit
        val ivDelete = view.ivDelete


    }

}