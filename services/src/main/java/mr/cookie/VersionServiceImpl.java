package mr.cookie;

import lombok.RequiredArgsConstructor;
import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VersionServiceImpl implements VersionService {

    @Value("${spring.application.name:#{null}}")
    private @Nullable String appName;

    @Value("${spring.application.version:#{null}}")
    private @Nullable String appVersion;

    @Value("${spring.profiles.active:#{null}}")
    private @Nullable String springProfile;

    @Override
    public @NotNull AppPropertiesDto getVersionInfo() {
        return AppPropertiesDto.builder()
            .name(appName)
            .version(appVersion)
            .springProfile(springProfile)
            .build();
    }

}
