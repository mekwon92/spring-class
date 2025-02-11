package com.me92100984.di.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.me92100984.di.vo.Post;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("gallery") //지정하지않을시 postServiceImplGallery로 만듬(앞글자 소문자)
public class PostServiceImplGallery implements PostService{

    @Override
    public List<Post> list() {
        List<Post> list = new ArrayList<>();
        list.add(Post.builder().pno(3L).title("갤러리게시판제목").writer("작성자").build());
        list.add(Post.builder().pno(4L).title("갤러리게시판제목").writer("작성자").build());
        return list;
    }

    @Override
    public void write(Post post) {
        log.info(getClass().getSimpleName()+".write() call");        
    }
    

    
}
