package com.example.announcements.presentation.base.views

import android.content.Intent
import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.announcements.extensions.nonNullObserve
import com.example.announcements.presentation.base.states.IState
import com.example.announcements.presentation.base.viewmodel.IBaseViewModel
import com.example.announcements.presentation.navigation.NavigatorConfig
import me.aartikov.alligator.AndroidNavigator
import me.aartikov.alligator.Screen
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.ParameterDefinition
import org.koin.core.parameter.emptyParameterDefinition
import org.koin.core.parameter.parametersOf
import java.io.Serializable

abstract class BaseActivity<IViewModel : IBaseViewModel<State>, State : IState>
    : AppCompatActivity(), IBaseView {
    protected val navigator: AndroidNavigator by inject()
    protected var viewModel: IViewModel? = null
    protected abstract val layoutId: Int
    protected lateinit var navigatorConfig: NavigatorConfig

//    private var attachFailedReceiver: BroadcastReceiver? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigatorConfig = NavigatorConfig(this, navigator = navigator)

        setupViewModel()
        setupUI()
        setupState()
        viewModel?.setup()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorConfig.bindNavigation()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        navigatorConfig.onActivityResult(requestCode, resultCode, data)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { navigatorConfig.onNewIntent(intent) }
    }

    protected abstract fun setupViewModel()

    @CallSuper
    protected open fun setupUI() {
        setContentView(layoutId)
    }

    private fun setupState() {
        viewModel?.state?.let { state ->
            subscribeOnStateChanges(state)
        }
    }


    protected open fun subscribeOnStateChanges(state: State) {
        // Empty
    }


    fun showErrorDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton("Ok") { _, _ -> }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    protected fun <T> registerNonNullObserver(liveData: LiveData<T>, func: (t: T) -> Unit) {
        liveData.nonNullObserve(this, func)
    }

    protected fun <T> registerNullableObserver(liveData: LiveData<T>, observer: Observer<T>) {
        liveData.observe(this, observer)
    }

    override fun onPause() {
        super.onPause()
        navigatorConfig.unbindNavigation()
    }

    override fun onBackPressed() {
        navigatorConfig.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun <T : Screen> getScreen(): T? = navigator.screenResolver.getScreenOrNull(this)

    inline fun <reified T : ViewModel, S : Screen> getViewModel(
        key: String? = null,
        name: String? = null
    ): T {
        val parameters: ParameterDefinition
        val screen = getScreen<S>()
        if (screen != null && screen is Serializable)
            parameters = { parametersOf(screen) }
        else
            parameters = emptyParameterDefinition()
        return getViewModel<T>(key, name, parameters = parameters)
    }
}