package com.example.Assignment.Pothis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class BufferArgs {
    private int delIndex= 0;
    private int counter =  0;
    private final List<WikiChangeEvent> allEvents = new ArrayList<>();
    private final List<WikiChangeEvent> buffer = new CopyOnWriteArrayList<>();
    private Map<Integer,List<WikiChangeEvent>> buffer2 = new HashMap<>();
    private final ObjectMapper mapper = new ObjectMapper();

    public int getDelIndex() {
        return delIndex;
    }

    public void setDelIndex(int delIndex) {
        this.delIndex = delIndex;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public List<WikiChangeEvent> getAllEvents() {
        return allEvents;
    }

    public List<WikiChangeEvent> getBuffer() {
        return buffer;
    }

    public Map<Integer, List<WikiChangeEvent>> getBuffer2() {
        return buffer2;
    }

    public void setBuffer2(Map<Integer, List<WikiChangeEvent>> buffer2) {
        this.buffer2 = buffer2;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
