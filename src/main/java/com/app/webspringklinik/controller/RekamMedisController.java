package com.app.webspringklinik.controller;

import com.app.webspringklinik.entity.RekamMedis;
import com.app.webspringklinik.service.DokterService;
import com.app.webspringklinik.service.PasienService;
import com.app.webspringklinik.service.RekamMedisService;
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
@RequestMapping("/rekam-medis")
public class RekamMedisController {
    @Autowired
    private RekamMedisService service;

    @Autowired
    private DokterService dokterService;

    @Autowired
    private PasienService pasienService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("")
    public ModelAndView get() {
        List<RekamMedis> list = service.get();
        return new ModelAndView("rekammedis/index","rekammediss",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dokters",dokterService.get());
        model.addAttribute("pasiens",pasienService.get());
        return "rekammedis/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute RekamMedis data) {
        service.save(data);
        return "redirect:/rekam-medis";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        RekamMedis data = service.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("dokters",dokterService.get());
        model.addAttribute("pasiens",pasienService.get());
        return "rekammedis/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/rekam-medis";
    }
}
