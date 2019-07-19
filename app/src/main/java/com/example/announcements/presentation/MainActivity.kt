package com.example.announcements.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.announcements.R
import com.example.announcements.data.network.service.IApiService
import com.example.announcements.extensions.observeOnMain
import com.example.announcements.extensions.subscribeOnIO
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val apiService: IApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        performFirstRequest()
    }

    fun performFirstRequest() {
        apiService.getOffers(20, 0)
            .subscribeOnIO()
            .observeOnMain()
            .subscribe({
            },{

            })
    }
}
