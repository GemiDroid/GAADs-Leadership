package com.gemidroid.gaads.domain

import androidx.lifecycle.MutableLiveData
import com.gemidroid.gaads.base.IExecutors
import com.gemidroid.gaads.base.UseCase
import com.gemidroid.gaads.data.model.leader.Learning
import com.gemidroid.gaads.data.model.leader.SkillIQ
import com.gemidroid.gaads.data.repository.leader.LeaderRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class GetLeadersUseCase(
    private val executors: IExecutors,
    private val repository: LeaderRepository,
    private val compositeDisposable: CompositeDisposable
) : UseCase<Any?, Unit> {


    override fun execute(value: Any?) {
        compositeDisposable.add(
            repository.getLearningLeaders()
                .doFinally { getStatus.postValue(false) }
                .subscribeOn(executors.getIOThread())
                .subscribe({
                    getLearningLeaders.postValue(it)
                }, {
                    getError.postValue(it)
                }))

        compositeDisposable.add(
            repository.getSkillIQLeaders()
                .doFinally { getStatus.postValue(false) }
                .subscribeOn(executors.getIOThread())
                .subscribe({
                    getSkillIQLeaders.postValue(it)
                }, {
                    getError.postValue(it)
                }))
    }

    override fun flushResources() {
        if (compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }

    val getLearningLeaders = MutableLiveData<List<Learning>>()
    val getSkillIQLeaders = MutableLiveData<List<SkillIQ>>()
    val getError = MutableLiveData<Throwable>()
    val getStatus = MutableLiveData<Boolean>()
}