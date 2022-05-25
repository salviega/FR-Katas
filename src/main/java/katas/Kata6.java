package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        Optional<String> newMovie = movies.stream()
                .flatMap(movie -> movie.getBoxarts().stream())
                .map(movie -> movie.getUrl())
                .reduce((a, b) -> a.length() > b.length() ? a : b);

        return newMovie.get();
    }
}
