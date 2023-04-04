package com.innowise.darya.controller;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Section;

import com.innowise.darya.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/book")
@Log
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping(value = {"/", "/index"})
//    public String index(Model model) {
//        model.addAttribute("title", "Book");
//        return "index";
//    }
//
//    @PostMapping("filter")
//    public String filter( @RequestParam String year, Map<String, Object> model) {
//        Set<AuthorDTO> items = new HashSet<>();
//
//        if (year != null && !year.isEmpty()) {
//            items = bookService.getAuthorByYear(year);
//        }
//
//        if (!items.isEmpty()) {
//            model.put("items", items);
//        }
//        model.put("title", "Books");
//        return "index";
//    }


    @PostMapping("/save")
    @PreAuthorize("hasAuthority('developers:read')")
    public BookDTO saveBook(@RequestBody BookDTO bookDto) {
        log.info("Handling save users: " + bookDto);
        return bookService.saveBook(bookDto);
    }


    @GetMapping("/findAll")
   // @PreAuthorize("hasAuthority('developers:write')")
    @PreAuthorize("permitAll()")
    public List<BookDTO> getAllBooks(){
        log.info("Handling find all users request");
        return bookService.getAllBooks();
    }
//
//    @GetMapping("/getbyid/{id}")
//    public BookDTO getBookById(@PathVariable long id) {
//        log.info("Handling find by id request: " + id);
//        return bookService.getBookById(id);
//    }


    @GetMapping("/getbyid")
    @PreAuthorize("hasAuthority('developers:write')")
    public BookDTO getBookById(@RequestParam Long id) {
        log.info("Handling find by id request: " + id);
        return bookService.getBookById(id);
    }


    //найти всех авторов, которые издавались в этот год
    @GetMapping("/getauthorbyyear/{year}")
    @PreAuthorize("permitAll()")
    public List<AuthorDTO> getAuthorByYear(@RequestParam String year) {
        return bookService.getAuthorByYear(year);
    }



    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public void deleteBook(@PathVariable Long id) {
        log.info("Handling delete user request: " + id);
        bookService.deleteBook(id);
      }

    //в каких секциях лежат книги
    @GetMapping("/getbysection/{section}")
    @PreAuthorize("permitAll()")
    public List<BookDTO> getBooksBySection(@PathVariable Long section){
        return bookService.getBooksBySection(section);
    }

//    @GetMapping(value = {"/", "/index"})
//   public String index(Model model) {
//        model.addAttribute("title", "Book");
//        return "index";
//    }
//
//    @PostMapping("filter")
//    public String filter(@RequestParam Integer year, Map<String, Object> model) {
//        Set<AuthorDTO> author = new HashSet<>();
//
//            author = bookService.getAuthorByYear(year);
//
//            model.put("items", author);
//
//        return "index";
//    }
}