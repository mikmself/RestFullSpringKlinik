package com.app.webspringklinik.controller;

import com.app.webspringklinik.entity.Dokter;
import com.app.webspringklinik.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dokter")
public class DokterController {

    @Autowired
    private DokterService service;

    @GetMapping("")
    public ModelAndView get() {
        List<Dokter> list = service.get();
        return new ModelAndView("dokter/index","dokters",list);
    }

    @GetMapping("/create")
    public String create() {
        return "dokter/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Dokter data) {
        service.save(data);
        return "redirect:/dokter";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Dokter data = service.getById(id);
        model.addAttribute("data", data);
        return "dokter/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/dokter";
    }
}
