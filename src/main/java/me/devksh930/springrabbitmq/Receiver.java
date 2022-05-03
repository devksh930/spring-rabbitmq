package me.devksh930.springrabbitmq;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    @Async
    public void receiveMessage(String message) {
        System.out.println("<===== Received : " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
