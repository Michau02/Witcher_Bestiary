package kaluska.michal.Witcher_Bestiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WitcherBestiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(WitcherBestiaryApplication.class, args);
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("cmd /c start chrome.exe http://localhost:8080/home");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
