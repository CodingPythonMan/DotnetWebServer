package com.zeus.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.domain.Article;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/articles")
public class ArticleController {
	@GetMapping
	public ResponseEntity<List<Article>> list(){
		log.info("list");
		
		List<Article> articleList = new ArrayList<>();
	
		Article article = new Article();
		article.setBoardNo(1);
		article.setTitle("향수");
		article.setContent("넓은 별 동쪽 끝으로");
		article.setWriter("hongkd");
		article.setRegDate(LocalDateTime.now());
		
		articleList.add(article);
		
		article = new Article();
		article.setBoardNo(2);
		article.setTitle("첫 마음");
		article.setContent("날마다 새로우며 싶어지고 넓어진다");
		article.setWriter("hongkd");
		article.setRegDate(LocalDateTime.now());
		
		articleList.add(article);
		
		ResponseEntity<List<Article>> entity = new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody Article article){
		log.info("register");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@GetMapping("/{articleNo}")
	public ResponseEntity<Article> read(@PathVariable("articleNo") int articleNo){
		log.info("read");
		
		Article article = new Article();
		article.setBoardNo(1);
		article.setTitle("향수");
		article.setContent("넓은 별 동쪽 끝으로");
		article.setWriter("hongkd");
		article.setRegDate(LocalDateTime.now());
		
		ResponseEntity<Article> entity = new ResponseEntity<Article>(article, HttpStatus.OK);
		
		return entity;
	}
	
	@DeleteMapping("/{articleNo}")
	public ResponseEntity<String> remove(@PathVariable("articleNo") int articleNo){
		log.info("remove");
	
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS" , HttpStatus.OK);
		
		return entity;
	}
	
	@PutMapping("/{articleNo}")
	public ResponseEntity<String> modify(@PathVariable("articleNo") int articleNO, @RequestBody Article article){
		log.info("modify");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
}
