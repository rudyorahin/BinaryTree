package edu.gcccd.csis;

import org.junit.Test;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class DeepFindTest {
    private static File findExtremeBFS(final Path p) {
        File x = null;
        final List<File> fileList = new ArrayList<>();
        fileList.add(p.toFile());
        while(!fileList.isEmpty()){
            final File fil = fileList.remove(0);
            if (fil.isFile()) {
                if (x == null || fil.length() > x.length()) {
                    x = fil;
                } else if (fil.length() == x.length()) {
                    if (fil.getPath().length() >= x.getPath().length()) {
                        x = fil;
                    }
                }
            }
            else if (fil.isDirectory()){
                final File[] dir = fil.listFiles();
                if (dir != null) {
                    fileList.addAll(Arrays.asList(dir));
                }
            }
        }
        return x;
    }

    @Test
    public void main() throws Exception {
        final File path = File.createTempFile("test", ".tmp");
        path.deleteOnExit();
        final Path p = path.getParentFile().getParentFile().toPath();
        final File extreme1 = DeepFind.findExtremeFile(p);
        final File extreme2 = DeepFindTest.findExtremeBFS(p);
        System.out.println(extreme1 + " " + extreme1.length() + "\n" + extreme2 + " " + extreme2.length());
        assertEquals(extreme1, extreme2);

    }
}