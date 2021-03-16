package mr.cookie.dto;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AppPropertiesDto implements Serializable {

    private String name;
    private String version;
    private String sha1;
    private String commitMessage;
    private String springProfile;
    private UUID uuid;

}
