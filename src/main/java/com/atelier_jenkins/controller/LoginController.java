package main.java.com.atelier_jenkins.controller;

import main.java.com.atelier_jenkins.security.SecurityConfig;
import main.java.com.atelier_jenkins.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class LoginController {

    @Autowired
    private ProductService productService;

    //Boolean errors = false;


    // Exo 3 (utiliser que la method get - essayer)
    // MVC : Controller
   /* @PostMapping(path = "/login")
    public String postLogin(@ModelAttribute("products") ProductDto product, Model model) {

        System.out.println("ici ?????####################################");
       // List<Product> products = productService.getProductList();
        //model.addAttribute("ProductList", products);
        // return la page html (La vue)
        return "ProductList";
    }*/

    @RequestMapping("/principal")
    @ResponseStatus(value = HttpStatus.OK)
    public void add()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println(currentUserName);
        }

    }


}
