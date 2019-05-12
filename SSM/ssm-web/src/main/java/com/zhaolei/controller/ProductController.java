package com.zhaolei.controller;

import com.zhaolei.domain.Product;
import com.zhaolei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * SSM
 * 2019-05-07 19:06
 *
 * @author leonzhao
 **/

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteByIds.do")
        public String deleteByIds(String[] ids) throws Exception{
            productService.deleteByIds(ids) ;
            return "redirect:findAll.do";
        }

}
