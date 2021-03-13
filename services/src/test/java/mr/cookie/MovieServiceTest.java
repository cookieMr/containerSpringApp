package mr.cookie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import mr.cookie.entities.Movie;
import mr.cookie.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieServiceImpl service;

    @Test
    void getAllMovies() {
        List<Movie> movies = Collections.singletonList(new Movie());

        when(repository.findAll()).thenReturn(movies);

        List<Movie> result = service.getAllMovies();

        assertThat(result)
            .isNotNull()
            .hasSize(1)
            .containsAll(movies);

        verify(repository).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void saveMovie() {
        Movie movie = new Movie();
        Movie savedMovie = new Movie();

        when(repository.save(any(Movie.class))).thenReturn(savedMovie);

        Movie result = service.saveMovie(movie);

        assertThat(result)
            .isNotNull()
            .isEqualTo(savedMovie);

        verify(repository).save(eq(movie));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deleteExistingMovie() {
        Movie movie = new Movie();

        when(repository.findById(anyLong())).thenReturn(Optional.of(movie));

        service.deleteMovie(13L);

        verify(repository).findById(eq(13L));
        verify(repository).delete(eq(movie));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void deleteNonExistingMovie() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        service.deleteMovie(13L);

        verify(repository).findById(eq(13L));
        verifyNoMoreInteractions(repository);
    }

}