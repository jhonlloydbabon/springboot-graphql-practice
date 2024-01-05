package com.jlbabon.springbootgraphqlpractice.service;

import com.jlbabon.springbootgraphqlpractice.entity.Movie;
import com.jlbabon.springbootgraphqlpractice.exception.MovieNotFoundException;
import com.jlbabon.springbootgraphqlpractice.model.MovieModel;

import java.util.List;

public interface MovieService {
    List<Movie> fetchAllMovies();

    MovieModel createMovie(MovieModel movieModel);

    MovieModel updateMovie(Integer id, MovieModel movieModel) throws MovieNotFoundException;

    String deleteMovie(Integer id) throws MovieNotFoundException;

    Movie fetchMovieById(Integer id) throws MovieNotFoundException;
}
