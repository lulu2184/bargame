package frontend;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayDeque;
import java.util.Iterator;

import backend.Controller;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class LinechartAt extends ApplicationFrame{
    private ArrayDeque<Integer> A;
    private int Viewsize=20;
    public LinechartAt(final String title)
    {
        super(title);
        A=new ArrayDeque<Integer>();
        //final CategoryDataset dataset = createDataset();
        //final JFreeChart chart = createChart(dataset);
        //final ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        //setContentPane(chartPanel);
    }
    public CategoryDataset createDataset()
    {

        // row keys...
        final String series1 = "A(t)";


        // column keys...
        int Turn;
        Turn = Controller.getController().getRound();
        if (Turn == 0) return new DefaultCategoryDataset();
        A.addLast(Controller.getController().getBusyness());
        int size=A.size();
        if(size>Viewsize)A.removeFirst();
        size=A.size();
        String[] Xcoordinate=new String[size+1];

        for(int i=1;i<=size;i++)Xcoordinate[i]=""+(Turn+i-size);


        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Iterator iter=A.iterator();
        for(int i=1;i<=size;i++)
        {
            dataset.addValue((Integer)iter.next(),series1,Xcoordinate[i]);
        }

        return dataset;

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     *
     * @return a chart.
     */
    public static JFreeChart createChart(final CategoryDataset dataset)
    {

        final JFreeChart chart = ChartFactory.createLineChart(
                "A(t)", // chart title
                "Turns", // domain axis label
                "A(t)", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        // final StandardLegend legend = (StandardLegend) chart.getLegend();
        // legend.setDisplaySeriesShapes(true);

        final Shape[] shapes = new Shape[3];
        int[] xpoints;
        int[] ypoints;

        // right-pointing triangle
        xpoints = new int[] { -3, 3, -3 };
        ypoints = new int[] { -3, 0, 3 };
        shapes[0] = new Polygon(xpoints, ypoints, 3);

        // vertical rectangle
        shapes[1] = new Rectangle2D.Double(-2, -3, 3, 6);

        // left-pointing triangle
        xpoints = new int[] { -3, 3, 3 };
        ypoints = new int[] { 0, -3, 3 };
        shapes[2] = new Polygon(xpoints, ypoints, 3);

        final DrawingSupplier supplier = new DefaultDrawingSupplier(
                DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, shapes);
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setDrawingSupplier(supplier);

        chart.setBackgroundPaint(Color.white);


        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
                .getRenderer();
        // renderer.setDrawShapes(true);
        renderer.setItemLabelsVisible(true);
        // renderer.setLabelGenerator(new StandardCategoryLabelGenerator());

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(false);
        rangeAxis.setUpperMargin(0.12);

        return chart;

    }
    public ChartPanel refresh()
    {
        JFreeChart chart=createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        return chartPanel;
        //���Բ�����API�ĵ�,��һ�������Ǳ��⣬�ڶ���������һ����ݼ�������������ʾ�Ƿ���ʾLegend�����ĸ������ʾ�Ƿ���ʾ��ʾ������������ʾͼ���Ƿ����URL

        //ChartFrame chartFrame=new ChartFrame("A(t)",chart);
        //chartҪ����Java��������У�ChartFrame�̳���java��Jframe�ࡣ�õ�һ�����������Ƿ��ڴ������Ͻǵģ��������м�ı��⡣
        //chartFrame.pack(); //�Ժ��ʵĴ�Сչ��ͼ��
        //chartFrame.setVisible(true);//ͼ���Ƿ�ɼ�
    }
}
