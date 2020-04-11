package com.example.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.soap.wsdl.AddMovieRequest;
import com.example.soap.wsdl.AddMovieResponse;
import com.example.soap.wsdl.DeleteMovieRequest;
import com.example.soap.wsdl.DeleteMovieResponse;
import com.example.soap.wsdl.GetAllMoviesRequest;
import com.example.soap.wsdl.GetAllMoviesResponse;
import com.example.soap.wsdl.GetMovieByIdRequest;
import com.example.soap.wsdl.GetMovieByIdResponse;
import com.example.soap.wsdl.UpdateMovieRequest;
import com.example.soap.wsdl.UpdateMovieResponse;

public class MovieClient extends WebServiceGatewaySupport {
	
	public GetMovieByIdResponse getMovieById(long id) {
		GetMovieByIdRequest request = new GetMovieByIdRequest();
		request.setMovieId(id);
		
		GetMovieByIdResponse response = (GetMovieByIdResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/movies", request, new SoapActionCallback("http://www.example.soap.com/movies-ws/getMovieByIdRequest"));
		
		return response;
	}
	
	public GetAllMoviesResponse getAllMovies() {
		GetAllMoviesRequest request = new GetAllMoviesRequest();
		
		GetAllMoviesResponse response = (GetAllMoviesResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/movies", request, new SoapActionCallback("http://www.example.soap.com/movies-ws/getAllMoviesRequest"));
		
		return response;
	}
	
	public AddMovieResponse addMovie(String title, String category) {
		AddMovieRequest request = new AddMovieRequest();
		request.setTitle(title);
		request.setCategory(category);
		
		AddMovieResponse response = (AddMovieResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/movies", request, new SoapActionCallback("http://www.example.soap.com/movies-ws/addMovieRequest"));
		
		return response;
	}
	
	public UpdateMovieResponse updateMovie(String title, String category) {
		UpdateMovieRequest request = new UpdateMovieRequest();
		request.setTitle(title);
		request.setCategory(category);
		
		UpdateMovieResponse response = (UpdateMovieResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/movies", request, new SoapActionCallback("http://www.example.soap.com/movies-ws/updateMovieRequest"));
		
		return response;
	}
	
	public DeleteMovieResponse deleteMovie(long id) {
		DeleteMovieRequest request = new DeleteMovieRequest();
		request.setMovieId(id);
		
		DeleteMovieResponse response = (DeleteMovieResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/movies", request, new SoapActionCallback("http://www.example.soap.com/movies-ws/deleteMovieRequest"));
		
		return response;
	}

}
