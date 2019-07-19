package com.example.announcements.data.providers

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

class ResourcesProvider(
    private val context: Context
) : IResourcesProvider {

    override fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }

    override fun getStringOrNull(resId: Int?): String? {
        return resId?.let { textRes ->
            context.getString(textRes)
        }
    }

    override fun getQuantityString(@PluralsRes resId: Int, quantity: Int): String {
        return context.resources.getQuantityString(resId, quantity)
    }

    override fun getQuantityString(@PluralsRes resId: Int, quantity: Int, vararg args: Any):
            String {
        return context.resources.getQuantityString(resId, quantity, *args)
    }

    override fun getString(@StringRes resId: Int, vararg args: Any): String {
        return context.getString(resId, *args)
    }

    override fun getStringArray(@ArrayRes resId: Int): Array<String> {
        return context.resources.getStringArray(resId)
    }

    override fun getInteger(resId: Int): Int {
        return context.resources.getInteger(resId)
    }
}