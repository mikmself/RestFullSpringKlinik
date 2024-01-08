package com.app.webspringklinik.controller;

import com.app.webspringklinik.entity.Pasien;
import com.app.webspringklinik.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pasien")
public class PasienController {
    @Autowired
    private PasienService service;

    @GetMapping("")
    public ModelAndView get() {
        List<Pasien> list = service.get();
        return new ModelAndView("pasien/index","pasiens",list);
    }

    @GetMapping("/create")
    public String create() {
        return "pasien/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Pasien data) {
        service.save(data);
        return "redirect:/pasien";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Pasien data = service.getById(id);
        model.addAttribute("data", data);
        return "pasien/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/pasien";
    }
}
