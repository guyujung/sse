package com.spoting.sportinguserapi.controller;

import com.spoting.sportinguserapi.dto.EventDto;
import com.spoting.sportinguserapi.service.EmitterService;
import com.spoting.sportinguserapi.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@Slf4j
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    public static final String MEMBER_ID_HEADER = "MemberId";

    private final EmitterService emitterService;
    private final NotificationService notificationService;

    @GetMapping( produces = "text/event-stream")
    public SseEmitter subscribeToEvents(@RequestParam(name = MEMBER_ID_HEADER) Long memberId) {
        log.debug("Subscribing member with id {}", memberId);
        log.info("구독");
        return emitterService.createEmitter(memberId);
    }

    @PostMapping( produces = "text/event-stream")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void publishEvent(@RequestParam(name = MEMBER_ID_HEADER) Long memberId, @RequestBody EventDto event) {
       System.out.println("hello");

        log.info("발행");
        notificationService.sendNotification(memberId, event);
    }

}
