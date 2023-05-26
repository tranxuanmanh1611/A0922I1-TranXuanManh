package codegym.vn.controller;

import codegym.vn.entity.Product;
import codegym.vn.repository.CategoryRepository;
import codegym.vn.repository.ProductRepository;
import javafx.scene.control.ProgressIndicatorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product/create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("product") Product product) {
        product.setCategory(categoryRepository.findById(product.getCategory().getCategoryId()));
        productRepository.create(product);
        return "redirect:/product/list";
    }
}
