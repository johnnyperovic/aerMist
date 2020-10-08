package llc.amplitudo.base.di

import androidx.preference.PreferenceManager
import com.google.gson.GsonBuilder
import llc.amplitudo.base.BuildConfig
import llc.amplitudo.base.api.ApiService
import llc.amplitudo.base.repo.UserRepository
import llc.amplitudo.base.ui.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        if (BuildConfig.DEBUG)
            okHttpClient.addInterceptor(
                HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY })

        okHttpClient.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
            .create(ApiService::class.java)
    }


/*    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(
                LiveDataCallAdapterFactory(
                    ApiResponseFactory(
                        SpringApiErrorBodyDeserializer(get())
                    )
                )
            )
            .build()
            .create(ApiService::class.java)
    }*/
}

val repoModule = module {
    single { UserRepository(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
}
val miscModule = module {
    single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }

/*    single {
        GsonBuilder()
            .registerTypeAdapter(LocalDate::class.java, ThreeTenLocalDateTypeAdapter())
            .registerTypeAdapter(LocalDateTime::class.java, ThreeTenLocalDateTimeTypeAdapter())
            .registerTypeAdapter(OffsetDateTime::class.java, ThreeTenOffsetDateTimeTypeAdapter())
            .registerTypeAdapter(ZonedDateTime::class.java, ThreeTenZonedDateTimeTypeAdapter())
            .create()
    }*/
}