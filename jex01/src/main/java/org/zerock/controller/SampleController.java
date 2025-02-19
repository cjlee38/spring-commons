package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @InitBinder
    public void binder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("/basic")
    public void basic() {
        log.info("basic method called");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);

        return "ex01";
    }

    @GetMapping("/ex02bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);

        return "ex02Bean";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo = " + todo);

        return "ex03";
    }
    
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto = " + dto);
        log.info("page = " + page);

        return "/smaple/ex04";
    }


    // json 넘겨주기 (responsbody 영향)
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06(SampleDTO dto) {
        log.info("/ex06 called");

        return dto;
    }

    // json 직접 만들기. 귀찮
    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("/ex07 called");

        String msg = "{\"name\" : \"홍길동\"}";

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }


    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload method called");
    }
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        files.forEach(file -> {
            log.info("----------------------");
            log.info("name = " + file.getOriginalFilename());
            log.info("size = " + file.getSize());
        });
    }
}
