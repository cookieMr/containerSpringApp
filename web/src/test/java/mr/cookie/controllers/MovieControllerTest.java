package mr.cookie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import mr.cookie.MovieService;
import mr.cookie.dto.MovieDto;
import mr.cookie.entities.Movie;
import mr.cookie.mappers.MovieMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    @Mock
    private MovieService service;

    @Mock
    private MovieMapper mapper;

    @InjectMocks
    private MovieController controller;

    @Test
    void getAllMovies() {
        Movie movie = new Movie();
        MovieDto dto = new MovieDto();

        List<Movie> movies = Arrays.asList(null, movie);

        when(service.getAllMovies()).thenReturn(movies);
        when(mapper.map((Movie) isNull())).thenReturn(null);
        when(mapper.map(any(Movie.class))).thenReturn(dto);

        List<MovieDto> result = controller.getAllMovies();

        assertThat(result)
            .isNotNull()
            .hasSize(1)
            .doesNotContainNull()
            .containsOnly(dto);

        verify(service).getAllMovies();
        verify(mapper).map((Movie) isNull());
        verify(mapper).map(eq(movie));
        verifyNoMoreInteractions(service, mapper);
    }

    @Test
    void saveOrUpdateMovieMapsDtoToNull() {
        MovieDto dto = new MovieDto();

        assertThatThrownBy(() -> controller.saveOrUpdateMovie(dto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Could not save provided movie!");

        verify(mapper).map(eq(dto));
        verifyNoMoreInteractions(mapper);
        verifyNoInteractions(service);
    }

    @Test
    void saveOrUpdateMovieSavesToNull() {
        MovieDto dto = new MovieDto();
        Movie movie = new Movie();

        when(mapper.map(any(MovieDto.class))).thenReturn(movie);

        assertThatThrownBy(() -> controller.saveOrUpdateMovie(dto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Could not save provided movie!");

        verify(mapper).map(eq(dto));
        verify(service).saveMovie(eq(movie));
        verifyNoMoreInteractions(mapper, service);
    }

    @Test
    void saveOrUpdateMovieMapsSavedToNull() {
        MovieDto dto = new MovieDto();
        Movie movie = new Movie();
        Movie savedMovie = new Movie();

        when(mapper.map(any(MovieDto.class))).thenReturn(movie);
        when(service.saveMovie(any(Movie.class))).thenReturn(savedMovie);

        assertThatThrownBy(() -> controller.saveOrUpdateMovie(dto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Could not save provided movie!");

        verify(mapper).map(eq(dto));
        verify(mapper).map(eq(savedMovie));
        verify(service).saveMovie(eq(movie));
        verifyNoMoreInteractions(mapper, service);
    }

    @Test
    void saveOrUpdateMovie() {
        MovieDto dto = new MovieDto();
        Movie movie = new Movie();
        Movie savedMovie = new Movie();
        MovieDto savedDto = new MovieDto();

        when(mapper.map(any(MovieDto.class))).thenReturn(movie);
        when(service.saveMovie(any(Movie.class))).thenReturn(savedMovie);
        when(mapper.map(any(Movie.class))).thenReturn(savedDto);

        MovieDto result = controller.saveOrUpdateMovie(dto);

        assertThat(result)
            .isNotNull()
            .isEqualTo(savedDto);

        verify(mapper).map(eq(dto));
        verify(mapper).map(eq(savedMovie));
        verify(service).saveMovie(eq(movie));
        verifyNoMoreInteractions(mapper, service);
    }

    @Test
    void removeMovie() {
        controller.removeMovie(13L);

        verify(service).deleteMovie(eq(13L));
        verifyNoMoreInteractions(service);
        verifyNoInteractions(mapper);
    }

    @Test
    void clearCache() {
        controller.clearCache();

        verifyNoInteractions(service, mapper);
    }

}