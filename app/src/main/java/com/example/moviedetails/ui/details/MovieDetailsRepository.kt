package com.example.moviedetails.ui.details

import com.example.moviedetails.data.moviedetails.MovieDetails
import com.example.moviedetails.remote.MovieInterface
import com.example.moviedetails.utils.Constants
import com.example.moviedetails.utils.Status
import com.example.moviedetails.utils.Result
class MovieDetailsRepository (private val movieInterface: MovieInterface) {

    suspend fun getMovieDetails(imdbId : String) : Result<MovieDetails>{
        return try{
            val response = movieInterface.getMovieDetails(imdbId,Constants.API_KEY)
            if(response.isSuccessful){
                Result(Status.SUCCESS,response.body(),null)
            }else{
                Result(Status.ERROR,null,null)
            }
        }catch (e:Exception){
           Result(Status.ERROR,null,null)
        }
    }
}