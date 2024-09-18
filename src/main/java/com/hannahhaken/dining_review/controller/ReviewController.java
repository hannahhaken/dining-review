package com.hannahhaken.dining_review.controller;

import com.hannahhaken.dining_review.dto.AdminReviewAction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

//    dining-revises.com/api/review/{dining-review-id}/admin-review
//    dining-revises.com/api/review/4455654/admin-review
//    POST/review
//    { isApproved:true }

    @GetMapping
    public String getReview() {
        return "Hello Hannah";
    }

//    @PostMapping
//    public void create(@RequestBody Review review) {
//
//    }

    @PostMapping("/adminreview")
    public void approveReview(@RequestBody AdminReviewAction adminReviewAction) {
        System.out.println(adminReviewAction);
//        Get the Review from the database via a Repository using the ID of the review
        /*
            Review review = reviewRepository.getById(adminReviewAction.getReviewId());
            review.setApproval(adminReviewAction.getApproval());
            reviewRepository.save(review);
         */
//        Set the admin approval on the Review to true or false, as provided through the API
//        Save/Persist the Review back into the database, with the approval, using the Repository.
    }
}
