package com.skripsi155410177.wayangapp.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_wayang.view.*
import com.skripsi155410177.wayangapp.R
import com.skripsi155410177.wayangapp.TokohDetailActivity
import com.skripsi155410177.wayangapp.model.Tokoh

class TokohAdapter(val wayang : List<Tokoh>) : RecyclerView.Adapter<TokohAdapter.TokohViewHolder>() {
  override fun onBindViewHolder(holder: TokohViewHolder, position: Int) {
    holder?.bindData(wayang.get(position))
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TokohViewHolder {
    val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_wayang, parent, false)
    return TokohViewHolder(view)
  }

  override fun getItemCount(): Int {
    return wayang.size
  }

  class TokohViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val view : View = itemView
    var tokoh : Tokoh? = null
    override fun onClick(p0: View) {
      val intent = Intent(view.context, TokohDetailActivity::class.java)
      intent.putExtra("id",tokoh?.id)
      view.context.startActivity(intent)
      Toast.makeText(view.context, "${tokoh?.nama}", Toast.LENGTH_SHORT).show()
    }

    init {
      itemView.setOnClickListener(this)
    }

    fun bindData(tokoh: Tokoh) {
      this.tokoh = tokoh
      val imgBasePath = view.resources.getString(R.string.img_path)
      var imgPath = StringBuilder()
      imgPath.append(imgBasePath).append(tokoh.foto)
      Glide.with(view.context).load(imgPath.toString()).into(view.img_wy)
      view.t_nama.setText(tokoh.nama)
    }
  }
}