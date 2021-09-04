package llc.aerMis.production

import android.app.Application

import llc.aerMis.production.di.miscModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
    }
}