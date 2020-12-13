package org.cjlee.controller;

import lombok.extern.log4j.Log4j;
import org.cjlee.domain.SampleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getText() {
        log.info("Mime type : " + MediaType.TEXT_PLAIN_VALUE);

        return "안녕하세요, Hello RestController";
    }

    @GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample() {
        return new SampleVO(112, "스타", "로드");
    }

    @GetMapping("/getSample2") // 이렇게써도 getSample이랑 같은 기능이 가능
    public SampleVO getSample2() {
        return new SampleVO(113, "로켓", "라쿤");
    }

    @GetMapping("/getList")
    public List<SampleVO> getList() {
        return IntStream.range(1, 10)
                .mapToObj(i -> new SampleVO(i, i+" First", i+" Last"))
                .collect(Collectors.toList());
    }
}
