package br.ufrn.imd.campusteca.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.ufrn.imd.campusteca.ws.controller.ReviewController;
import br.ufrn.imd.campusteca.ws.model.Review;

@Path("/book")
public class ReviewResource {
	@GET
	@Path("/reviews")
	@Produces(MediaType.APPLICATION_JSON)
	public String listReview() {
		Gson gson = new Gson();
		return gson.toJson(new ReviewController().list());
	}
	
	@GET
	@Path("/create/{idbook}/{iduser}/{rating}/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public String createReview(@PathParam("idbook") int idBook, @PathParam("iduser") int idUser, @PathParam("rating") int rating, @PathParam("description") String description) {
		Review review = new Review();
		review.setIdBook(idBook);
		review.setIdUser(idUser);
		review.setRating(rating);
		review.setDescription(description);
		
		if (!new ReviewController().create(review))
			return "(\"status\":\"ok\")";
		else
			return "(\"status\":\"not ok\")";
	}
}
