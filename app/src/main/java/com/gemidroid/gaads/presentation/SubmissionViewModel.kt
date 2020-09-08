package com.gemidroid.gaads.presentation

import androidx.lifecycle.ViewModel
import com.gemidroid.gaads.data.model.Submit
import com.gemidroid.gaads.domain.SubmissionUseCase

class SubmissionViewModel(private val submissionUseCase: SubmissionUseCase) : ViewModel() {

    fun submit(submit: Submit) = submissionUseCase.execute(submit)

    val submitProject = submissionUseCase.postProject
    val error = submissionUseCase.getError
    val status = submissionUseCase.getStatus

}