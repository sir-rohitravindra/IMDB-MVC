import Controller.Controller;
import Model.Model;
import View.View;

public class MVCMain {
	public static void main(String[] args) {
		int width = 500, height = 500;

		View view = new View();
		Model model = new Model();

		Controller controller = new Controller(model, view, width, height);
		controller.StartApplication();
	}
}
