package mr.cookie.mappers;

import mr.cookie.dto.MovieDto;
import mr.cookie.entities.Movie;
import org.jetbrains.annotations.Nullable;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MovieMapper {

    @Nullable Movie map(@Nullable MovieDto source);
    @Nullable MovieDto map(@Nullable Movie source);

}
