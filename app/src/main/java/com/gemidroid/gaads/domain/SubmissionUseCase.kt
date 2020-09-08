package com.gemidroid.gaads.domain

import androidx.lifecycle.MutableLiveData
import com.gemidroid.gaads.base.IExecutors
import com.gemidroid.gaads.base.UseCase
import com.gemidroid.gaads.data.model.Submit
import com.gemidroid.gaads.data.repository.submission.SubmissionRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SubmissionUseCase(
    private val executors: IExecutors,
    private val submissionRepository: SubmissionRepository,
    private val compositeDisposable: CompositeDisposable
) : UseCase<Submit, Unit> {


    override fun execute(value: Submit) {
        compositeDisposable.add(
            submissionRepository.submit(
                value.fName,
                value.lName,
                value.email,
                value.link)
                .doFinally { getStatus.postValue(false) }
                .subscribeOn(executors.getIOThread())
                .subscribe({
                    postProject.postValue(true)
                }, {
                    getError.postValue(it)
                }))
    }

    override fun flushResources() {
        if (compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }

    val postProject = MutableLiveData<Boolean>()
    val getError = MutableLiveData<Throwable>()
    val getStatus = MutableLiveData<Boolean>()
}