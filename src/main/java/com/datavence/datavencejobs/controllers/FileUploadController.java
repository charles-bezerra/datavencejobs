package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.exceptions.StorageFileNotFoundException;
import com.datavence.datavencejobs.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Value("${app.domain}")
    public String domain;

    @Autowired
    StorageService storageService;

    @GetMapping("")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files",
            storageService
                .loadAll()
                .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString()).build().toUri().toString() )
                .collect(Collectors.toList())
        );

        return "uploadForm";
    }

    @GetMapping("/{filename:.+}")
    public @ResponseBody ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);

        return ResponseEntity
            .ok()
            .header(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\""
            )
            .body(file);
    }

    @PostMapping("")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        String filename = storageService.store(file);

        redirectAttributes.addFlashAttribute(
            "message",
            "You successfully uploaded "+filename+"!"
        );

        return String.format("%s/file/%s", this.domain, filename);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
