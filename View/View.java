package View;

import javax.swing.*;
import java.awt.*;
// import java.time.Year;
import java.awt.event.*;

public class View extends JFrame {

	private JLabel headingLabel;
	private JPanel headingPanel;

	private JPanel entryPanel;

	private JLabel MovieLabel;
	private JTextField entryMovie;
	private JLabel RatingLabel;
	private JTextField entryRating;
	private JLabel DateLabel;
	private JTextField entryDate;
	private JTextField entryQuery;

	private JButton submitButton;
	private JButton fetchButton;

	private JPanel interactionPanel;
	private JPanel displayPanel;

	public View() {
		headingLabel = new JLabel(" My IMDB Database");
		headingLabel.setFont(new Font("SanSerif", Font.BOLD, 50));
		headingPanel = new JPanel();
		headingPanel.add(headingLabel);

		MovieLabel = new JLabel("Movie Name");
		MovieLabel.setHorizontalAlignment(JLabel.CENTER);
		MovieLabel.setVerticalAlignment(JLabel.BOTTOM);
		entryMovie = new JTextField(15);
		RatingLabel = new JLabel("Rating");
		RatingLabel.setHorizontalAlignment(JLabel.CENTER);
		RatingLabel.setVerticalAlignment(JLabel.BOTTOM);
		entryRating = new JTextField(15);
		DateLabel = new JLabel("Date Released");
		DateLabel.setHorizontalAlignment(JLabel.CENTER);
		DateLabel.setVerticalAlignment(JLabel.BOTTOM);
		entryDate = new JTextField(15);

		submitButton = new JButton("Submit");

		entryQuery = new JTextField(20);
		fetchButton = new JButton("Fetch");

		entryPanel = new JPanel();
		entryPanel.setLayout(new GridLayout(0, 3, 10, 10));

		entryPanel.add(MovieLabel);
		entryPanel.add(RatingLabel);
		entryPanel.add(DateLabel);

		entryPanel.add(entryMovie);
		entryPanel.add(entryRating);
		entryPanel.add(entryDate);
		entryPanel.add(submitButton);

		interactionPanel = new JPanel();
		interactionPanel.setLayout(new BoxLayout(interactionPanel, BoxLayout.Y_AXIS));

		interactionPanel.add(entryQuery);
		interactionPanel.add(fetchButton);

		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(0, 1, 0, 5));

		this.add(headingPanel);
		this.add(entryPanel);
		this.add(interactionPanel);
		this.add(displayPanel);

	}

	public void enableView(int width, int height) {

		this.setVisible(true);
		this.setSize(width, height);

		this.setLayout(new GridLayout(0, 1, 0, 15));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addSubmitActionListener(ActionListener listener) {
		this.submitButton.addActionListener(listener);
	}

	public void addFetchActionListener(ActionListener listener) {
		this.fetchButton.addActionListener(listener);
	}

	public void addFetchedData(String dispString) {

		JLabel fetched = new JLabel(dispString);
		this.displayPanel.add(fetched);
		displayPanel.revalidate();
		displayPanel.repaint();
	}

	// public String getMovieName() {
	// return entryMovie.getText();
	// }

	// public String getRatings() {
	// return entryRating.getText();
	// }

	// public String getDate() {
	// return entryDate.getText();
	// }

	public Movie getMovieDetails() {
		return new Movie(entryMovie.getText(), entryDate.getText(), entryDate.getText());
	}

	public String getQuery() {
		return entryQuery.getText();
	}

	public void clearDisplayPanel() {
		Component[] componentList = displayPanel.getComponents();

		// Loop through the components
		for (Component c : componentList) {

			// Find the components you want to remove
			displayPanel.remove(c);

		}

		displayPanel.revalidate();
		displayPanel.repaint();

	}

}
