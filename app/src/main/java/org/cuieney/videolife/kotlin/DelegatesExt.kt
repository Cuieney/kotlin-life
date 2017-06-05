package org.cuieney.videolife.common.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.view.View
import android.widget.Toast
import org.cuieney.videolife.R
import org.cuieney.videolife.entity.MusicListBean
import org.cuieney.videolife.kotlin.App
import org.cuieney.videolife.kotlin.ui.act.PlayMusicActivity
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by cuieney on 2017/5/19.
 */
object DelegatesExt {
    fun <T : Any> preference(context: Context, name: String, default: T)
            = Preference(context, name, default)

    fun Context.getMainComponent() = App.instance

    fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, length).show()
    }

    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()

}

class NotNullSingleValueVar<T> {

    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }
}

class Preference<T>(val context: Context, val name: String, val default: T)
    : ReadWriteProperty<Any?, T> {


    val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun <T> findPreference(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException(
                    "This type can be saved into Preferences")
        }

        res as T
    }

    private fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()
    }


}

