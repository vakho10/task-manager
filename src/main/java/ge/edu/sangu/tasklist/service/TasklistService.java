package ge.edu.sangu.tasklist.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TasklistService {

    private static final String CMD_COMMAND = "tasklist /FO \"CSV\" /NH";
    private static final ProcessBuilder PROCESS_BUILDER = new ProcessBuilder("cmd.exe", "/c", CMD_COMMAND);

    {
        PROCESS_BUILDER.redirectErrorStream(true); // TODO check this later!
    }

    public String list() throws IOException {
        var process = PROCESS_BUILDER.start();

        try (var inputStream = process.getInputStream();
             var reader = new InputStreamReader(inputStream);
             var bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        }
    }

    public List<Process> listProcesses() throws IOException {
        return Arrays.stream(list().split("\n"))
                .map(line -> {
                    // Remove first and last quotation marks
                    line = line.substring(1, line.length() - 1);
                    String[] parts = line.split("\",\"");

                    return new Process(parts[0], Integer.parseInt(parts[1]), parts[2],
                            Integer.parseInt(parts[3]), parseMemoryUsage(parts[4]));
                })
                .toList();
    }

    /**
     * Parses memory usage string and converts to long bytes.
     *
     * @param memoryUsage kilobytes string
     * @return memory usage bytes as long.
     */
    public long parseMemoryUsage(String memoryUsage) {
        return Long.parseLong(memoryUsage.replaceAll("(\\,|\\ K)", "")) * 1024;
    }
}
