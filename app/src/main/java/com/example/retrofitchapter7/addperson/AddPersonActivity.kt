package com.example.retrofitchapter7.addperson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitchapter7.R
import kotlinx.android.synthetic.main.activity_add_person.*
import kotlinx.android.synthetic.main.activity_add_person.et_firstName
import kotlinx.android.synthetic.main.activity_add_person.et_lastName
import kotlinx.android.synthetic.main.activity_edit.*

class AddPersonActivity : AppCompatActivity(),
    AddPersonPresenter.Listener {
    private lateinit var presenter: AddPersonPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
        presenter =
            AddPersonPresenter(this)

        btn_add.setOnClickListener {
            presenter.addPerson(et_firstName.text.toString(), et_lastName.text.toString())
        }

    }

    override fun onAddPersonSuccess(successMessage: String) {
        Toast.makeText(this, successMessage, Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onAddPersonFailure(failureMessage: String) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show()
    }
}