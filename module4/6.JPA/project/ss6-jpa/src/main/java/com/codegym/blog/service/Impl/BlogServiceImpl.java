package com.codegym.blog.service.Impl;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.BlogForm;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Value("${upload_path}")
    String filePath;

    @Override
    public List<Blog> findAll() {
        List<Blog> blogListFromRepository = blogRepository.findAll();
        List<Blog> blogList = new ArrayList<>();
        Stack<Blog> reverseBlogList = new Stack<>();
        for (Blog blog : blogListFromRepository) {
            reverseBlogList.push(blog);
        }
        while (!reverseBlogList.isEmpty()) {
            blogList.add(reverseBlogList.pop());
        }
        return blogList;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(BlogForm blogForm) {
        Blog blogToSave = null;
        if (blogForm.getId() == null) {
            MultipartFile fileToUpload = null;
            String fileName = null;
            if (!blogForm.getImageFile().isEmpty()) {
                fileToUpload = blogForm.getImageFile();
                fileName = fileToUpload.getOriginalFilename();
                try {
                    FileCopyUtils.copy(fileToUpload.getBytes(), new File(filePath + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            Date currentDate = new Date();
            SimpleDateFormat pattern = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            try {
                currentDate = pattern.parse(pattern.format(currentDate));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            blogToSave = new Blog(blogForm.getTitle(), blogForm.getContent(), fileName, currentDate);
            blogRepository.save(blogToSave);
        } else {
            blogToSave = blogRepository.findById(blogForm.getId());
            blogToSave.setTitle(blogForm.getTitle());
            blogToSave.setContent(blogForm.getContent());
            if (!blogForm.getImageFile().isEmpty()) {
                MultipartFile fileToUpload = blogForm.getImageFile();
                String fileName = fileToUpload.getOriginalFilename();
                try {
                    FileCopyUtils.copy(fileToUpload.getBytes(), new File(filePath + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                blogToSave.setImagePath(fileName);
            }
            blogRepository.save(blogToSave);
        }
    }

    @Override
    public void delete(Integer id) {
        blogRepository.delete(id);
    }
}
