package com.jlbabon.springbootgraphqlpractice.service;

import com.jlbabon.springbootgraphqlpractice.entity.Movie;
import com.jlbabon.springbootgraphqlpractice.exception.MovieNotFoundException;
import com.jlbabon.springbootgraphqlpractice.model.MovieModel;
import com.jlbabon.springbootgraphqlpractice.repository.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> fetchAllMovies() {
        return movieRepository.findAll();
    }

        @Override
        public Movie fetchMovieById(Integer id) throws MovieNotFoundException {
            Movie movie = movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie doesn't exist"));
            return movie;
        }

    @Override
    public MovieModel createMovie(MovieModel movieModel) {
        Movie movieEntity = new Movie();
        BeanUtils.copyProperties(movieModel, movieEntity);
        movieRepository.save(movieEntity);
        return movieModel;
    }

    @Override
    public MovieModel updateMovie(Integer id, MovieModel movieModel) throws MovieNotFoundException {
        Movie movieEntity = movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie doesn't exist"));
        movieEntity.setTitle(movieModel.title());
        movieEntity.setDirector(movieModel.director());
        movieEntity.setStudio(movieModel.studio());
        movieEntity.setReleaseYear(movieModel.releaseYear());
        movieEntity.setMovieCast(movieModel.movieCast());
        movieRepository.save(movieEntity);
        return movieModel;
    }

    @Override
    public String deleteMovie(Integer id) throws MovieNotFoundException {
        Movie movie = movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie doesn't exist"));
        movieRepository.delete(movie);
        return "Deleted Successfully!";
    }

}
