package com.example.moviedetails.remote

import com.example.moviedetails.data.MovieResponse
import com.example.moviedetails.data.moviedetails.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.sql.RowId


interface MovieInterface {


    @GET("/")
    suspend fun getAllMovies(
        @Query("s")s:String,
        @Query("page")page:Int,
        @Query("apiKey")apiKey:String
    ):Response<MovieResponse>

    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbId:String,
        @Query("apiKey")apiKey:String
    ):Response<MovieDetails>
}