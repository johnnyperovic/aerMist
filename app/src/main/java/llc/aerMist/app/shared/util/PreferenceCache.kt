package llc.aerMist.app.shared.util

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

    var startWorkingTimeFD: String
        get() = prefs.getString(START_WORKING_TIME_FD, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(START_WORKING_TIME_FD, value)
            apply()
        }
    var startWorkingTimeSD: String
        get() = prefs.getString(START_WORKING_TIME_SD, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(START_WORKING_TIME_SD, value)
            apply()
        }
    var startWorkingTimeTD: String
        get() = prefs.getString(START_WORKING_TIME_TD, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(START_WORKING_TIME_TD, value)
            apply()
        }
    var startWorkingTimeFRD: String
        get() = prefs.getString(START_WORKING_TIME_FRD, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(START_WORKING_TIME_FRD, value)
            apply()
        }


    var isOneDevice: Boolean
        get() = prefs.getBoolean(IS_ONE_DEVICE, false)
        set(value) = with(prefs.edit()) {
            putBoolean(IS_ONE_DEVICE, value)
            apply()
        }
    var isDeleted: Boolean
        get() = prefs.getBoolean(IS_DELETED, false)
        set(value) = with(prefs.edit()) {
            putBoolean(IS_DELETED, value)
            apply()
        }
    var isFromHomeScreen: Boolean
        get() = prefs.getBoolean(IS_FROM_HOME_SCREEN, false)
        set(value) = with(prefs.edit()) {
            putBoolean(IS_FROM_HOME_SCREEN, value)
            apply()
        }
    var scheduleModel: String
        get() = prefs.getString(SCHEDULE_MODEL, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(SCHEDULE_MODEL, value)
            apply()
        }
    var deviceState: String
        get() = prefs.getString(DEVICE_STATE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(DEVICE_STATE, value)
            apply()
        }
    var intervalModel: String
        get() = prefs.getString(INTERVAL_MODEL, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(INTERVAL_MODEL, value)
            apply()
        }
    var firstDevice: String
        get() = prefs.getString(FIRST_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(FIRST_DEVICE, value)
            apply()
        }
    var firstBleDevice: String
        get() = prefs.getString(FIRST_BLE_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(FIRST_BLE_DEVICE, value)
            apply()
        }
    var secondBleDevice: String
        get() = prefs.getString(SECOND_BLE_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(SECOND_BLE_DEVICE, value)
            apply()
        }
    var thirdBleDevice: String
        get() = prefs.getString(THIRD_BLE_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(THIRD_BLE_DEVICE, value)
            apply()
        }
    var fourthBleDevice: String
        get() = prefs.getString(FOURTH_BLE_DEVICE, "").orEmpty()
        set(value) = with(prefs.edit()) {
            putString(FOURTH_BLE_DEVICE, value)
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
    fun clearDelete() {
        prefs.edit()
            .remove(IS_DELETED).apply()}
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
            .remove(START_WORKING_TIME_FD)
            .remove(START_WORKING_TIME_SD)
            .remove(START_WORKING_TIME_TD)
            .remove(START_WORKING_TIME_FRD)
            .remove(IS_FROM_HOME_SCREEN)
            .remove(FIRST_BLE_DEVICE)
            .remove(SECOND_BLE_DEVICE)
            .remove(THIRD_BLE_DEVICE)
            .remove(FOURTH_BLE_DEVICE)
            .remove(IS_ONE_DEVICE)
            .remove(SCHEDULE_MODEL)
            .remove(DEVICE_STATE)
            .remove(INTERVAL_MODEL)
            .apply()
    }

    fun cleanFirstDevice() {
        prefs.edit().remove(FIRST_DEVICE).apply()
        prefs.edit().remove(FIRST_BLE_DEVICE).apply()
    }

    fun cleanSecondDevice() {
        prefs.edit()
            .remove(SECOND_DEVICE).apply()
        prefs.edit().remove(SECOND_BLE_DEVICE).apply()

    }

    fun cleanThirdDevice() {
        prefs.edit()
            .remove(THIRD_DEVICE).apply()
        prefs.edit().remove(THIRD_BLE_DEVICE).apply()
    }

    fun cleanFourthDevice() {
        prefs.edit()
            .remove(FOURTH_DEVICE).apply()
        prefs.edit().remove(FOURTH_BLE_DEVICE).apply()

    }
    fun cleanFirstFilter() {
        prefs.edit().remove(START_WORKING_TIME_FD).apply()
    }

    fun cleanSecondFilter() {
        prefs.edit()
            .remove(START_WORKING_TIME_SD).apply()
    }

    fun cleanThirdFilter() {
        prefs.edit()
            .remove(START_WORKING_TIME_TD).apply()
    }

    fun cleanFourthFilter() {
        prefs.edit()
            .remove(START_WORKING_TIME_FRD).apply()
    }

    companion object {
        private const val AUTH_TOKEN = "authentication_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val LOCALE = "locale"
        private const val UI_MODE = "ui_mode"
        private const val FIRST_DEVICE = "first_device"
        private const val SCHEDULE_MODEL = "schedule_model"
        private const val DEVICE_STATE = "device_state"
        private const val SECOND_DEVICE = "second_device"
        private const val THIRD_DEVICE = "third_device"
        private const val FOURTH_DEVICE = "fourth_device"
        private const val FIRST_BLE_DEVICE = "first_ble_device"
        private const val SECOND_BLE_DEVICE = "second_ble_device"
        private const val THIRD_BLE_DEVICE = "third_ble_device"
        private const val FOURTH_BLE_DEVICE = "fourth_ble_device"
        private const val INTERVAL_MODEL = "interval_model"

        private const val START_WORKING_TIME_FD = "start_working_time_fd"
        private const val START_WORKING_TIME_SD = "start_working_time_sd"
        private const val START_WORKING_TIME_TD = "start_working_time_td"
        private const val START_WORKING_TIME_FRD = "start_working_time_frd"
        private const val IS_ONE_DEVICE = "isOneDevice"
        private const val IS_FROM_HOME_SCREEN = "isFromHomeScreen"
        private const val IS_DELETED = "isDeleted"

    }
}