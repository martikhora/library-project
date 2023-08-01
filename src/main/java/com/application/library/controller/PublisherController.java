package com.application.library.controller;

import com.application.library.dto.PublisherDto;
import com.application.library.entity.Publisher;
import com.application.library.mapper.PublisherMapper;
import com.application.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    @GetMapping("/publishers")
    public List<PublisherDto> findAllPublishers() {
        List<Publisher> publishers = publisherService.findAllPublishers();
        return publisherMapper.convertToPublisherDto(publishers);
    }

    @GetMapping("/publisher/{id}")
    public PublisherDto findPublisher(@PathVariable Long id) {
        Publisher publisher = publisherService.findPublisherById(id);
        return publisherMapper.convertToPublisherDto(publisher);
    }

    @GetMapping("/remove-publisher/{id}")
    public void deletePublisher(@PathVariable Long id){
        publisherService.deletePublisher(id);
    }

    @PostMapping("/save-publisher")
    public PublisherDto savePublisher(PublisherDto publisherDto) {
        Publisher publisher = publisherMapper.convertToPublisher(publisherDto);
        Publisher savedPublisher = publisherService.createPublisher(publisher);
        return publisherMapper.convertToPublisherDto(savedPublisher);
    }

//    @GetMapping("/update-publisher/{id}")
//    public String updatePublisher(@PathVariable Long id, Model model) {
//        Publisher publisher = publisherService.findPublisherById(id);
//        model.addAttribute("publisher", publisher);
//        return "update-publisher";
//    }
//
//    @PostMapping("/save-update-publisher/{id}")
//    public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model) {
//        if (result.hasErrors()){
//            return "update-publisher";
//        }
//        publisherService.updatePublisher(publisher);
//        model.addAttribute("publisher", publisherService.findAllPublishers());
//        return "redirect:/publishers";
//    }
}