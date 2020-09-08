package com.gemidroid.gaads.data.repository.submission

import io.reactivex.rxjava3.core.Completable

interface SubmissionRepository {
    fun submit(
        fName: String,
        lName: String,
        email: String,
        link: String
    ): Completable
}