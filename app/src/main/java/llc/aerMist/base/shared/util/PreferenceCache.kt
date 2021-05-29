package llc.aerMist.base.shared.util

import android.content.Context
import android.content.res.Configuration
import androidx.preference.PreferenceManager
import java.util.*

class PreferenceCache(val context: Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    var locale: Locale
        get() = Locale.forLanguageTag(prefs.getString(LOCALE, Locale.ENGLISH.language).orEmpty())
        set(value) = with(prefs.edit()) {
            putString(LOCALE, value.toLanguageTag())
            apply()
        }

    var uiMode: Int
        get() = prefs.getInt(UI_MODE, Configuration.UI_MODE_NIGHT_NO)
        set(value) = with(prefs.edit()) {
            putInt(UI_MODE, value)
            apply()
        }

    var accessToken: String
        get() = prefs.getString(AUTH_TOKEN, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(AUTH_TOKEN, value)
            apply()
        }

    var firstDevice: String
        get() = prefs.getString(FIRST_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(FIRST_DEVICE, value)
            apply()
        }

    var secondDevice: String
        get() = prefs.getString(SECOND_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(SECOND_DEVICE, value)
            apply()
        }

    var thirdDevice: String
        get() = prefs.getString(THIRD_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(THIRD_DEVICE, value)
            apply()
        }

    var fourthDevice: String
        get() = prefs.getString(FOURTH_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(FOURTH_DEVICE, value)
            apply()
        }
    fun clear() {
        prefs.edit()
            .remove(AUTH_TOKEN)
            .remove(REFRESH_TOKEN)
            .remove(LOCALE)
            .remove(UI_MODE)
            .remove(FIRST_DEVICE)
            .remove(SECOND_DEVICE)
            .remove(THIRD_DEVICE)
            .remove(FOURTH_DEVICE)
            .apply()
    }

    companion object {
        private const val AUTH_TOKEN = "authentication_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val LOCALE = "locale"
        private const val UI_MODE = "ui_mode"
        private const val FIRST_DEVICE = "first_device"
        private const val SECOND_DEVICE = "second_device"
        private const val THIRD_DEVICE = "third_device"
        private const val FOURTH_DEVICE = "fourth_device"

    }
}