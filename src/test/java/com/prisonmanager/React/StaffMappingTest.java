package com.prisonmanager.React;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StaffMappingTest {

    @Autowired
    RequestMappingHandlerMapping mappings;

    @Test
    void staffGetEndpointIsMapped() {
        boolean found = mappings.getHandlerMethods().keySet().stream()
                .flatMap(info -> {
                    // Spring 6+ can use PathPatternsCondition (PatternsRequestCondition may be null).
                    if (info.getPathPatternsCondition() != null) {
                        return info.getPathPatternsCondition().getPatterns().stream().map(Object::toString);
                    }
                    if (info.getPatternsCondition() != null) {
                        return info.getPatternsCondition().getPatterns().stream();
                    }
                    return java.util.stream.Stream.empty();
                })
                .anyMatch("/api/staff"::equals);

        assertTrue(found, "Expected GET /api/staff mapping to exist");
    }
}
