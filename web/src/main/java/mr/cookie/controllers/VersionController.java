package mr.cookie.controllers;

import lombok.RequiredArgsConstructor;
import mr.cookie.VersionService;
import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: junits (5)
@RequiredArgsConstructor
@RestController("/version")
public class VersionController {

    private final @NotNull VersionService versionService;

    @GetMapping
    public @NotNull AppPropertiesDto getAppProperties() {
        return versionService.getVersionInfo();
    }

}
