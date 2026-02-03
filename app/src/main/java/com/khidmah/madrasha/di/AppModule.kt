package com.khidmah.madrasha.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//      @Provides
//    @Singleton
//    fun providesUserDatabase(application: Application): PatientDatabase {
//        return Room.databaseBuilder(
//            application,
//            PatientDatabase::class.java,
//            PatientDatabase.DB_NAME
//        ).build()
//    }
    @Provides
    @Singleton
    fun providesSharedPreference(application: Application): SharedPreferences {
        return application.getSharedPreferences("jwt_token", Context.MODE_PRIVATE)
    }

    /*
    @Provides
    @Singleton
    fun providesOkHttpClient(@ApplicationContext context: Context, preferences: SharedPreferences): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val jwtToken = TokenManager.getJWTToken(preferences)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header(
                        name = "Authorization",
                        value = jwtToken
                    )
                    .build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return client
    }

    @Provides
    @Singleton
    fun providesApiServices(okHttpClient: OkHttpClient): ApiServices {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Urls.get("base"))
            .client(okHttpClient)
            .build()
            .create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun providesCommonUseCase(apiServices: ApiServices): CommonUseCase {
        return CommonUseCase(
            getUserProfileInfo = GetUserProfileInfo(apiServices = apiServices),
            getNotifications = GetNotifications(apiServices = apiServices),
            acceptFriendRequest = AcceptFriendRequest(apiServices = apiServices)
        )
    }

     */


}