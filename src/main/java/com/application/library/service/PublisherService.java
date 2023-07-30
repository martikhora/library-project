package com.application.library.service;

import com.application.library.entity.Publisher;
import com.application.library.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPublishers() { //getting all publishers
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long id) {//getting a specific publisher from repository
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("No such publisher found"));
    }

    public Publisher createPublisher(Publisher publisher) { //adding a new publisher
        publisherRepository.save(publisher);
        return publisher;
    }

    public void deletePublisher(Long id) { //removing publisher
        Publisher author = publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("No such author found"));
        publisherRepository.deleteById(author.getId());
    }

    public void updatePublisher(Publisher publisher) { //updating publisher
        publisherRepository.save(publisher);
    }
}
