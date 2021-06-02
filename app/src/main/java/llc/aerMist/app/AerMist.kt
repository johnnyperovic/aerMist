package llc.aerMist.app

import android.app.Application

import llc.aerMist.app.di.miscModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

@Suppress("unused")
class AerMist : Application() {


    override fun onCreate() {
        super.onCreate()

        // Initialize Koin
        startKoin {
            androidContext(this@AerMist)
            androidLogger(Level.ERROR)
            modules(
                listOf(
                    miscModule
                )
            )
        }

        Timber.plant(Timber.DebugTree())
    }
}