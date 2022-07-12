package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.AttachmentDTO;
import com.yawkar.marvelcatalog.service.AttachmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/public/attach")
public class AttachmentsController {

    private final AttachmentsService attachmentsService;

    public AttachmentsController(AttachmentsService attachmentsService) {
        this.attachmentsService = attachmentsService;
    }

    @PutMapping
    public ResponseEntity<Object> attachComicsToHeroes(@Valid @RequestBody AttachmentDTO attachmentDTO) {
        attachmentsService.attachComicsToHeroes(attachmentDTO);
        return ResponseEntity.ok().build();
    }
}
