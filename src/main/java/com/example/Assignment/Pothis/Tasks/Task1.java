package com.example.Assignment.Pothis.Tasks;

import com.example.Assignment.Pothis.BufferArgs;
import com.example.Assignment.Pothis.OutputFunctions;
import com.example.Assignment.Pothis.WikiChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("!tasktwo")
public class Task1 {

    private OutputFunctions outputFunctions;
    private BufferArgs bufferArgs;
    @Autowired
    public Task1(BufferArgs bufferArgs, OutputFunctions outputFunctions) {
        System.out.println("TASK : 1");
        this.bufferArgs = bufferArgs;
        this.outputFunctions = outputFunctions;
    }

    @Scheduled(initialDelay=60000,fixedRate = 60000)
    public void generateReport() {
        System.out.println("Generating report");
        bufferArgs.setCounter(bufferArgs.getCounter()+1);
        List<WikiChangeEvent> snapshot = new ArrayList<>(bufferArgs.getBuffer());
        outputFunctions.DomainReportDisplay(snapshot);
    }
}

