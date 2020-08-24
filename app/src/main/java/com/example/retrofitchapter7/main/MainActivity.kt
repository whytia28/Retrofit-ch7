package com.example.retrofitchapter7.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitchapter7.*
import com.example.retrofitchapter7.addperson.AddPersonActivity
import com.example.retrofitchapter7.edit.EditActivity
import com.example.retrofitchapter7.pojo.GetPersonsResponse
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    MainPresenter.Listener {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        presenter.listener = this
        presenter.getPersonList()

        btn_fab.setOnClickListener {
            presenter.goToAddActivity()
        }
    }

    override fun onResume() {
        presenter.getPersonList()
        super.onResume()
    }

    private fun setUpRecyclerView(listPerson: List<GetPersonsResponse.Result>) {
        rv_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_main.adapter =
            PersonAdapter(listPerson, presenter)
    }

    override fun getPersonListSuccess(personList: MutableList<GetPersonsResponse.Result>) {
        setUpRecyclerView(personList)
    }

    override fun getPersonListFailure(errMessage: String) {
        Toast.makeText(this, "Error: $errMessage", Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressbar.visibility = View.GONE
    }

    override fun goToAddActivity() {
        val goToAddActivity = Intent(this, AddPersonActivity::class.java)
        startActivity(goToAddActivity)
    }

    override fun goToUpdateActivity(result: GetPersonsResponse.Result) {
        val goToUpdateActivity = Intent(this, EditActivity::class.java)
        goToUpdateActivity.putExtra("PERSON", result)
        startActivity(goToUpdateActivity)
    }

    override fun onPersonDeleteSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        presenter.getPersonList()
    }

    override fun onPersonDeleteFailed(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

}