package com.app.webspringklinik.controller;

import com.app.webspringklinik.entity.Pendaftaran;
import com.app.webspringklinik.service.DokterService;
import com.app.webspringklinik.service.PasienService;
import com.app.webspringklinik.service.PendaftaranService;
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
@RequestMapping("/pendaftaran")
public class PendaftaranController {
    @Autowired
    private PendaftaranService service;

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
        List<Pendaftaran> list = service.get();
        return new ModelAndView("pendaftaran/index","pendaftarans",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dokters",dokterService.get());
        model.addAttribute("pasiens",pasienService.get());
        return "pendaftaran/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Pendaftaran data) {
        service.save(data);
        return "redirect:/pendaftaran";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Pendaftaran data = service.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("dokters",dokterService.get());
        model.addAttribute("pasiens",pasienService.get());
        return "pendaftaran/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/pendaftaran";
    }
}
