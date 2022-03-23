package com.xxxx.miniodemo.controller;

import com.xxxx.miniodemo.util.MinioUtils;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    MinioUtils minioUtils;


    @GetMapping("/index")
    public String index() throws Exception {
        Boolean file = minioUtils.bucketExists("file");
        System.out.println(file);
        return "index";

    }

    @GetMapping("/all")
    public String getAllBuckets() throws Exception {
        List<Bucket> allBuckets = minioUtils.getAllBuckets();
        System.out.println(allBuckets);
        return "1111";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file, @RequestParam(value = "bucketName") String bucketName) {
        /*if (StringUtils.isBlank(bucketName)) {
            return Result.fail("存储bucket名称为空，无法上传");
        }
        if (!minioUtils.upload(file, bucketName)) {
            log.error("文件上传异常");
            return Result.fail("文件上传异常");
        }
        return Result.success("文件上传成功");*/
        Boolean upload = minioUtils.upload(file, bucketName);
        System.out.println(upload);
        return "123";
    }


}
