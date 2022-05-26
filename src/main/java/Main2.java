import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.*;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.compare;
import static java.util.Arrays.stream;
import static java.util.Map.entry;
import static java.util.Map.of;
import static org.junit.Assert.assertEquals;

public class Main2 {
 // Stream<Integer> movieIds =
 // /*Stream<Integer> bookMarkIds =
    // List<Object> zipped =
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
    public static void main(String[] args) {

        System.out.println(execute().size());
    }
}
