package upbit.project.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import upbit.project.openapi.controller.UpbitTickerController;

@SpringBootApplication
public class SampleProjectApplication  {
    public static void main(String[] args) {
        SpringApplication.run(UpbitTickerController.class, args);
    }
}
