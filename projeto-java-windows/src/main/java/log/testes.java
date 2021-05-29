package log;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 *
 * @author mathias.de.carvalho
 */
public class testes {

    public static void main(String[] args) {
//        System.getProperty("java.class.path");
//        System.out.println(System.getProperty("testes.class.path"));

        File file = new File("C:\\Users\\username\\baeldung\\bar\\baz\\..\\testes.java.txt");
        String path = file.getAbsolutePath();

        System.out.println(path);

    }
}
