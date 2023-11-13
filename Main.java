package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->{
            XYSeries series = new XYSeries("f(x) = x");

            for(double x = -5; x<5; x+= 0.1){
                double y;
                y=x;
                series.add(x,y);
            }

            XYSeriesCollection dataset = new XYSeriesCollection(series);

            //crie o grafico
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Grafico da função f(x) = x",
                    "x",
                    "f(x)",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    false,
                    false
            );
            JFrame frame = new JFrame("Grafico da função");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(new ChartPanel(chart));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
