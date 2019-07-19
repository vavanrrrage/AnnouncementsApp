package com.example.announcements.presentation.base.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.example.announcements.data.providers.IResourcesProvider
import com.example.announcements.extensions.observeOnMain
import com.example.announcements.presentation.base.events.IEvent
import com.example.announcements.presentation.base.states.BaseState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import me.aartikov.alligator.Navigator
import org.koin.standalone.KoinComponent
import org.koin.standalone.get

abstract class BaseViewModel<State : BaseState> : ViewModel(),
    IBaseViewModel<State>,
    KoinComponent {
    private var firstInit = true
    val resourcesProvider: IResourcesProvider = get()
    val navigator: Navigator = get()
    final override val eventsSubject: BehaviorSubject<IEvent> = BehaviorSubject.create()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(
            eventsSubject
                .observeOnMain()
                .subscribe {
                    reduceEvent(it)
                }
        )
    }

    override fun setup(forceUse: Boolean) {
        if (forceUse || firstInit) {
            firstInit = false
            setupActions()
        }
    }

    /**
     * Действия по запуску работы (запуск setup() у interactor, изменение state и т.п.)
     */
    protected open fun setupActions() {
        //Empty
    }

    @CallSuper
    protected fun reduceEvent(event: IEvent) {
        onEventChanged(event)
    }

    protected open fun onEventChanged(event: IEvent) {
        // Empty.
    }

    override fun onCleared() {
        compositeDisposable.clear()

        super.onCleared()
    }
}