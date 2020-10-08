package llc.amplitudo.base.di

import androidx.preference.PreferenceManager
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.google.i18n.phonenumbers.PhoneNumberUtil
import llc.amplitudo.base.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZonedDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG)
            okHttpClient.addInterceptor(
                HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY })

        okHttpClient.build()
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
    // single { SampleRepository(get()) }
}

val viewModelModule = module {
    // viewModel { MainViewModel(get()) }
}
val miscModule = module {
    single { PhoneNumberUtil.getInstance() }

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

val roomModule = module {
/*    single {
        Room.databaseBuilder(androidApplication(), RemoneyDatabase::class.java, "remoney-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<RemoneyDatabase>().cardDao() }
    single { get<RemoneyDatabase>().transactionDao() }*/
}