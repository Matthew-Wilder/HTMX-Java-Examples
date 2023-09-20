package com.mattmattica.controllers;

import com.mattmattica.entities.Person;
import com.mattmattica.repositories.PersonRepository;
import com.mattmattica.utils.CollectionUtility;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Controller
public class PersonController {

    private PersonRepository personRepository;

    // Single target
    @GetMapping("/people/v1/summary")
    public String getPeople(Model model) {
        List<Person> people = CollectionUtility.listOf(personRepository.findAll());
        model.addAttribute("people", people);
        return "people/summary/people-v1";
    }

    @GetMapping("/person/v1/{id}")
    public String getEats(Model model, @PathVariable("id") Integer personId) {
        Person p = personRepository.findById(personId).get();
        model.addAttribute("eats", p.getPizzasEaten());
        model.addAttribute("frequents", p.getFrequentedPizzerias());
        return "people/summary/people-v1 :: eats";
    }


    // Expand the target
    @GetMapping("/people/v2/summary")
    public String getPeople2(Model model) {
        List<Person> people = CollectionUtility.listOf(personRepository.findAll());
        model.addAttribute("people", people);
        return "people/summary/people-v2";
    }

    @GetMapping("/person/v2/{id}")
    public String getEats2(Model model, @PathVariable("id") Integer personId) {
        List<Person> people = CollectionUtility.listOf(personRepository.findAll());
        Person p = personRepository.findById(personId).get();
        model.addAttribute("people", people);
        model.addAttribute("eats", p.getPizzasEaten());
        model.addAttribute("frequents", p.getFrequentedPizzerias());
        return "people/summary/people-v2 :: mainDataRow";
    }


    // Out of band responses
    @GetMapping("/people/v3/summary")
    public String getPeople3(Model model) {
        List<Person> people = CollectionUtility.listOf(personRepository.findAll());
        model.addAttribute("people", people);
        return "people/summary/people-v3";
    }

    @HxRequest
    @GetMapping("/person/v3/{id}")
    public HtmxResponse getEats3(Model model, @PathVariable("id") Integer personId) {
        Person p = personRepository.findById(personId).get();
        model.addAttribute("eats", p.getPizzasEaten());
        model.addAttribute("frequents", p.getFrequentedPizzerias());
        HtmxResponse htmx = new HtmxResponse();
        htmx.addTemplate("people/summary/people-v3 :: foo");
        htmx.addTemplate("people/summary/people-v3 :: bar");
        return htmx;
    }
}
