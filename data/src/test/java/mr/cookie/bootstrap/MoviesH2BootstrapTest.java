package mr.cookie.bootstrap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;
import java.util.Objects;
import mr.cookie.entities.Movie;
import mr.cookie.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MoviesH2BootstrapTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MoviesH2Bootstrap bootstrap;

    @Captor
    private ArgumentCaptor<List<Movie>> movieCaptor;

    @Test
    void bootstrapRun() {
        bootstrap.run();

        verify(repository).saveAll(movieCaptor.capture());
        verifyNoMoreInteractions(repository);

        assertThat(movieCaptor.getValue())
            .isNotNull()
            .hasSize(23)
            .doesNotContainNull()
            .allMatch(movie -> Objects.isNull(movie.getId()))
            .allMatch(movie -> Objects.nonNull(movie.getTitle()))
            .allMatch(movie -> movie.getReleaseYear() >= 2008)
            .allMatch(movie -> movie.getReleaseYear() <= 2019);
    }

}