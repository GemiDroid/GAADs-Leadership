package com.gemidroid.gaads.base

import io.reactivex.rxjava3.core.Scheduler

interface IExecutors {
    fun getMainThread(): Scheduler
    fun getIOThread(): Scheduler
}
