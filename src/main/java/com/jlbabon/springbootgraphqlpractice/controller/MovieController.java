package com.jlbabon.springbootgraphqlpractice.controller;

import com.jlbabon.springbootgraphqlpractice.entity.Movie;
import com.jlbabon.springbootgraphqlpractice.exception.MovieNotFoundException;
import com.jlbabon.springbootgraphqlpractice.model.MovieModel;
import com.jlbabon.springbootgraphqlpractice.service.MovieService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @QueryMapping
    public List<Movie> fetchAllMovies(){
        return movieService.fetchAllMovies();
    }

    @QueryMapping
    public Movie fetchMovieById(@Argument Integer id) throws MovieNotFoundException {
        return movieService.fetchMovieById(id);
    }

    @MutationMapping
    public MovieModel createMovie(@Argument MovieModel movieModel){ return movieService.createMovie(movieModel); }

    @MutationMapping
    public MovieModel updateMovie(@Argument Integer id, @Argument MovieModel movieModel) throws MovieNotFoundException {
        return movieService.updateMovie(id, movieModel);
    }

    @MutationMapping
    public String deleteMovie(@Argument Integer id) throws MovieNotFoundException {
        return movieService.deleteMovie(id);
    }
}
