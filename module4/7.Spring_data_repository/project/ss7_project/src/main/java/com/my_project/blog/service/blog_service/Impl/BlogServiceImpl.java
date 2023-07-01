package com.my_project.blog.service.blog_service.Impl;

import com.my_project.blog.entity.Blog;
import com.my_project.blog.entity.BlogForm;
import com.my_project.blog.entity.Category;
import com.my_project.blog.repository.blog_repository.BlogRepository;
import com.my_project.blog.service.blog_service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Value("${upload_path}")
    String filePath;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitle(Pageable pageable,String title) {
        return blogRepository.findAllByTitleContaining(pageable,title);
    }

    @Override
    public Page<Blog> findAllByCategory(Pageable pageable, Long id) {
        Category categoryToFind = new Category(id);
        return blogRepository.findAllByCategory(pageable,categoryToFind);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void save(BlogForm form) {
        Blog blogToSave;
        if (form.getId() == null) {
            blogToSave = new Blog();
            blogToSave.setTitle(form.getTitle());
            blogToSave.setContent(form.getContent());

            Date currentDate = new Date();
            SimpleDateFormat pattern = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            try {
                currentDate = pattern.parse(pattern.format(currentDate));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            blogToSave.setPostDate(currentDate);


            MultipartFile fileToUpload = null;
            String fileName = null;
            if (!form.getImageFile().isEmpty()) {
                fileToUpload=form.getImageFile();
                fileName = fileToUpload.getOriginalFilename();
                try {
                    FileCopyUtils.copy(fileToUpload.getBytes(), new File(filePath + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            blogToSave.setImagePath(fileName);
        } else {
            blogToSave = blogRepository.findById(form.getId()).get();
            blogToSave.setTitle(form.getTitle());
            blogToSave.setContent(form.getContent());
            if (!form.getImageFile().isEmpty()) {
                MultipartFile fileToUpload = form.getImageFile();
                String fileName = fileToUpload.getOriginalFilename();
                try {
                    FileCopyUtils.copy(fileToUpload.getBytes(), new File(filePath + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                blogToSave.setImagePath(fileName);
            }
            blogToSave.setCategory(form.getCategory());

        }

        blogRepository.save(blogToSave);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }
}
