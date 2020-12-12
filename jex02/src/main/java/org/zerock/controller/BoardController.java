package org.zerock.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

@Controller
@Log4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final private BoardService service;

    @GetMapping("/list")
    public void list(Criteria criteria, Model model) {
        log.info("board list ... ");

        model.addAttribute("list", service.getList(criteria));

    }

    /**
     * 게시글 작성 폼으로 이동
     */
    @GetMapping("/register")
    public void register() {
        log.info("register button clicked!");
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

    @GetMapping({"/get", "/modify"})
    public void get(Model model, @RequestParam("bno") Long bno) {
        BoardVO board = service.get(bno);
        log.info("get or modify in controller " + board);
        model.addAttribute("board", board);
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, RedirectAttributes rttr) {
        log.info("modify-post in controller = " + board);
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
