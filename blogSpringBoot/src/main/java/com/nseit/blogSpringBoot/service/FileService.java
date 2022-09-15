package com.nseit.blogSpringBoot.service;

import com.nseit.blogSpringBoot.model.File;
import com.nseit.blogSpringBoot.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File uploadFile(File file){
        return fileRepository.save(file);
    }

}
