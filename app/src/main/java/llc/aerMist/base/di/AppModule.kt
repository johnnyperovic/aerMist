package llc.aerMist.base.di

import com.google.gson.GsonBuilder
import llc.aerMist.base.shared.util.PreferenceCache

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module



val miscModule = module {
    single { PreferenceCache(androidContext()) }
    single {
        GsonBuilder()
            .create()
    }
}
