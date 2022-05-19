package com.example.servingwebcontent.contollers;


import com.example.servingwebcontent.models.Post;
import com.example.servingwebcontent.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String BlogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "BlogTest";
    }

    @GetMapping("/blog/{id}")
    public String BlogDetails(@PathVariable(value="id") long id , Model model){
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/add")
    public String BlogAddGet(Model model){
        return "BlogAdd";
    }

    @PostMapping("/blog/add")
    public String BlogAddPost(@RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String full_text,
                              Model model){
        System.out.println(title);
        Post post = new Post(title,anons,full_text); //создание объекта на основе класса
        postRepository.save(post); //добавление в БД
        return "redirect:/blog";
    }


}
