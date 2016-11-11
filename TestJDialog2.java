
import ij.IJ;
import static ij.IJ.URL;
import static ij.IJ.selectWindow;
import ij.Prefs;
import ij.plugin.frame.RoiManager;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;

public class TestJDialog2 extends javax.swing.JDialog implements ActionListener {

    private String name3;
    private Object txtarea;
    private String liststring;
    private String file;
    private Object txtarea2;
    private String model;

    public TestJDialog2(JFrame jframe, boolean modal) {
        jframe.setAlwaysOnTop(true);
        JButton boton;
        //Se pone el titulo a la ventana
        this.setTitle("Select the portion of cell you wish to analyse...");
        //Se crea un Layout y se agrega al contenedor del dialog
        this.getContentPane().setLayout(new FlowLayout());
        //Se crea el botón
        boton = new JButton("OK");
        JButton boton2 = new JButton("CANCELAR");
        //Se agrega el boton al contenedor del dialog
        this.getContentPane().add(boton);
        //Se agrega el Listener al botón
        boton.addActionListener(this);
        //Se hace la ventana visible
        this.setBounds(300, 300, 100, 100);
        //Se hace la ventana visible
        this.setVisible(true);
    }

    public static void main(String args[]) {
        //Se crea un JDialog Recibe un JFrame y se indica el modal true o false
        TestJDialog dialog = new TestJDialog(new JFrame(), true);

    }

    //Este método ejecuta el código del botón al pulsarlo
    public void actionPerformed(ActionEvent e) {

        this.name3 = IJ.getImage().getTitle();
        //this.name3 = this.name3.replaceFirst("[.][^.]+$", "");
        RoiManager rm = RoiManager.getInstance();
        //IJ.run("Duplicate...", this.name3);

        IJ.run("Set Measurements...", "area perimeter fit shape limit scientific redirect=None decimal=5");
        IJ.run("Subtract Background...", "rolling=1.5");
        IJ.run("Enhance Contrast...", "saturated=25 equalize");
        IJ.run("Subtract Background...", "rolling=1.5");
        IJ.run("Convolve...", "text1=[-1 -3 -4 -3 -1\n-3 0 6 0 -3\n-4 6 50 6 -4\n-3 0 6 0 -3\n-1 -3 -4 -3 -1\n] normalize");
        IJ.run("8-bit", "");
        IJ.run("Restore Selection", "");
        IJ.run("Make Binary", "");
        Prefs.blackBackground = false;
        IJ.run("Convert to Mask", "");
        IJ.run("Restore Selection", "");
        IJ.run("Analyze Particles...", "size=40.00-1.000E16 pixel show=Outlines display include summarize add");
        String dest_filename1, dest_filename2, full;
        selectWindow("Results");
        //dest_filename1 = this.name2 + "_complete.txt";
        dest_filename2 = this.name3 + "_complete.csv";
        //IJ.saveAs("Results", prova + File.separator + dest_filename1);
        IJ.run("Input/Output...", "jpeg=85 gif=-1 file=.csv copy_row save_column save_row");
        //IJ.saveAs("Results", dir + File.separator + dest_filename2);
        IJ.saveAs("Results", this.name3 + "_complete.csv");
        IJ.run("Restore Selection");
        IJ.run("Clear Results");

        //txtarea.setText("Converting, please wait...  ");
        try {
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(this.name3 + "_complete.csv"));
            Instances data = loader.getDataSet();
            System.out.println(data);

            // save ARFF
            String arffile = this.name3 + ".arff";
            System.out.println(arffile);
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(arffile));
            saver.writeBatch();
        } catch (IOException ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        //txtarea.setText("Analysing your data, please wait...  ");
        Instances data;
        try {
            data = new Instances(new BufferedReader(new FileReader(this.name3 + ".arff")));
            Instances newData = null;
            Add filter;
            newData = new Instances(data);
            filter = new Add();
            filter.setAttributeIndex("last");
            filter.setNominalLabels(this.liststring);
            filter.setAttributeName("target");
            filter.setInputFormat(newData);
            newData = Filter.useFilter(newData, filter);
            System.out.print(newData);
            Vector vec = new Vector();
            newData.setClassIndex(newData.numAttributes() - 1);

            if (!newData.equalHeaders(newData)) {
                throw new IllegalArgumentException("Train and test are not compatible!");
            }

            Classifier cls = (Classifier) weka.core.SerializationHelper.read(this.model);
            System.out.println("PROVANT MODEL.classifyInstance");
            for (int i = 0; i < newData.numInstances(); i++) {
                double pred = cls.classifyInstance(newData.instance(i));
                double[] dist = cls.distributionForInstance(newData.instance(i));
                System.out.print((i + 1) + " - ");
                System.out.print(newData.classAttribute().value((int) pred) + " - ");
                //txtarea2.setText(Utils.arrayToString(dist));

                System.out.println(Utils.arrayToString(dist));

                vec.add(newData.classAttribute().value((int) pred));
                //txtarea2.append(Utils.arrayToString(dist));

            }
            URL urlToModel = this.getClass().getResource("/" + "Final.model");
            InputStream stream = urlToModel.openStream();

            Classifier cls2 = (Classifier) weka.core.SerializationHelper.read(stream);
            System.out.println("PROVANT MODEL.classifyInstance");
            for (int i = 0; i < newData.numInstances(); i++) {
                double pred = cls2.classifyInstance(newData.instance(i));
                double[] dist = cls2.distributionForInstance(newData.instance(i));
                System.out.print((i + 1) + " - ");
                System.out.print(newData.classAttribute().value((int) pred) + " - ");
                //txtarea2.setText(Utils.arrayToString(dist));

                System.out.println(Utils.arrayToString(dist));

                vec.add(newData.classAttribute().value((int) pred));
                //txtarea2.append(Utils.arrayToString(newData.classAttribute().value((int) pred)));
                //this.target2.add((i + 1) + " -);
                //this.target.add(newData.classAttribute().value((int) pred));
                //for (String s : this.list) {
                //this.target2 += s + ",";

            }
            int p = 0, n = 0, r = 0;

            //txtarea2.append(Utils.arrayToString(this.target));
            for (Object vec1 : vec) {
                if ("rods".equals(vec1.toString())) {
                    r = r + 1;
                }
                if ("punctua".equals(vec1.toString())) {
                    p = p + 1;
                }
                if ("networks".equals(vec1.toString())) {
                    n = n + 1;
                }

                PrintWriter out = null;
                try {

                    out = new PrintWriter(this.name3 + "_morphology.txt");
                    out.println(vec);
                    out.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //System.out.println(vec.get(i));
            }
            System.out.println("VECTOR-> punctua: " + p + ", rods: " + r + ", networks: " + n);
            IJ.showMessage("Your file:" + this.name3 + "arff"
                    + "\nhas been analysed, and it is composed by-> punctua: " + p + ", rods: " + r + ", networks: " + n);
            //txtarea2.setText("Your file:" + this.name3 + ".arff"
            //+ "\nhas been analysed, and it is composed by-> punctua: " + p + ", rods: " + r + ", networks: " + n
            //+ "\n"
            //+ "\nAnalyse complete");
            //txtarea.setText("Analyse complete");

        } catch (IOException ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        IJ.run("Clear Results");
        //IJ.roiManager("Delete");
        IJ.run("Clear Results");
        IJ.run("Close All", "");
        setVisible(false);
        dispose();// TODO add your handling code here:
    }
}
