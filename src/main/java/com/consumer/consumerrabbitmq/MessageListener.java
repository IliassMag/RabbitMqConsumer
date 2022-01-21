package com.consumer.consumerrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE_EXCEL)
    public void listenerFileExcel(CustomFile customFile) throws IOException {
        System.out.println("-------" +
                " Je suis le microservice CONSUMER du RabbitMq, j'ai reçu le fichier excel : "
                + customFile.getFile() +" -------");
        File fileDestination = new File("C:\\Financial_Data_Destination.xlsx");
        Files.write(fileDestination.toPath(), customFile.getBytesFromFile());
    }
}
