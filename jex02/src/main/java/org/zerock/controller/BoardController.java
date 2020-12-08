package org.zerock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("board list ... ");
        model.addAttribute("list", service.getList());

    }

    /**
     * 게시글 작성
     *
     * @param board
     * @param rttr
     * @return (redirection) board/list
     */
    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {
        log.info("register = " + board);

        service.register(board);

        rttr.addFlashAttribute("result", board.getBno());

        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(Model model, @RequestParam("bno") Long bno) {
        log.info("get = " + bno);

        model.addAttribute("board", service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr) {
        if (service.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
        if (service.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }
}
