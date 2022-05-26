package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movie -> movie.getVideos().stream())
                .map(letra -> {
                    List<String> url = letra.getBoxarts().stream()
                            .map(BoxArt::getUrl)
                            .filter(letritica -> letritica.contains("150"))
                            .collect(Collectors.toList());
                    return Map.of("id", letra.getId(), "title", letra.getTitle(), "boxart", url.get(0));
                })
                .collect(Collectors.toList());
    }
}
