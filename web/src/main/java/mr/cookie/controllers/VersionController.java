package mr.cookie.controllers;

import lombok.RequiredArgsConstructor;
import mr.cookie.VersionService;
import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
public class VersionController {

    private final @NotNull VersionService versionService;

    @GetMapping
    public @NotNull AppPropertiesDto getAppProperties() {
        return versionService.getVersionInfo();
    }

}
