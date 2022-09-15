package com.nseit.blogSpringBoot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse extends APIResponse {
    private String fileName;
    private String downloadUri;
    private long size;
}
