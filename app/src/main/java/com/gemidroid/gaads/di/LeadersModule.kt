package com.gemidroid.gaads.di

import com.gemidroid.gaads.data.datasource.network.LeadersAPI
import com.gemidroid.gaads.data.repository.leader.LeaderRepository
import com.gemidroid.gaads.data.repository.leader.LeaderRepositoryImpl
import com.gemidroid.gaads.domain.GetLeadersUseCase
import com.gemidroid.gaads.presentation.GetLeaderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.ext.getScopeName
import retrofit2.Retrofit

val leadersModule = module {
    factory<LeaderRepository> {
        LeaderRepositoryImpl(
            get()
        )
    }
    factory { GetLeadersUseCase(get(), get(), get()) }
    viewModel { GetLeaderViewModel(get()) }
}
