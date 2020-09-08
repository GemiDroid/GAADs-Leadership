package com.gemidroid.gaads.data.repository.submission

import com.gemidroid.gaads.data.datasource.network.SubmissionAPI
import io.reactivex.rxjava3.core.Completable

class SubmissionRepositoryImpl(private val submissionAPI: SubmissionAPI) :
    SubmissionRepository {
    override fun submit(fName: String, lName: String, email: String, link: String): Completable {
        return submissionAPI.submitProject(fName, lName, email, link)
    }
}