package mr.cookie;

import java.util.List;
import mr.cookie.entities.Movie;
import org.jetbrains.annotations.NotNull;

public interface MovieService {

    /**
     * Return all movie entities from DB.
     *
     * @return all movie entities
     */
    @NotNull List<Movie> getAllMovies();

    /**
     * Save (if no id is provided) or updates (if id is provided) an input movie.
     *
     * @param movie saves or updates a movie
     * @return an updated (or saved) movie with id
     */
    @NotNull Movie saveMovie(@NotNull Movie movie);

    /**
     * Removes a movie with provided id from database.
     *
     * @param id an id of a movie to be removed
     */
    void deleteMovie(@NotNull Long id);

}
