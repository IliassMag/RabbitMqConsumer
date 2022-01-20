package com.consumer.consumerrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE_EXCEL)
    public void listener(CustomFile customFile) throws IOException {
        File fileDestination = new File("C:\\CanevasDestination.xlsx");
        Files.write(fileDestination.toPath(), customFile.bytesFromFile);
    }
}
