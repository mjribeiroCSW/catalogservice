package csw.catalogservice.services;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiverService
{
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String[] messageArray)
    {
        logger.info("Message received: {}", messageArray);

        latch.countDown();
    }

    /*
    @RabbitListener(queues = "testing-queue")
    public void receiveMessage(String message)
    {
        logger.info("Message received: {}", message);

        latch.countDown();
    }
    */

    public CountDownLatch getLatch()
    {
        return latch;
    }
}