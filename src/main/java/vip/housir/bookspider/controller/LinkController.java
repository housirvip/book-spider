package vip.housir.bookspider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.housir.bookspider.mq.LinkSender;

/**
 * @author housirvip
 */
@RestController
@RequestMapping(value = "/link")
@RequiredArgsConstructor
public class LinkController {

    private final LinkSender linkSender;

    @GetMapping(value = "/add")
    public String add(@RequestParam String link) {

        linkSender.send(link);

        return link;
    }
}
