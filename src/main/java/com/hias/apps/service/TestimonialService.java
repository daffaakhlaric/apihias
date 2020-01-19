package com.hias.apps.service;

import com.hias.apps.domain.ProductDiscussion;

import com.hias.apps.domain.Testimonial;
import com.hias.apps.dto.ProductDiscussionDto;
import com.hias.apps.repository.DiscussionRepository;

import com.hias.apps.repository.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;



    public Optional<Testimonial> getAllTestimonialById(Long id){
        Optional<Testimonial> result = testimonialRepository.findById(id);

        return result;
    }

    public List<Testimonial> getTestiByUserId(Long id){
        List<Testimonial> result = testimonialRepository.findByUserId(id);

        return result;
    }

    public Page<Testimonial> getAllTestimoni(Pageable pageable){
        Page<Testimonial> result = testimonialRepository.findAll(pageable);

        return result;
    }

    public void insertTestimonial(Long userId, Long rating, String comment){
        testimonialRepository.insertDiscussion(userId, rating, comment);

    }
}
