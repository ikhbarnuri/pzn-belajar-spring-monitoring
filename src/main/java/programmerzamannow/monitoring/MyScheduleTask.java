package programmerzamannow.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MyScheduleTask {

    @Autowired
    private MeterRegistry meterRegistry;

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void hello() {
        meterRegistry.counter("my.scheduled.task").increment();
        System.out.println("Hello Woeld!");
    }
}
