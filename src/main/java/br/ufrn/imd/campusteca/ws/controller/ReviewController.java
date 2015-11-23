package br.ufrn.imd.campusteca.ws.controller;

import java.util.List;

import br.ufrn.imd.campusteca.ws.dao.ReviewDAO;
import br.ufrn.imd.campusteca.ws.model.Review;

public class ReviewController {
	public boolean create(Review review) {
		return ReviewDAO.getInstance().create(review);
	}
	
	public List<Review> list() {
		return ReviewDAO.getInstance().list();
	}
}
