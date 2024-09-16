package com.example.apis.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
public class FileUploadController {

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/uploadArquivo")
    public String upload() { 
        return "uploadArquivo";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Por favor, selecione um arquivo para fazer upload.");
            return "redirect:/";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadPath + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "Upload realizado com sucesso: " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/downloadArquivo";
    }
}
