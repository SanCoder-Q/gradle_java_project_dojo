package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SanCoder on 7/11/15.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello Spring";
            }
        };
    }

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}


