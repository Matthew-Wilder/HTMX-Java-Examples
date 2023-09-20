package com.mattmattica.controllers;

import com.mattmattica.entities.Person;
import com.mattmattica.repositories.PersonRepository;
import com.mattmattica.repositories.PizzaRepository;
import com.mattmattica.repositories.PizzeriaRepository;
import com.mattmattica.utils.CollectionUtility;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@AllArgsConstructor
@Controller
public class PizzaOrderFormController {
    private PersonRepository personRepository;
    private PizzaRepository pizzaRepository;
    private PizzeriaRepository pizzeriaRepository;


    // HTML Form
    @GetMapping("/order")
    public String getOrderForm(Model model) {
        List<Person> people = CollectionUtility.listOf(personRepository.findAll());
        model.addAttribute("people", people);
        return "people/form/form-v1";
    }

    // HTMX OOB Change Handler
    @HxRequest
    @GetMapping("/order/changePerson")
    public HtmxResponse handlePersonChange(Model model, @RequestParam("personId") Integer personId) {
        Person p = personRepository.findById(personId).get();
        model.addAttribute("eats", p.getPizzasEaten());
        model.addAttribute("frequents", p.getFrequentedPizzerias());
        HtmxResponse htmx = new HtmxResponse();
        htmx.addTemplate("people/form/form-v1 :: eats");
        htmx.addTemplate("people/form/form-v1 :: frequents");
        return htmx;
    }

    // HTML Form
    @HxRequest
    @PostMapping("/order")
    public String postOrderForm(Model model, @RequestParam Integer personId, @RequestParam Integer pizzaId, @RequestParam Integer pizzeriaId) {
        System.out.printf(
                "%s ordered a %s pizza from %s%n",
                personRepository.findById(personId).get().getName(),
                pizzaRepository.findById(pizzaId).get().getName(),
                pizzeriaRepository.findById(pizzeriaId).get().getName()
        );
        List<Person> people = CollectionUtility.listOf(personRepository.findAll());
        model.addAttribute("people", people);
        return "people/form/form-v1 :: form";
    }
}
