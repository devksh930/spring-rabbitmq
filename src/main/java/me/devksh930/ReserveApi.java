package me.devksh930;

import lombok.RequiredArgsConstructor;
import me.devksh930.domain.ReserevePostRepository;
import me.devksh930.domain.ReservePost;
import me.devksh930.quartz.ReserveService;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/reserve")
@RequiredArgsConstructor
@EnableAsync
public class ReserveApi {

    private final ReserevePostRepository repository;

    private final ReserveService reserveService;



    @PostMapping("/test/{name}")
    public ReservePost reserve(@PathVariable("name") String name) {
        LocalDateTime now = LocalDateTime.now();
        ReservePost reserve = new ReservePost(name, LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), 20));
        ReservePost save = repository.save(reserve);
        reserveService.Test();
        return save;
    }

}
