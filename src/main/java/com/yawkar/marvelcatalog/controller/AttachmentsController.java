package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.AttachmentDTO;
import com.yawkar.marvelcatalog.service.AttachmentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Attachment controller", description = "Contains one PUT method for connecting/joining comics and heroes")
@RestController
@RequestMapping("/v1/public/attach")
public class AttachmentsController {

    private final AttachmentsService attachmentsService;

    public AttachmentsController(AttachmentsService attachmentsService) {
        this.attachmentsService = attachmentsService;
    }

    @Operation(
            summary = "Attaches heroes to comics",
            description = "Adds connections between heroes and comics"
    )
    @ApiResponses(
            {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successfully updated connections"

                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Some ids don't exist in catalog"
                )
            }
    )
    @PutMapping
    public ResponseEntity<Void> attachComicsToHeroes(@Valid @RequestBody AttachmentDTO attachmentDTO) {
        attachmentsService.attachComicsToHeroes(attachmentDTO);
        return ResponseEntity.ok().build();
    }
}
