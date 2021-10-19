package com.sophia.movieapp_simple.repository

import com.sophia.movieapp_simple.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject constructor(private val apiService: ApiService) {

    suspend fun getTvShows() = apiService.getTvShows()

}