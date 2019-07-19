package com.example.announcements.presentation.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import me.aartikov.alligator.AndroidNavigator
import me.aartikov.alligator.NavigationContext
import me.aartikov.alligator.animations.providers.DialogAnimationProvider
import me.aartikov.alligator.animations.providers.TransitionAnimationProvider
import me.aartikov.alligator.listeners.*
import me.aartikov.alligator.screenswitchers.ScreenSwitcher

class NavigatorConfig(
    private val activity: AppCompatActivity, private val navigator:
    AndroidNavigator
) {
    var fragmentManager: FragmentManager? = null
    var containerId: Int = 0
    var screenSwitcher: ScreenSwitcher? = null
    var transitionAnimationProvider: TransitionAnimationProvider? = null
    var dialogAnimationProvider: DialogAnimationProvider? = null
    var transitionListener: TransitionListener? = null
    var dialogShowingListener: DialogShowingListener? = null
    var screenSwitchingListener: ScreenSwitchingListener? = null
    var screenResultListener: ScreenResultListener? = null
    var navigationErrorListener: NavigationErrorListener? = null

    val canExecuteCommandImmediately: Boolean get() = navigator.canExecuteCommandImmediately()

    fun bindNavigation() {
        val navigationContext = NavigationContext.Builder(activity)
            .fragmentManager(fragmentManager)
            .containerId(containerId)
            .screenSwitcher(screenSwitcher)
            .transitionAnimationProvider(transitionAnimationProvider)
            .dialogAnimationProvider(dialogAnimationProvider)
            .transitionListener(transitionListener)
            .dialogShowingListener(dialogShowingListener)
            .screenSwitchingListener(screenSwitchingListener)
            .screenResultListener(screenResultListener)
            .navigationErrorListener(navigationErrorListener)
            .build()
        navigator.bind(navigationContext)
    }

    fun unbindNavigation() {
        navigator.unbind(activity)
    }

    fun onNewIntent(intent: Intent) {
        navigator.activityResultHandler.onNewIntent(intent)
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        navigator.activityResultHandler.onActivityResult(requestCode, resultCode, data)
    }

    fun onBackPressed(): Boolean {
        navigator.goBack()
        return true
    }
}