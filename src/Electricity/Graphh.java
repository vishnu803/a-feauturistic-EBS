
package Electricity;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graphh extends ApplicationFrame {

   public Graphh( String applicationTitle , String chartTitle ,int[][] units ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(chartTitle,"Month","Bill amount",createDataset(units),
        PlotOrientation.VERTICAL,true,true,false);
         
        customizeChart(lineChart);
        
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 610 , 367 ) );
        setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset(int[][] units) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        
        String[] months=new String[12];
        months[0]="January";
        months[1]="February";
        months[2]="March";
        months[3]="April";
        months[4]="May";
        months[5]="June";
        months[6]="July";
        months[7]="August";
        months[8]="September";
        months[9]="October";
        months[10]="November";
        months[11]="December";
        
        int m2 = units[0][1];
        int meter_id = units[1][1];
        
        
        for(int i=units.length-1;i>=0;i--){
            dataset.addValue(units[i][0], "Customer "+units[1][1], months[m2-i]);
        }       
        
        return dataset;
   }
   
   private void customizeChart(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		LineAndShapeRenderer renderer = new LineAndShapeRenderer();

		// sets paint color for each series
		renderer.setSeriesPaint(0, Color.RED);
                
		// sets thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		
		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		
		// sets renderer for lines
		plot.setRenderer(renderer);
		
		// sets plot background
		plot.setBackgroundPaint(Color.CYAN);
		
		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		
	}
   

}
