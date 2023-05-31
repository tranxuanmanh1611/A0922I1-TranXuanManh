package thuchanh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thuchanh.entities.product.Product;
import thuchanh.entities.product.ProductForm;
import thuchanh.service.ProductService;
import thuchanh.service.ProductServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "upload/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("productForm",new ProductForm());
        return "upload/form";
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute("productForm") ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/upload/form");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
