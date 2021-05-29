package llc.aerMist.base.shared.util

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlin.math.sqrt

class ShakeDetector(context: Context) {
    private var listeners = arrayListOf<OnShakeListener>()
    private var mShakeTimestamp: Long = 0
    private var mShakeCount = 0

    private val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    private val sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            val gX = x / SensorManager.GRAVITY_EARTH
            val gY = y / SensorManager.GRAVITY_EARTH
            val gZ = z / SensorManager.GRAVITY_EARTH
            val gForce: Float = sqrt(gX * gX + gY * gY + gZ * gZ)
            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
                val now = System.currentTimeMillis()
                if (mShakeTimestamp + SHAKE_SLOP_TIME_MS > now) {
                    return
                }
                if (mShakeTimestamp + SHAKE_COUNT_RESET_TIME_MS < now) {
                    mShakeCount = 0
                }
                mShakeTimestamp = now
                mShakeCount++
                listeners.forEach {
                    it.onShake(mShakeCount)
                }
            }
        }
    }

    fun attachOnShakeListener(listener: OnShakeListener) {
        if (listeners.isEmpty()) {
            sensorManager.registerListener(
                sensorEventListener,
                accelerometer,
                SensorManager.SENSOR_DELAY_UI
            )
        }
        listeners.add(listener)
    }

    fun detachOnShakeListener(listener: OnShakeListener) {
        listeners.remove(listener)
        if (listeners.isEmpty()) {
            sensorManager.unregisterListener(sensorEventListener)
        }
    }


    companion object {
        private const val SHAKE_THRESHOLD_GRAVITY = 2.7f
        private const val SHAKE_SLOP_TIME_MS = 500
        private const val SHAKE_COUNT_RESET_TIME_MS = 3000
    }
}

interface OnShakeListener {
    fun onShake(count: Int)
}