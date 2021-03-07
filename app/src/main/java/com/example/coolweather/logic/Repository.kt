package com.example.coolweather.logic

import androidx.lifecycle.liveData
import com.example.coolweather.logic.model.Place
import com.example.coolweather.logic.network.CoolWeatherNetWork
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Query
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = CoolWeatherNetWork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            }else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}