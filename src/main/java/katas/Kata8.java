package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        Stream<Integer> movieIds = movies.stream()
                .map(movie -> movie.getId());

        Stream<Integer> bookMarkIds = bookMarks.stream()
                .map(bookmark -> bookmark.getId());

        return StreamUtils.zip(movieIds, bookMarkIds,
                        (a, b) -> {
                            var zip = a + "-" + b;
                            return Map.of("ids", zip);
                        })
                .collect(Collectors.toList());
    }
}
