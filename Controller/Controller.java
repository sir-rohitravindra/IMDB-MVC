package Controller;

import View.View;
import View.Movie;
import Model.Model;
import java.awt.event.*;
import java.util.*;

public class Controller {

	Model model;
	View view;
	int width, height;

	public Controller(Model model, View view, int width, int height) {

		this.model = model;
		this.view = view;
		this.width = width;
		this.height = height;

	}

	public void StartApplication() {
		view.enableView(width, height);
		view.addSubmitActionListener(new HandleOnSubmit());
		view.addFetchActionListener(new HandleOnFetch());

		model.connectToDB();
	}

	class HandleOnSubmit implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {

				Movie m = view.getMovieDetails();
				model.insertToDB(m.getName(), m.getRating(), m.getDate());
			} catch (Exception e) {
				System.out.println("Controller.HandleOnSubmit.actionPerformed failed");
			}

		}

	}

	class HandleOnFetch implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {

				view.clearDisplayPanel();
				List<String> fetchedMovies = model.FetchData(view.getQuery());

				for (String entry : fetchedMovies) {
					view.addFetchedData(entry);
				}
			} catch (Exception e) {

				System.out.println("Controller.HandleOnFetch.actionPerformed failed");
			}

		}

	}

}