package mr.cookie.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.cookie.VersionService;
import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
public class VersionController implements ClearControllerCache {

    private final @NotNull VersionService versionService;

    @Cacheable(cacheNames = "versions", key = "#root.method.name")
    @GetMapping
    public @NotNull AppPropertiesDto getAppProperties() {
        log.info("Creating new version info object.");
        return versionService.getVersionInfo();
    }

    @CacheEvict(cacheNames = "versions", allEntries = true)
    @DeleteMapping
    @Override
    public void clearCache() {
        log.info("Clearing the version cache.");
    }

}
