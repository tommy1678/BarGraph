import Controller.Controller;
import Model.Model;
import View.View;
import Controller.Graph;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<Graph> queue = new LinkedBlockingQueue<>();
        Model graphModel = new Model();
        View view = new View(queue, graphModel);
        Controller controller = new Controller(queue, graphModel, view);
        view.setVisible(true);
        controller.mainLoop();                  

    }
}
