package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm( @Valid @ModelAttribute User user, Errors errors,Model model, String verify) {
        if (errors.hasErrors() || !user.getPassword().equals(verify)) {
           return "user/add";
        } else {
            return "user/index";
        }

    }


}
