package mr.cookie;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@PropertySource("classpath:git.properties")
public class VersionServiceImpl implements VersionService {

    @Value("${git.commit.id:#{null}}")
    private @Nullable String gitId;

    @Value("${git.commit.message.short:#{null}}")
    private @Nullable String gitShortMessage;

    @Value("${spring.application.name:#{null}}")
    private @Nullable String appName;

    @Value("${spring.application.version:#{null}}")
    private @Nullable String appVersion;

    @Value("${spring.profiles.active:#{null}}")
    private @Nullable String springProfile;

    @Override
    public @NotNull AppPropertiesDto getVersionInfo() {
        return AppPropertiesDto.builder()
            .commitMessage(gitShortMessage)
            .springProfile(springProfile)
            .version(appVersion)
            .name(appName)
            .sha1(gitId)
            .uuid(UUID.randomUUID())
            .build();
    }

}
