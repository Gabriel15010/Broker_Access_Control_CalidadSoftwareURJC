package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("admin", "adminpass");
        users.put("user", "userpass");
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "index";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Object username = session.getAttribute("username");
        if (username == null) return "redirect:/";
        model.addAttribute("username", username);
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(HttpSession session, Model model) {
        Object username = session.getAttribute("username");
        if (username == null || !"admin".equals(username)) {
            return "redirect:/dashboard";
        }
        model.addAttribute("username", username);
        return "admin";
    }
}
