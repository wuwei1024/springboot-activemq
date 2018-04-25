package com.test.controller;

import com.test.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class JmsController {
    @Autowired
    JmsService jmsService;

    @RequestMapping("/sendQueue")
    public String sendQueue(@RequestParam("msg") String msg) {
        return jmsService.sendQueue(msg);
    }

    @RequestMapping("/sendTopic")
    public String sendTopic(@RequestParam("msg") String msg) {
        return jmsService.sendTopic(msg);
    }
}
