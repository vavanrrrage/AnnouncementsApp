package com.example.announcements.presentation.base.viewmodel

import com.example.announcements.presentation.base.events.IEvent
import com.example.announcements.presentation.base.states.IState
import io.reactivex.subjects.BehaviorSubject

interface IBaseViewModel<State : IState> {

    val eventsSubject: BehaviorSubject<IEvent>
    val state: State
    /**
     * Действия не должны выполняться в Init
     * Метод запускает действия по обработке, после инициализации
     * вызов методов setup interactor'a в блоке init VM может привести к тому, что ответы
     * интерактора приходят в еще не сформированый до конца ViewModel. В частности с
     * неустановленным State (когда его переопределяем)
     * @param forceUse - true - выполнить метод принудительно, false - если создан впервые
     */
    fun setup(forceUse: Boolean = false)
}