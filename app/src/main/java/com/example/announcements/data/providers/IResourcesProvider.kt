package com.example.announcements.data.providers

import androidx.annotation.ArrayRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface IResourcesProvider {

    fun getString(@StringRes resId: Int): String

    fun getStringOrNull(@StringRes resId: Int?): String?

    fun getQuantityString(@PluralsRes resId: Int, quantity: Int): String

    fun getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg args: Any): String

    fun getString(@StringRes resId: Int, vararg args: Any): String

    fun getStringArray(@ArrayRes resId: Int): Array<String>

    fun getInteger(@IntegerRes resId: Int): Int
}