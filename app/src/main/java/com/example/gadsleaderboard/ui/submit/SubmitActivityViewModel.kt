package com.example.gadsleaderboard.ui.submit

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.network.TopLearnersClient
import com.example.gadsleaderboard.utils.FORM_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivityViewModel(application: Application) : AndroidViewModel(application) {

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val link = MutableLiveData<String>()

    val errorMessage = MutableLiveData<SubmitStatus>()


    fun submitBtnClick(context: Context) {
        when {
            firstName.value.isNullOrEmpty() -> {
                errorMessage.value = SubmitStatus.FIRSTNAME_ERROR

            }
            lastName.value.isNullOrEmpty() -> {
                errorMessage.value = SubmitStatus.LASTNAME_ERROR
            }
            email.value.isNullOrEmpty() -> {
                errorMessage.value = SubmitStatus.EMAIL_ERROR
            }
            link.value.isNullOrEmpty() -> {
                errorMessage.value = SubmitStatus.LINK_ERROR
            }
            else -> {
                showDialog(context)
            }
        }
    }

    private fun showDialog(context: Context) {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)

        dialog.setContentView(R.layout.upload_make_sure)

        val closeBtn = dialog.findViewById<ImageView>(R.id.closeIcon)
        closeBtn.setOnClickListener {
            dialog.dismiss()
        }

        val yes = dialog.findViewById<Button>(R.id.yesButton)
        yes.setOnClickListener {
            sendRequest()
            dialog.dismiss()
        }
        dialog.show()

    }

    private fun sendRequest() {
        val call = TopLearnersClient.topLearnersService.submitProject(
            FORM_URL,
            firstName.value!!,
            lastName.value!!,
            email.value!!,
            link.value!!
        )
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    errorMessage.value = SubmitStatus.UPLOAD_SUCCESS
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                errorMessage.value = SubmitStatus.UPLOAD_FAILED
            }
        })
    }

}

enum class SubmitStatus {
    FIRSTNAME_ERROR,
    LASTNAME_ERROR,
    EMAIL_ERROR,
    LINK_ERROR,
    UPLOAD_FAILED,
    UPLOAD_SUCCESS
}