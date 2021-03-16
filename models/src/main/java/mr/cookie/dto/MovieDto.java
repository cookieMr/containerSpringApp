package mr.cookie.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Movie Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto implements Serializable {

    @ApiModelProperty(example = "42",
        value = "An ID Assigned to the Movie by the Database, it is ignored if it doesn't exist in the database")
    private Long id;

    @ApiModelProperty(value = "The Movie's Title", example = "Black Widow")
    private String title;

    @ApiModelProperty(value = "The Movie's Release Year", example = "2021")
    private Integer releaseYear;

    @ApiModelProperty(value = "A unique UUID used to see how caching works, it is not persisted in the database",
        example = "abcd1234")
    private UUID uuid;

}
