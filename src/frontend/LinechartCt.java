package frontend;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayDeque;
import java.util.Iterator;

import backend.Controller;
import backend.InteractiveController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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


public class LinechartCt extends ApplicationFrame{
    private ArrayDeque<Integer[]> C;
    private int Viewsize=20;

    public void LinecharCt()
    {
        //A=new int[11];
    }
    public LinechartCt(final String title)
    {
        super(title);
        C=new ArrayDeque<>();
        //final CategoryDataset dataset = createDataset();
        //final JFreeChart chart = createChart(dataset);
        //final ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        //setContentPane(chartPanel);

    }
    public CategoryDataset createDataset()
    {

        // row keys...
        int N= Controller.getController().getN();
        String[] series = new String[N+1];
        for(int i=0;i<N;i++)series[i]="C"+i+"(t)";
        if(InteractiveController.getController().getControllerType().equals("Interactive")==true)
            series[0]="user";

        // column keys...
        int Turn=Controller.getController().getRound();
        C.addLast(Controller.getController().getPlayerCapital());
        //System.out.println(Controller.getController().getPlayerCapital()[1]);
        int size=C.size();
        if(size>Viewsize)C.removeFirst();
        size=C.size();
        String[] Xcoordinate=new String[size+1];

        for(int i=1;i<=size;i++)Xcoordinate[i]=""+(Turn+i-size);


        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Iterator iter=C.iterator();

        for (int i = 1; i <= size; i++) {
            Integer[] capital=new Integer[N+1];
            capital=(Integer[])iter.next();
            for(int j=0;j<N;j++) {
                dataset.addValue(capital[j], series[j], Xcoordinate[i]);
            }
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
                "C(t)", // chart title
                "Turns", // domain axis label
                "C(t)", // range axis label
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

        // set the stroke for each series...
        if(InteractiveController.getController().getControllerType().equals("Interactive")==true) {
            plot.getRenderer().setSeriesStroke(
                    0,
                    new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND, 1.0f,
                            new float[]{10.0f, 6.0f}, 0.0f));
        }

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

        //ChartFrame chartFrame=new ChartFrame("C(t)",chart);
        //chartҪ����Java��������У�ChartFrame�̳���java��Jframe�ࡣ�õ�һ�����������Ƿ��ڴ������Ͻǵģ��������м�ı��⡣
        //chartFrame.pack(); //�Ժ��ʵĴ�Сչ��ͼ��
        //chartFrame.setVisible(true);//ͼ���Ƿ�ɼ�

    }
}
