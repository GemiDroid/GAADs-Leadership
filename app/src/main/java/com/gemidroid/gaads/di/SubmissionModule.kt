package com.gemidroid.gaads.di

import com.gemidroid.gaads.data.datasource.network.SubmissionAPI
import com.gemidroid.gaads.data.repository.submission.SubmissionRepository
import com.gemidroid.gaads.data.repository.submission.SubmissionRepositoryImpl
import com.gemidroid.gaads.domain.SubmissionUseCase
import com.gemidroid.gaads.presentation.SubmissionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val submissionModule = module {
    factory<SubmissionRepository> { SubmissionRepositoryImpl(get()) }
    factory { SubmissionUseCase(get(), get(), get()) }
    viewModel { SubmissionViewModel(get()) }
}
