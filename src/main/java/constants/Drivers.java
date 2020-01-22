package constants;

import java.io.File;

public class Drivers {
    public static final String CHROME = "drivers" + File.separator + "chromedriver.exe";

    private Drivers() {
        throw new IllegalStateException("Constants class");

    }
}