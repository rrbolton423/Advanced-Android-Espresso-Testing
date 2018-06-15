package com.sqisland.android.espresso.cat_names

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class IdeasAdapter(private val ideas: Array<String>, private val listener: OnItemClickListener) : RecyclerView.Adapter<TextViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.idea, parent, false)
    return TextViewHolder(view)
  }

  override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
    val label = ideas[position]
    holder.textView.text = label
    holder.textView.setOnClickListener { listener.onItemClick(position) }
  }

  override fun getItemCount(): Int {
    return ideas.size
  }

  interface OnItemClickListener {
    fun onItemClick(position: Int)
  }
}