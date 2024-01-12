package com.desafiobackend.services;

import com.desafiobackend.domain.entities.user.User;
import com.desafiobackend.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${app.notificationApi}")
    private String notificationApiUrl;

    public void sendNotification(User user, String message)throws Exception{
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity(this.notificationApiUrl, notificationRequest,String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            System.out.printf("Erro ao enviar notificação");
            throw new Exception("Serviço de notificação está fora do ar");
        }

        System.out.println("Notificação enviada para o usuario");

    }
}
