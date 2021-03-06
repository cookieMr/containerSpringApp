package mr.cookie.controllers;

import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: junits (5)
@RequiredArgsConstructor
@RestController("/version")
public class VersionController {

    @Value("${spring.application.name:#{null}}")
    private String appName;

    @Value("${spring.application.version:#{null}}")
    private String appVersion;

    // TODO: move these to a service class
    private Map<String, String> appProperties;

    @PostConstruct
    protected void initAppProperties() {
        this.appProperties = Map.of(
            "name", appName,
            "version", appVersion);
    }

    @GetMapping
    public @NotNull Map<String, String> getAppProperties() {
        // TODO: return a DTO
        return appProperties;
    }

}
