package mr.cookie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.util.ReflectionTestUtils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VersionServiceTest {

    @InjectMocks
    private VersionServiceImpl service;

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(service, "appName", "the app name");
        ReflectionTestUtils.setField(service, "appVersion", "the app version");
        ReflectionTestUtils.setField(service, "springProfile", "the spring profile");
    }

    @Test
    void getVersionInfo() {
        assertThat(service.getVersionInfo())
            .isNotNull()
            .matches(info -> Objects.equals(info.getName(), "the app name"))
            .matches(info -> Objects.equals(info.getVersion(), "the app version"))
            .matches(info -> Objects.equals(info.getSpringProfile(), "the spring profile"));
    }

}