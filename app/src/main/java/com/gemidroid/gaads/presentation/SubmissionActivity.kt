package com.gemidroid.gaads.presentation;


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gemidroid.gaads.R
import com.gemidroid.gaads.data.model.Submit
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_submission.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.UnknownHostException

class SubmissionActivity : AppCompatActivity() {

    private val submissionViewModel by viewModel<SubmissionViewModel>()

    private var confirmationAlertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)

        btn_submit.setOnClickListener {
            if (!isUIValid()) return@setOnClickListener
            showConfirmationAlertDialog()
        }

        backImageButton.setOnClickListener {
            finish()
        }

        submissionViewModel.submitProject.observe(this, Observer {
            if (it) {
                showSuccessAlertDialog()
            }
        })

        submissionViewModel.error.observe(this, Observer {
            if (it is UnknownHostException)
                Snackbar.make(btn_submit, getString(R.string.no_internet), Snackbar.LENGTH_SHORT)
                    .show()
            else
                showErrorAlertDialog()
        })
    }

    private fun isUIValid(): Boolean {
        return when {
            edt_fName.text.isEmpty() -> {
                edt_fName.error = "Enter your First Name"
                false
            }
            edt_lName.text.isEmpty() -> {
                edt_lName.error = "Enter your Last Name"
                false
            }
            edt_email.text.isEmpty() -> {
                edt_email.error = "Enter your Email Address"
                false
            }
            edt_link.text.isEmpty() -> {
                edt_link.error = "Enter your Project Link"
                false
            }
            else -> true
        }
    }

    private fun submit(submit: Submit) {
        submissionViewModel.submit(submit = submit)
    }

    private fun showConfirmationAlertDialog() {

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.confirmation_dialog, null)
        dialogBuilder.setView(dialogView)

        val closeButton: ImageButton = dialogView.findViewById(R.id.closeImageButton) as ImageButton

        val yesButton: Button = dialogView.findViewById(R.id.yesButton) as Button

        confirmationAlertDialog = dialogBuilder.create()
        confirmationAlertDialog?.setCanceledOnTouchOutside(false)
        confirmationAlertDialog?.show()

        closeButton.setOnClickListener {
            confirmationAlertDialog?.dismiss()
        }

        yesButton.setOnClickListener {
            submit(
                Submit(
                    edt_fName.text.toString(),
                    edt_lName.text.toString(),
                    edt_email.text.toString(),
                    edt_link.text.toString()
                )
            )
            confirmationAlertDialog?.dismiss()
        }
    }

    private fun showErrorAlertDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.failure_dialog, null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
        }, 2000)
    }

    private fun showSuccessAlertDialog() {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialogView: View = layoutInflater.inflate(R.layout.success_dialog, null)
        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            finish()
        }, 2000)
    }

}
