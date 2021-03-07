package mr.cookie;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mr.cookie.entities.Movie;
import mr.cookie.repositories.MovieRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final @NotNull MovieRepository movieRepository;

    @Override
    public @NotNull List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    @Override
    public @NotNull Movie saveMovie(@NotNull Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    @Override
    public void deleteMovie(@NotNull Long id) {
        movieRepository.findById(id)
            .ifPresent(movieRepository::delete);
    }

}
