package mr.cookie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AppPropertiesDto {

    private String name;
    private String version;
    private String sha1;
    private String commitMessage;

}
