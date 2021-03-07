package mr.cookie.bootstrap;

import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mr.cookie.entities.Movie;
import mr.cookie.repositories.MovieRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MoviesH2Bootstrap implements CommandLineRunner {

    private final @NotNull MovieRepository movieRepository;

    @Override
    public void run(@Nullable String... args) {
        List<Movie> movies = Arrays.asList(
            new Movie(null, "Iron Man", 2008),
            new Movie(null, "The Incredible Hulk", 2008),
            new Movie(null, "Iron Man 2", 2010),
            new Movie(null, "Thor", 2011),
            new Movie(null, "Captain America: The First Avenger", 2011),
            new Movie(null, "Marvel's The Avengers", 2012),
            new Movie(null, "Iron Man 3", 2013),
            new Movie(null, "Thor: The Dark World", 2013),
            new Movie(null, "Captain America: The Winter Soldier", 2014),
            new Movie(null, "Guardians of the Galaxy", 2014),
            new Movie(null, "Avengers: Age of Ultron", 2015),
            new Movie(null, "Ant-Man", 2015),
            new Movie(null, "Captain America: Civil War", 2016),
            new Movie(null, "Doctor Strange", 2016),
            new Movie(null, "Guardians of the Galaxy Vol. 2", 2017),
            new Movie(null, "Spider-Man: Homecoming", 2017),
            new Movie(null, "Thor: Ragnarok", 2017),
            new Movie(null, "Black Panther", 2018),
            new Movie(null, "Avengers: Infinity War", 2018),
            new Movie(null, "Ant-Man and the Wasp", 2018),
            new Movie(null, "Captain Marvel", 2019),
            new Movie(null, "Avengers: Endgame", 2019),
            new Movie(null, "Spider-Man: Far From Home", 2019));
        movieRepository.saveAll(movies);
    }

}
