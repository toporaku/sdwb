package com.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para redirigir la raíz (/) hacia el endpoint de categorías (/category).
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToCategory() {
        return "redirect:/category";
    }
}
