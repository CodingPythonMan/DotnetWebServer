package com.zeus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.zeus.domain.Board;

/*
@CrossOrigin(origins= {"http://localhost:8080", "http://localhost:3000"})
@RepositoryRestResource*/
public interface BoardRepository extends JpaRepository<Board, Long> {

}
