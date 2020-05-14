package org.homework.fileshare.Controllers;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.homework.fileshare.Entities.FileEntity;
import org.homework.fileshare.Repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@RestController
public class FileController {

    @Autowired
    private FileRepository repo;

    private List<FileEntity> getTree(FileEntity root) {
        List<FileEntity> tree = new ArrayList<>();

        for (FileEntity child : repo.findByParent(root)) {
            tree.add(child);

            if (repo.findByParent(child).size() > 0) {
                tree.addAll(getTree(child));
            }
        }
        return tree;
    }

    @GetMapping(value = "/files")
    public ModelAndView showAllFiles(ModelAndView model) {
        FileEntity root = repo.findById(1);

        List<FileEntity> files = new ArrayList<>();
        files.add(root);
        files.addAll(getTree(root));
        model.addObject("files", files);
        model.setViewName("listFiles");

        return model;
    }

    @GetMapping(value = "/deleteFile/{id}")
    public void deleteFile(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
        repo.deleteById(id);
        response.sendRedirect("/files");
    }

    @GetMapping(value = "/addFile/{id}")
    public void addFile(@PathVariable("id") Integer id, @RequestParam("name") String name, HttpServletResponse response) throws IOException {
        FileEntity file = new FileEntity(name);
        repo.findById(id).get().addChild(file);
        repo.save(file);
        response.sendRedirect("/files");
    }
}