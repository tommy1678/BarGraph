package Controller;

import Model.Model;
import View.View;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
public class Controller extends JFrame {
    BlockingQueue<Graph> queue;
    Model graphModel;
    View view;

    public Controller(BlockingQueue<Graph> queue, Model graphModel, View view){
        this.queue = queue;
        this.graphModel = graphModel;
        this.view = view;
    }

    public void mainLoop(){
        while (view.isDisplayable()){
            Graph graph = null;
            try {
                graph = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(graph.getClass() == UpdateGraph.class){
                UpdateGraph update = (UpdateGraph) graph;
                graphModel.setHeight1(update.getHeight1());
                graphModel.setHeight2(update.getHeight2());
                graphModel.setHeight3(update.getHeight3());
                view.updateValues(graphModel.getHeight1(), graphModel.getHeight2(), graphModel.getHeight3());

            }
            else if(graph.getClass() == ResetGraph.class){
                graphModel.setHeight1(0);
                graphModel.setHeight2(0);
                graphModel.setHeight3(0);
                view.resetValues();
            }
        }
    }

}
