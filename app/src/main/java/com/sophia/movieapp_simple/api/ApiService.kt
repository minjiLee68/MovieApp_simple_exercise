package com.sophia.movieapp_simple.api

import com.sophia.movieapp_simple.helper.Constants
import com.sophia.movieapp_simple.models.TvShowReponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowReponse>
}