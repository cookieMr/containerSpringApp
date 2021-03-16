package mr.cookie.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import mr.cookie.VersionService;
import mr.cookie.dto.AppPropertiesDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VersionControllerTest {

    @Mock
    private VersionService service;

    @InjectMocks
    private VersionController controller;

    @Test
    void getAppProperties() {
        AppPropertiesDto dto = AppPropertiesDto.builder().build();

        when(service.getVersionInfo()).thenReturn(dto);

        AppPropertiesDto result = controller.getAppProperties();

        assertThat(result)
            .isNotNull()
            .isEqualTo(dto);

        verify(service).getVersionInfo();
        verifyNoMoreInteractions(service);
    }

    @Test
    void clearCache() {
        controller.clearCache();

        verifyNoInteractions(service);
    }

}