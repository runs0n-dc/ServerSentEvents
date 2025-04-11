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
@Profile("tasktwo")
public class Task2 {
    private OutputFunctions outputFunctions;
    private BufferArgs bufferArgs;
    @Autowired
    public Task2(BufferArgs bufferArgs, OutputFunctions outputFunctions) {
        System.out.println("TASK : 2");
        this.bufferArgs = bufferArgs;
        this.outputFunctions = outputFunctions;
    }

    @Scheduled(initialDelay=60000,fixedRate = 60000)
    public void generateReport() {
        bufferArgs.setCounter(bufferArgs.getCounter()+1);
        List<WikiChangeEvent> snapshot = new ArrayList<>(bufferArgs.getBuffer());
        bufferArgs.getBuffer2().put(bufferArgs.getCounter(), snapshot);
        bufferArgs.getBuffer().clear();
        //clear the map if size is greater than five
        if(bufferArgs.getBuffer2().size() > 5) {
            bufferArgs.getBuffer2().remove(bufferArgs.getDelIndex());
            bufferArgs.setDelIndex(bufferArgs.getDelIndex() + 1);
        }
        //combine all the data snapshot in the map
        List<WikiChangeEvent> combinedList = new ArrayList<>();
        for(int c : bufferArgs.getBuffer2().keySet()) {
            combinedList.addAll(bufferArgs.getBuffer2().get(c));
        }
        outputFunctions.DomainReportDisplay(combinedList);
    }
}
