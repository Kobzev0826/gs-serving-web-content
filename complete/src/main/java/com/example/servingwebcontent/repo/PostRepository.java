package com.example.servingwebcontent.repo;

import com.example.servingwebcontent.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository <Post,Long> { // <Name,format of Id>
}
