package by.grovs.task.reader;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {
    private final String DEFAULT_PATH = "data/input.txt";
    private static final Logger logger = Logger.getLogger(TextReader.class);

    public String read(String path) {
        if (path == null || !(new File(path)).exists() || (new File(path)).isDirectory()) {
            logger.warn(path + " text path is uncorrect!!! Changed to default path.");
            path = DEFAULT_PATH;
        }

        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
