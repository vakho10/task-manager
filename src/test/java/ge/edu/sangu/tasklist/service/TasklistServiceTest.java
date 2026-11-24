package ge.edu.sangu.tasklist.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TasklistServiceTest {

    private TasklistService service;

    @BeforeEach
    void setUp() {
        service = new TasklistService();
    }

    @Test
    @DisplayName("List method returns something")
    void list() throws IOException {
        String result = service.list();
        assertNotNull(result);
    }

    @Test
    @DisplayName("List processes method returns something")
    void listProcesses() throws IOException {
        var processes = service.listProcesses();
        assertFalse(processes.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("memoryUsageProvider")
    void parseMemoryUsage(String memoryUsage, long memoryUsageBytes) {
        long bytes = service.parseMemoryUsage(memoryUsage);
        assertEquals(memoryUsageBytes, bytes);
    }

    static Stream<Arguments> memoryUsageProvider() {
        return Stream.of(
                arguments("12,345 K", 12_345 * 1024),
                arguments("4 K", 4 * 1024),
                arguments("100,000 K", 100_000 * 1024)
        );
    }
}