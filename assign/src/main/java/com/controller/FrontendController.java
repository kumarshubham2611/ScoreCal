package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.entity.SATResult;
import com.repository.SATResultRepository;

import java.util.Optional;

@RestController
public class FrontendController {

    private final SATResultRepository repository;

    @Autowired
    public FrontendController(SATResultRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String redirectToIndex() {
        return "redirect:/index.jsp";
    }

    @PostMapping("/insert")
    public String insertData(@RequestParam String name, @RequestParam String address, @RequestParam String city,
                             @RequestParam String country, @RequestParam String pincode, @RequestParam int score) {
        boolean passed = score > 0.3 * 1600; // Assuming the maximum SAT score is 1600

        SATResult satResult = new SATResult();
        satResult.setName(name);
        satResult.setAddress(address);
        satResult.setCity(city);
        satResult.setCountry(country);
        satResult.setPincode(pincode);
        satResult.setScore(score);
        satResult.setPassed(passed);

        repository.save(satResult);

        return "redirect:/view";
    }

    @GetMapping("/view")
    public String viewAllData(Model model) {
        Iterable<SATResult> results = repository.findAll();
        model.addAttribute("results", results);

        return "view";
    }

    @GetMapping("/getRank")
    public String getRank(@RequestParam String name, Model model) {
        SATResult result = repository.findByName(name);
        if (result != null) {
            // Perform rank calculation logic based on your requirements
            // ...
            model.addAttribute("rank", "<rank>");
        }

        return "getRank";
    }

    @PostMapping("/update")
    public String updateScore(@RequestParam String name, @RequestParam int score) {
        SATResult result = repository.findByName(name);
        if (result != null) {
            result.setScore(score);
            result.setPassed(score > 0.3 * 1600); // Assuming the maximum SAT score is 1600
            repository.save(result);
        }

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteRecord(@RequestParam String name) {
        SATResult result = repository.findByName(name);
        if (result != null) {
            repository.delete(result);
        }

        return "redirect:/";
    }
}

