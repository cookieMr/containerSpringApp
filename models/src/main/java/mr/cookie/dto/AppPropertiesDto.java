package mr.cookie.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Application Properties Data Transfer Object")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AppPropertiesDto implements Serializable {

    @ApiModelProperty(value = "This Application Name", example = "App Name")
    private String name;

    @ApiModelProperty(value = "This Application Version", example = "Version 42")
    private String version;

    @ApiModelProperty(value = "Sha1 of the Commit in the Git Repository", example = "1234abcd")
    private String sha1;

    @ApiModelProperty(value = "Message of the Commit in the Git Repository", example = "Commit Message")
    private String commitMessage;

    @ApiModelProperty(value = "The Spring Profile used to initiate this Spring Boot App", example = "profile")
    private String springProfile;

    @ApiModelProperty(value = "A unique UUID used to see how caching works", example = "abcd1234")
    private UUID uuid;

}
