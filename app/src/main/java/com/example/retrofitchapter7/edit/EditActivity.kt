package com.example.retrofitchapter7.edit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitchapter7.R
import com.example.retrofitchapter7.pojo.GetPersonsResponse
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_edit.*
import javax.inject.Inject

class EditActivity : AppCompatActivity(), EditPersonPresenter.Listener {

    @Inject
    lateinit var presenter: EditPersonPresenter
    private lateinit var result: GetPersonsResponse.Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        AndroidInjection.inject(this)
        presenter.listener = this

        intent.getParcelableExtra<GetPersonsResponse.Result>("PERSON")?.let {
            result = it
        }

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