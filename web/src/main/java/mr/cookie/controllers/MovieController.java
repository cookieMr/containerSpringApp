package mr.cookie.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.cookie.MovieService;
import mr.cookie.dto.MovieDto;
import mr.cookie.mappers.MovieMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController implements ClearControllerCache {

    private final @NotNull MovieService movieService;
    private final @NotNull MovieMapper movieMapper;

    @Cacheable(cacheNames = "movies", key = "#root.method.name")
    @GetMapping
    public @NotNull List<MovieDto> getAllMovies() {
        log.info("Retrieving all movies from repository.");
        return movieService.getAllMovies()
            .stream()
            .map(movieMapper::map)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    @CacheEvict(cacheNames = "movies", allEntries = true)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @NotNull MovieDto saveOrUpdateMovie(@RequestBody @NotNull MovieDto movieDto) {
        return Optional.of(movieDto)
            .map(movieMapper::map)
            .map(movieService::saveMovie)
            .map(movieMapper::map)
            .orElseThrow(() -> new IllegalArgumentException("Could not save provided movie!"));
    }

    @CacheEvict(cacheNames = "movies", allEntries = true)
    @DeleteMapping("/{id}")
    public void removeMovie(@PathVariable("id") @NotNull Long id) {
        movieService.deleteMovie(id);
    }

    @CacheEvict(cacheNames = "movies", allEntries = true)
    @DeleteMapping
    @Override
    public void clearCache() {
        log.info("Clearing the movies cache.");
    }

}
