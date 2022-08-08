package com.example.accounts.model;

import com.example.accounts.type.notification.NotificationReason;
import com.example.accounts.type.notification.NotificationSendType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationModel {

    private String email;
    private NotificationSendType sendType;
    private NotificationReason reason;

}