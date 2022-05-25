package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Integer> newMovies = movies.stream()
                .map(movie -> {
                    movie.setRating(5D);
                    return movie.getRating().intValue();
                })
                .filter(movie -> movie == 5)
                .collect(Collectors.toList());

        movies.stream()
                .forEach(movie -> System.out.println(movie.getRating()));

        return  newMovies;
    }
}
