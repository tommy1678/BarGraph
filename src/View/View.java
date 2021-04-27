package View;

import Controller.Graph;
import Controller.ResetGraph;
import Controller.UpdateGraph;
import Model.Model;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;


public class View extends JFrame {
    JTextField textField1;
    JTextField textField2;
    JTextField textField;

    JButton updateGraph;
    JButton resetGraph;

    BlockingQueue<Graph> queue;
    Model graphModel;

    JLabel colorName1;
    JLabel colorName2;
    JLabel colorName3;

    JLabel height1;
    JLabel height2;
    JLabel height3;


    public View(BlockingQueue<Graph> queue, Model graphModel) {


        this.queue = queue;
        this.graphModel = graphModel;


        colorName1 = new JLabel("Red:");
        colorName2 = new JLabel("Blue: ");
        colorName3 = new JLabel("Green: ");

        height1 = new JLabel(String.valueOf((graphModel.getHeight1())));
        height2 = new JLabel(String.valueOf((graphModel.getHeight2())));
        height3 = new JLabel(String.valueOf((graphModel.getHeight3())));



        this.textField = new JTextField(10);
        this.textField1 = new JTextField(10);
        this.textField2 = new JTextField(10);
        this.updateGraph = new JButton("Update");
        this.resetGraph = new JButton("Reset");

        JPanel graphPanel = new JPanel();

        graphPanel.add(colorName1);
        graphPanel.add(textField);
        graphPanel.add(colorName2);
        graphPanel.add(textField1);
        graphPanel.add(colorName3);
        graphPanel.add(textField2);
        graphPanel.add(updateGraph);
        graphPanel.add(resetGraph);
        graphPanel.add(height1);
        graphPanel.add(height2);
        graphPanel.add(height3);

        this.add(graphPanel);

        updateGraph.addActionListener(e -> {
            int a = Integer.parseInt(textField.getText());
            int b = Integer.parseInt(textField1.getText());
            int c = Integer.parseInt(textField2.getText());
            try{
                queue.put(new UpdateGraph(a,b,c));

            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        resetGraph.addActionListener(e -> {
            try{
                queue.put(new ResetGraph());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        this.setSize(800, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void updateValues(int a, int b, int c){
        this.height1.setText(String.valueOf(a));
        this.height2.setText(String.valueOf(b));
        this.height3.setText(String.valueOf(c));
    }

    public void resetValues(){
        this.height1.setText(String.valueOf(0));
        this.height2.setText(String.valueOf(0));
        this.height3.setText(String.valueOf(0));
    }

}


