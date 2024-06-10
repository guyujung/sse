package com.spoting.sportinguserapi.service;


import com.spoting.sportinguserapi.dto.EventDto;

public interface NotificationService {

    void sendNotification(Long memberId, EventDto event);
}
