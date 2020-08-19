package com.example.retrofitchapter7.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitchapter7.pojo.GetPersonsResponse
import com.example.retrofitchapter7.R
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter(
    private val listPerson: List<GetPersonsResponse.Result>,
    private val presenter: MainPresenter
) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listPerson.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_id.text = listPerson[position].iD.toString()
        holder.itemView.tv_createAt.text = listPerson[position].createdAt
        holder.itemView.tv_update.text = listPerson[position].updatedAt
        holder.itemView.tv_delete.text = listPerson[position].deletedAt
        holder.itemView.tv_firstName.text = listPerson[position].firstName
        holder.itemView.tv_lastName.text = listPerson[position].lastName
        holder.itemView.setOnClickListener {
            presenter.goToUpdateActivity(listPerson[position])
        }
        holder.itemView.btn_delete.setOnClickListener {
            presenter.deletePerson(listPerson[position])
        }
    }
}