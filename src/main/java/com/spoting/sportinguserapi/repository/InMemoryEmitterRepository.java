package com.spoting.sportinguserapi.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
@Slf4j
public class InMemoryEmitterRepository implements EmitterRepository {

    private Map<Long, SseEmitter> userEmitterMap = new ConcurrentHashMap<>();

    @Override
    public void addOrReplaceEmitter(Long memberId, SseEmitter emitter) {
        userEmitterMap.put(memberId, emitter);
    }

    @Override
    public void remove(Long memberId) {
        if (userEmitterMap != null && userEmitterMap.containsKey(memberId)) {
            log.debug("Removing emitter for member: {}", memberId);
            userEmitterMap.remove(memberId);
        } else {
            log.debug("No emitter to remove for member: {}", memberId);
        }
    }

    @Override
    public Optional<SseEmitter> get(Long memberId) {
        return Optional.ofNullable(userEmitterMap.get(memberId));
    }
}
