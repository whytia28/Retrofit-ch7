package com.example.retrofitchapter7.edit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitchapter7.R
import com.example.retrofitchapter7.pojo.GetPersonsResponse
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity(), EditPersonPresenter.Listener {

    private lateinit var presenter: EditPersonPresenter
    private lateinit var result: GetPersonsResponse.Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        intent.getParcelableExtra<GetPersonsResponse.Result>("PERSON")?.let {
            result = it
        }

        presenter = EditPersonPresenter(this)

        et_firstName.setText(result.firstName)
        et_lastName.setText(result.lastName)

        btn_update.setOnClickListener {
            result.apply {
                firstName = et_firstName.text.toString()
                lastName = et_lastName.text.toString()
            }
            presenter.updatePerson(result)
        }
    }

    override fun onUpdatePersonSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onUpdatePersonFailed(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}