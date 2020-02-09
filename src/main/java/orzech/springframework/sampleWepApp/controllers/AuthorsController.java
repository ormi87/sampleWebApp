package orzech.springframework.sampleWepApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import orzech.springframework.sampleWepApp.repositories.AuthorRepositories;

@Controller
public class AuthorsController {

    private final AuthorRepositories authorRepositories;

    public AuthorsController(AuthorRepositories authorRepositories) {
        this.authorRepositories = authorRepositories;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepositories.findAll());
        return "authors/list";
    }
}
