package edu.gcccd.csis;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeepFind {
    public static void main(final String[] args) {
        final Path path = Paths.get(args.length < 1 ? "." : args[0]);
        System.out.println(path);
        final File ex = findExtremeFile(path);
        System.out.printf("Starting at : %s, the largest file was found here:\n%s\n its size is: %d\n",
                path.toAbsolutePath().toString(),
                ex.getAbsolutePath(),
                ex.length());
    }

    static File extreme(final File f1, final File f2) {
        if (f2 == null) return f1;
        else if (f1 == null) return f2;
        else if (f2.length() > f1.length()) return f2;
        else if (f2.length() < f1.length()) return f1;
        else {
            if (f2.getAbsolutePath().length() > f1.getAbsolutePath().length()) return f2;
            else if (f2.getAbsolutePath().length() < f1.getAbsolutePath().length()) return f1;
            else return f2;
            }
    }

    static File findExtremeFile(final Path p) {
        File result = null;
        final File[] fa = p.toFile().listFiles();
        if (fa != null && 0 < fa.length) {
            for (File file : fa) {
                if (file.isFile()) {
                    result = extreme(result,file);
                } else if (file.isDirectory()) {
                    File fileDirectory = findExtremeFile(Paths.get(file.getPath()));
                    result = extreme(result, fileDirectory);
                }

            }
        }
        return result;
    }

}
