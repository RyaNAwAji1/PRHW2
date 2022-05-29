package com.example.demo.Controller;

import com.example.demo.Modele.Comment;
import com.example.demo.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping
    public ResponseEntity<ArrayList<Comment>> getComments(){
        return ResponseEntity.status(200).body((commentService.getComment()));
    }
}