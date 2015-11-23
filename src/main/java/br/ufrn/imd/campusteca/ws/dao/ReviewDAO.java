package br.ufrn.imd.campusteca.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.campusteca.ws.factory.ConnectionFactory;
import br.ufrn.imd.campusteca.ws.model.Review;

public class ReviewDAO extends ConnectionFactory {
	private static ReviewDAO instance;

	public static ReviewDAO getInstance() {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}
	
	public boolean create(Review review) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean hasErrors = false;
		
		connection = openConnection();
		
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO review (idbook, iduser, rating, description) VALUES(?, ?, ?, ?)");
			
			preparedStatement.setInt(1, review.getIdBook());
			preparedStatement.setInt(2, review.getIdUser());
			preparedStatement.setInt(3, review.getRating());
			preparedStatement.setString(4, review.getDescription());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			hasErrors = true;
		} finally {
			closeConnection(connection, preparedStatement);
		}
		
		return hasErrors;
	}

	public List<Review> list() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Review> reviews = null;

		connection = openConnection();
		reviews = new ArrayList<Review>();

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM review ORDER BY description");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Review review = new Review();
				
				review.setIdReview(resultSet.getInt("idreview"));
				review.setIdBook(resultSet.getInt("idbook"));
				review.setIdUser(resultSet.getInt("iduser"));
				review.setRating(resultSet.getInt("rating"));
				review.setDescription(resultSet.getString("description"));

				reviews.add(review);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, preparedStatement, resultSet);
		}
		
		return reviews;
	}
}
