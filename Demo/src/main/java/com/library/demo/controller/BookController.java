package com.library.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.model.Book;

@RestController
public class BookController {
	
	private HashMap<Integer, Book> hashBook = new HashMap<Integer, Book>();
	
	private static Logger logger = LoggerFactory.getLogger(BookController.class);

	//saveBook
	//getSomeBook
	//getAllBook
	//deleteSomeBook
	//updateSomeBook
	
	@PostMapping("/save")
	public ResponseEntity saveBook(@RequestBody Book bookObj){
		
		if(hashBook.containsKey(bookObj.getId())) {
			logger.error("Already exist");
			
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		hashBook.put(bookObj.getId(), bookObj);
		logger.info("Inserted Book Successfully");
		
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/books/id")
	public Book getSomeBook(@RequestParam int id) {
		logger.info("Book Returned with id : {}", id);
		
		return hashBook.get(id);		
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		
		return hashBook.values()
				.stream().collect(Collectors.toList());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteSomeBook(@PathVariable int id) {
		hashBook.remove(id);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@PutMapping("/books/{id}")
	public String updateBook(@RequestBody Book book , @PathVariable int id) {
		hashBook.put(book.getId(), book);
		return "Done updating the record.";
	}
	
	
	
}
