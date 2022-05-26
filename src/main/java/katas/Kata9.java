package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> newMovie = movieLists.stream()
                .flatMap(movie -> movie.getVideos().stream())
                .map(movie -> {
                    movie.getInterestingMoments().get(2).getTime();
                    List<String> url = movie.getBoxarts().stream()
                            .map(BoxArt::getUrl)
                            .filter(movecita -> movecita.contains("150"))
                            .collect(Collectors.toList());
                    return Map.of("id", movie.getId(), "title", movie.getTitle(), "time", movie.getInterestingMoments().get(2).getTime(), "url", url.get(0));
                })
                .collect(Collectors.toList());
        System.out.println(newMovie);
        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}
