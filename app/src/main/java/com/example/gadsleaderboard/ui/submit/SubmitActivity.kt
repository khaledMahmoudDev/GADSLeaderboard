package com.example.gadsleaderboard.ui.submit

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.databinding.ActivitySubmitBinding

class SubmitActivity : AppCompatActivity() {

    private val viewModel: SubmitActivityViewModel by lazy {
        ViewModelProviders.of(this).get(SubmitActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivitySubmitBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_submit)
        binding.viewModel = viewModel

        setSupportActionBar(findViewById(R.id.submitToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar
        actionBar!!.title = ""
        viewModel.errorMessage.observe(this, Observer {
            var toastMessage: String = ""
            when (it) {
                SubmitStatus.FIRSTNAME_ERROR -> {
                    toastMessage = "please enter first name"
                }
                SubmitStatus.LASTNAME_ERROR -> {
                    toastMessage = "please enter first name"
                }
                SubmitStatus.LINK_ERROR -> {
                    toastMessage = "please enter Link "
                }
                SubmitStatus.EMAIL_ERROR -> {
                    toastMessage = "please enter Email"
                }
                SubmitStatus.UPLOAD_FAILED -> {

                    showDialog(Upload.Failed)
                }
                SubmitStatus.UPLOAD_SUCCESS -> {

                    showDialog(Upload.Success)
                }
            }

            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()

        })

    }

    fun showDialog(upload: Upload) {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        when (upload) {
            Upload.Failed -> {

                dialog.setContentView(R.layout.failure_layout)
            }
            Upload.Success -> {

                dialog.setContentView(R.layout.success_layout)
            }
        }
        dialog.show()
    }
}

enum class Upload {
    Failed,
    Success
}