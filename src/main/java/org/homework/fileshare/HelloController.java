package org.homework.fileshare;

import org.homework.fileshare.Entities.FileEntity;
import org.homework.fileshare.Repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    FileRepository fp;

    @GetMapping("/api/hello")
    public String hello() {
        List<FileEntity> all = fp.findAll();
        String names = "";
        for (FileEntity fe : all) {
            names += fe.name += "     ";
        }
//        return "Hello, the time at the server is now " + new Date() + "\n";
        return names;
    }
}