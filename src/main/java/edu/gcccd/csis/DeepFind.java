package edu.gcccd.csis;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeepFind {
    public static void main(final String[] args) {
        final Path path = Paths.get(args.length < 1 ? "." : args[0]);
        final File ex = findExtremeFile(path);
        System.out.printf("Starting at : %s, the largest file was found here:\n%s\n its size is: %d\n",
                path.toAbsolutePath().toString(),
                ex.getAbsolutePath(),
                ex.length());
    }

    static File findExtremeFile(final Path p) {
        File result = null;
        final File[] fa = p.toFile().listFiles();
        if (fa != null) {
            for (File file : fa) {
                if (file.isFile()) {
                    if (result == null || file.length() > result.length()) {
                        result = file;
                    } else if (file.length() == result.length()) {
                        if (file.getPath().length() >= result.getPath().length()) {
                            result = file;
                        }
                    }
                }
                else if (file.isDirectory()) {
                    File fileDirectory = findExtremeFile(Paths.get(file.getPath()));
                    if (result == null) {
                        result = fileDirectory;
                    } else if (fileDirectory != null && result.length() < fileDirectory.length())
                        result = fileDirectory;
                }
            }
        }
        return result;
    }

}
