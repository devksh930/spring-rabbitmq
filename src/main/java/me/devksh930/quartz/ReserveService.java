package me.devksh930.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.devksh930.domain.ReserevePostRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReserveService {
    private final ReserevePostRepository resrevePostRepository;
    private final RabbitTemplate rabbitTemplate;

    private Integer a = 0;

    //    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void Test() {
        log.info("매시간 10분마다 호출");
        rabbitTemplate.convertAndSend("spring-boot-exchange", "me.devksh930.test", "Hello "+ LocalDateTime.now());
    }
}
