package com.codewithashith.BookArtAPI.controller;

import com.codewithashith.BookArtAPI.model.File;
import com.codewithashith.BookArtAPI.response.APIResponse;
import com.codewithashith.BookArtAPI.response.FileUploadResponse;
import com.codewithashith.BookArtAPI.service.BookService;
import com.codewithashith.BookArtAPI.service.FileService;
import com.codewithashith.BookArtAPI.utils.FileDownloadUtil;
import com.codewithashith.BookArtAPI.utils.FileUploadUtil;
import com.codewithashith.BookArtAPI.utils.ImageUtility;
import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/")
public class FileController {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    private BookService bookService;

    @Autowired
    private FileService fileService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/uploadFile")
    public ResponseEntity<APIResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {
//
//        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
//
//        String filecode = FileUploadUtil.saveFile(fileName, multipartFile, resourceLoader);
//
//        FileDownloadUtil downloadUtil = new FileDownloadUtil();
//        Resource resource = null;
//        try {
//            resource = downloadUtil.getFileAsResource(filecode);
//        } catch (IOException e) {
//            return ResponseEntity.internalServerError().build();
//        }


        File file = new File();
//        file.setLocation(FileUploadUtil.getFilePath(fileName) + "/" + resource.getFilename());
        file.setImage(ImageUtility.compressImage(multipartFile.getBytes()));
        file = fileService.uploadFile(file);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(file);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
