package com.example.soap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.soap.wsdl.AddMovieResponse;
import com.example.soap.wsdl.DeleteMovieResponse;
import com.example.soap.wsdl.GetAllMoviesResponse;
import com.example.soap.wsdl.GetMovieByIdResponse;
import com.example.soap.wsdl.MovieType;
import com.example.soap.wsdl.UpdateMovieResponse;

@SpringBootApplication
public class SoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(MovieClient quoteClient) {
		return args -> {
			long id = 5;
			GetMovieByIdResponse response = quoteClient.getMovieById(id);
			System.out.println("Response #1:");
			System.out.println("Movie id = " + response.getMovieType().getMovieId() + ", title = " + response.getMovieType().getTitle() + ", category = " + response.getMovieType().getCategory());
			
			GetAllMoviesResponse response2 = quoteClient.getAllMovies();
			List<MovieType> listMovieType = response2.getMovieType();
			System.out.println("Response #2:");
			for(MovieType movieType : listMovieType) {
				System.out.println("Movie id = " + movieType.getMovieId() + ", title = " + movieType.getTitle() + ", category = " + movieType.getCategory());
			}
			
			AddMovieResponse response3 = quoteClient.addMovie("Transformers", "action");
			System.out.println("Response #3:");
			System.out.println("Status Code = " + response3.getServiceStatus().getStatusCode() + ", Message = " + response3.getServiceStatus().getMessage());
			System.out.println("Movie id = " + response3.getMovieType().getMovieId() + ", title = " + response3.getMovieType().getTitle() + ", category = " + response3.getMovieType().getCategory());
			
			GetAllMoviesResponse response4 = quoteClient.getAllMovies();
			List<MovieType> listMovieType2 = response4.getMovieType();
			System.out.println("Response #4:");
			for(MovieType movieType : listMovieType2) {
				System.out.println("Movie id = " + movieType.getMovieId() + ", title = " + movieType.getTitle() + ", category = " + movieType.getCategory());
			}
			
			UpdateMovieResponse response5 = quoteClient.updateMovie("Transformers", "action drama");
			System.out.println("Response #5:");
			System.out.println("Status Code = " + response5.getServiceStatus().getStatusCode() + ", Message = " + response5.getServiceStatus().getMessage());
			
			long id2 = response3.getMovieType().getMovieId();
			GetMovieByIdResponse response6 = quoteClient.getMovieById(id2);
			System.out.println("Response #6:");
			System.out.println("Movie id = " + response6.getMovieType().getMovieId() + ", title = " + response6.getMovieType().getTitle() + ", category = " + response6.getMovieType().getCategory());
			
			GetAllMoviesResponse response7 = quoteClient.getAllMovies();
			List<MovieType> listMovieType3 = response7.getMovieType();
			System.out.println("Response #7:");
			for(MovieType movieType : listMovieType3) {
				System.out.println("Movie id = " + movieType.getMovieId() + ", title = " + movieType.getTitle() + ", category = " + movieType.getCategory());
			}
			
			DeleteMovieResponse response8 = quoteClient.deleteMovie(id2);
			System.out.println("Response #8:");
			System.out.println("Status Code = " + response8.getServiceStatus().getStatusCode() + ", Message = " + response8.getServiceStatus().getMessage());
			
			GetAllMoviesResponse response9 = quoteClient.getAllMovies();
			List<MovieType> listMovieType4 = response9.getMovieType();
			System.out.println("Response #9:");
			for(MovieType movieType : listMovieType4) {
				System.out.println("Movie id = " + movieType.getMovieId() + ", title = " + movieType.getTitle() + ", category = " + movieType.getCategory());
			}
			
		};
	}

}
