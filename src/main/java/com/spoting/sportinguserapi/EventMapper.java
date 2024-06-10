package com.spoting.sportinguserapi;

import com.spoting.sportinguserapi.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@Component
@Slf4j
@AllArgsConstructor
public class EventMapper {

    public SseEmitter.SseEventBuilder toSseEventBuilder(EventDto event) {
        return SseEmitter.event()
                .id(RandomStringUtils.randomAlphanumeric(12))
                .name(event.getType())
                .data(event.getBody());
    }
}
