package com.app.webspringklinik.controller;

import com.app.webspringklinik.entity.JadwalPraktek;
import com.app.webspringklinik.service.DokterService;
import com.app.webspringklinik.service.JadwalPrakterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jadwal-praktek")
public class JadwalPraktekController {
    @Autowired
    private JadwalPrakterService service;

    @Autowired
    private DokterService dokterService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("")
    public ModelAndView get() {
        List<JadwalPraktek> list = service.get();
        return new ModelAndView("jadwalpraktek/index","jadwalprakteks",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dokters",dokterService.get());
        return "jadwalpraktek/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute JadwalPraktek data) {
        service.save(data);
        return "redirect:/jadwal-praktek";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        JadwalPraktek data = service.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("dokters",dokterService.get());
        return "jadwalpraktek/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/jadwal-praktek";
    }
}
