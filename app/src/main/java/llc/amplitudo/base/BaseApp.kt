package llc.amplitudo.base

import android.app.Application
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.jakewharton.threetenabp.AndroidThreeTen
import llc.amplitudo.base.di.*
import llc.amplitudo.base.shared.GlideApp
import okhttp3.OkHttpClient
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import java.io.InputStream

@Suppress("unused")
class BaseApp : Application() {

    private val sharedOkHttpClient: OkHttpClient by inject()

    override fun onCreate() {
        super.onCreate()

        // Initialize Koin
        startKoin {
            androidContext(this@BaseApp)
            androidLogger(Level.ERROR)
            modules(
                listOf(
                    networkModule,
                    repoModule,
                    viewModelModule,
                    miscModule
                )
            )
        }

        // Initialize the timezone information for your application
        AndroidThreeTen.init(this)

        // Initialize Glide with shared instance of OkHttpClient
        GlideApp.get(this)
            .registry
            .replace(
                GlideUrl::class.java,
                InputStream::class.java,
                OkHttpUrlLoader.Factory(sharedOkHttpClient)
            )

        // Initialize timber
        Timber.plant(Timber.DebugTree())
    }
}