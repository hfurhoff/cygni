package cygni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The class with the main-method. Starts up the Spring-application.
 * @author Coyote
 */
@SpringBootApplication
public class Application {

    /**
	 * Main-method of the program. Starts up the Spring-application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}