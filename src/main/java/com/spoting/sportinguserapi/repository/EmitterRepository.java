package com.spoting.sportinguserapi.repository;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Optional;

public interface EmitterRepository {

    void addOrReplaceEmitter(Long memberId, SseEmitter emitter);

    void remove(Long memberId);

    Optional<SseEmitter> get(Long memberId);
}
