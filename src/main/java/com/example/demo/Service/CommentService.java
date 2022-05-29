package com.example.demo.Service;

import com.example.demo.Modele.Comment;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CommentService {
    private ArrayList<Comment> comments = new ArrayList<>();

    public ArrayList<Comment> getComment()
    {
        return comments;
    }
}