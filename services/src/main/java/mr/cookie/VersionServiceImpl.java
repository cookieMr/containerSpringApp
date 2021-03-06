package mr.cookie;

import lombok.RequiredArgsConstructor;
import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// TODO: junits (5)
@RequiredArgsConstructor
@Service
public class VersionServiceImpl implements VersionService {

    @Value("${spring.application.name:#{null}}")
    private String appName;

    @Value("${spring.application.version:#{null}}")
    private String appVersion;

    @Override
    public @NotNull AppPropertiesDto getVersionInfo() {
        return AppPropertiesDto.builder()
            .name(appName)
            .version(appVersion)
            .build();
    }

}
