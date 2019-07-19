package com.example.announcements.presentation.base.states

import com.example.announcements.domain.model.ErrorViewData
import com.example.announcements.presentation.base.events.LiveEvent

open class BaseState : IState {
    val errors: LiveEvent<ErrorViewData> = LiveEvent()
}