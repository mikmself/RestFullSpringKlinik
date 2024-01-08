package com.app.webspringklinik.controller;

import com.app.webspringklinik.entity.Obat;
import com.app.webspringklinik.service.DokterService;
import com.app.webspringklinik.service.ObatService;
import com.app.webspringklinik.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/obat")
public class ObatController {
    @Autowired
    private ObatService service;

    @Autowired
    private DokterService dokterService;

    @Autowired
    private PasienService pasienService;

    @GetMapping("")
    public ModelAndView get() {
        List<Obat> list = service.get();
        return new ModelAndView("obat/index","obats",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dokters",dokterService.get());
        model.addAttribute("pasiens",pasienService.get());
        return "obat/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Obat data) {
        service.save(data);
        return "redirect:/obat";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Obat data = service.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("dokters",dokterService.get());
        model.addAttribute("pasiens",pasienService.get());
        return "obat/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/obat";
    }
}
