package com.customer;
import com.customer.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserCtrl {
    @GetMapping("/user")
    public String login(Model model){
        model.addAttribute("user",new User());
//        System.out.println(username);
//        System.out.println(us2);
        return "login/login";
    }
    @PostMapping("/post")
    public String post(@ModelAttribute User user, HttpServletResponse response, HttpServletRequest request){
        Cookie cookie=new Cookie("username",user.getUsername());
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        Cookie cookie1=new Cookie("us2",user.getUsername());
        cookie1.setMaxAge(100   );
        response.addCookie(cookie1);
        HttpSession session=request.getSession();
        session.setAttribute("username-ss",user.getUsername());
        return "redirect:/customer/home";
    }
    @GetMapping("/logout")
    public String logout(@ModelAttribute User user, HttpServletResponse response, HttpServletRequest request){
//        Cookie[] cookies=request.getCookies();
//        for (Cookie c:cookies)
//            c.setMaxAge(0);
        HttpSession session=request.getSession();
        session.removeAttribute("username-ss");
        return "redirect:/user";
    }
}
