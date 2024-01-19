package csw.catalogservice.services;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RaabitSenderService implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitReceiverService receiver;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public RaabitSenderService(
            RabbitReceiverService receiver,
            RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args)  throws Exception {
        logger.info("Sending: {}", args);

        rabbitTemplate.convertAndSend(
                "spring-boot-exchange",
                "foo.bar.baz",
                args);

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}