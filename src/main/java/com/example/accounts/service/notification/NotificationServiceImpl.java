package com.example.accounts.service.notification;

import com.example.accounts.model.NotificationModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Value("${notification.service.base}")
    String notificationBaseUrl;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void sendNotification(NotificationModel model) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<NotificationModel> entity = new HttpEntity<>(model, headers);

        Object answer = restTemplate.postForObject(notificationBaseUrl + "/notification", entity, Object.class);
        System.out.println(answer);
    }
}
