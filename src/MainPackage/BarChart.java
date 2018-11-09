/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;
import java.awt.*;
import javax.swing.*;
 
public class BarChart extends JPanel {
 
  private double[] values;
  private String[] labels;
  private Color[] colors;
  private String title;

 public BarChart(double q1,double q2,double q3,double q4) {
    title = "Quartile Medain";
     values = new double[]{q1,q2,q3,q4};
     labels = new String[]{"Medain 1","Medain 2","Medain 3","Medain 4"};
     colors = new Color[]{
        Color.black,
        Color.pink,
        Color.magenta,
        Color.red
    };
    
  }
 
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0) {
      return;
    }
 
    double minimumValue = 0;
   double maximumValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minimumValue > values[i]) {
        minimumValue = values[i];
      }
      if (maximumValue < values[i]) {
        maximumValue = values[i];
      }
    }
 
    Dimension dim = getSize();
    int panelWidth = dim.width;
    int panelHeight = dim.height;
    int barWidth = panelWidth / values.length;
 
    Font titleFont = new Font("Helvetica", Font.BOLD, 15);     //Book Antiqua
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
 
    Font labelFont = new Font("Helvetica", Font.PLAIN, 14);    //Book Antiqua
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
 
    int titleWidth = titleFontMetrics.stringWidth(title);
    int stringHeight = titleFontMetrics.getAscent();
    int stringWidth = (panelWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, stringWidth, stringHeight);
 
    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maximumValue == minimumValue) {
      return;
    }
    double scale = (panelHeight - top - bottom) / (maximumValue - minimumValue);
    stringHeight = panelHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    for (int j = 0; j < values.length; j++) {
      int valueP = j * barWidth + 1;
      int valueQ = top;
      int height = (int) (values[j] * scale);
      if (values[j] >= 0) {
        valueQ += (int) ((maximumValue - values[j]) * scale);
      } else {
        valueQ += (int) (maximumValue * scale);
        height = -height;
      }
 
      g.setColor(colors[j]);
      g.fillRect(valueP, valueQ, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueP, valueQ, barWidth - 2, height);
 
      int labelWidth = labelFontMetrics.stringWidth(labels[j]);
      stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(labels[j], stringWidth, stringHeight);
    }
  }
 }