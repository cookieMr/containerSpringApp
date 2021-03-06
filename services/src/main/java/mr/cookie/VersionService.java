package mr.cookie;

import mr.cookie.dto.AppPropertiesDto;
import org.jetbrains.annotations.NotNull;

public interface VersionService {

    /**
     * Returns information about the app mostly useful for bug reports.
     *
     * @return information about the app
     */
    @NotNull AppPropertiesDto getVersionInfo();

}
