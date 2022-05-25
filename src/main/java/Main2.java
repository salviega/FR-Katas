import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.*;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Map.entry;
import static org.junit.Assert.assertEquals;

public class Main2 {

    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movie -> {
                    return movie.getVideos().stream();
                })
                .map(movie -> {
                    return movie.getId().intValue();
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println(execute().size());
    }
}
