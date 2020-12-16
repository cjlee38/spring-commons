package org.cjlee.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.cjlee.service.ReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/replies")
@RestController
@Log4j
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService service;
}
