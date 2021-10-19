package com.sophia.movieapp_simple.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophia.movieapp_simple.models.TvShowItem
import com.sophia.movieapp_simple.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject
constructor(private val repository: TvShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()
    val responseTvShow: LiveData<List<TvShowItem>>
         get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d(TAG,"getAllTvShow Error: ${response.code()}")
            }
        }
    }

}