/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.pentaho.packageManagement.PackageManager;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.WekaPackageManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import weka.core.Instances;
import java.io.File;
import ij.IJ;
import static ij.IJ.URL;
import static ij.IJ.getDirectory;
import static ij.IJ.selectWindow;
import static ij.IJ.write;
import ij.ImagePlus;
import ij.Macro;
import ij.Prefs;
import static ij.Prefs.set;
import ij.WindowManager;
import ij.gui.Roi;
import ij.gui.WaitForUserDialog;
import ij.io.OpenDialog;
import ij.io.Opener;
import static ij.measure.CurveFitter.f;
import ij.plugin.RoiRotator;
import ij.plugin.frame.RoiManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import static java.io.File.separator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.management.Query.value;
import javax.rmi.CORBA.Util;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.output.prediction.PlainText;
import weka.classifiers.functions.SMOreg;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.rules.DecisionTable;
import weka.core.Debug.Random;
import weka.core.Range;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.pmml.jaxbbindings.NaiveBayesModel;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Prediction;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.misc.SerializedClassifier;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import static weka.core.Debug.DBO.p;
import weka.core.Environment;
import weka.core.FastVector;
import weka.core.SerializationHelper;
import static weka.core.SerializationHelper.write;
import weka.core.Utils;
import weka.core.converters.ArffLoader.ArffReader;
import static weka.core.converters.ConverterUtils.DataSink.write;
import static weka.core.converters.ConverterUtils.DataSink.write;
import weka.core.converters.Loader;
import weka.core.converters.TextDirectoryLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.StringToWordVector;
import static weka.gui.explorer.ExplorerDefaults.set;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
//import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import org.pentaho.packageManagement.PackageManager;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.WekaPackageManager;
import weka.core.Instances;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.output.prediction.PlainText;
import weka.classifiers.functions.SMOreg;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.rules.DecisionTable;
import weka.core.Debug.Random;
import weka.core.Range;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.pmml.jaxbbindings.NaiveBayesModel;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Prediction;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.misc.SerializedClassifier;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import static weka.core.Debug.DBO.p;
import weka.core.Environment;
import weka.core.FastVector;
import weka.core.SerializationHelper;
import static weka.core.SerializationHelper.write;
import weka.core.Utils;
import weka.core.converters.ArffLoader.ArffReader;
import static weka.core.converters.ConverterUtils.DataSink.write;
import static weka.core.converters.ConverterUtils.DataSink.write;
import weka.core.converters.Loader;
import weka.core.converters.TextDirectoryLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.StringToWordVector;
import static weka.gui.explorer.ExplorerDefaults.set;

/**
 *
 * @author usuario
 */
public class classificationPLugin extends javax.swing.JFrame {

    private JTextArea textArea;
    private JButton btn;
    private String model;
    private String file;
    private Object nb;
    private String file2;
    private String path;
    private String pathway;
    private String out;
    int codigo;
    String nombre;
    private String valor;
    private String valor1;
    private String valor2;
    private String valor3;
    private String valor4;
    private String valor5;
    private String label;
    private ArrayList<String> list = new ArrayList<String>();
    public String liststring;
    private ArrayList<String> target = new ArrayList<String>();
    private String target2;
    private String name1;
    private String name2;
    private String file3;
    private String name3;
    public String nf1;
    public String name;

    /**
     * Creates new form NewJFrame1
     */
    public classificationPLugin() {
        super("Classification using WEKA machine learning ");
        textArea = new JTextArea();
        btn = new JButton("Click Me!");
        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        initComponents();
        editor.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        editor.setEditable(false);
        editor.setOpaque(false);
        editor.setText("Welcome to <a href='http://www.cs.waikato.ac.nz/ml/weka/'>WEKA homepage</a>.");
        editor.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    System.out.println(hle.getURL());
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(hle.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdirecotry2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        classi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        instance = new javax.swing.JTextArea();
        Classify = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();

        jButton1.setText("jButton1");

        jLabel4.setText("The user will be able to choose a directory and to convert all CSV files to ARFF extension  ");

        jLabel10.setText("Step 3 - Prediction and classification of the data ");

        jLabel11.setText("Step 3 - Prediction and classification of the data ");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu6.setText("jMenu6");

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu9.setText("jMenu9");

        jMenu10.setText("jMenu10");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("      Special thanks to the developers of WEKA ");

        txtdirecotry2.setEditable(false);
        txtdirecotry2.setColumns(20);
        txtdirecotry2.setRows(5);
        jScrollPane1.setViewportView(txtdirecotry2);

        jScrollPane5.setViewportView(editor);

        classi.setEditable(false);
        classi.setColumns(20);
        classi.setRows(5);
        jScrollPane3.setViewportView(classi);

        instance.setColumns(20);
        instance.setRows(5);
        jScrollPane2.setViewportView(instance);

        Classify.setText("OK");
        Classify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassifyActionPerformed(evt);
            }
        });

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled-4.png"))); // NOI18N
        jMenu3.setText("Return to the main window Plugin");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Classify, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(Classify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(366, 366, 366)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtdata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata2ActionPerformed

    }//GEN-LAST:event_txtdata2ActionPerformed

    private void ClassifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassifyActionPerformed
        this.name = txtdirecotry2.getText();
        System.out.println(this.name);
        try {
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(this.name));
            Instances data = loader.getDataSet();
            System.out.println(data);

            // save ARFF
            String arffile = this.name + ".arff";
            System.out.println(arffile);
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(arffile));
            saver.writeBatch();
        } catch (IOException ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileReader reader = new FileReader(this.name + ".arff");
            BufferedReader br = new BufferedReader(reader);
            instance.read(br, null);
            br.close();
            instance.requestFocus();

        } catch (Exception e2) {
            System.out.println(e2);
        }
               Instances data;
        try {
            data = new Instances(new BufferedReader(new FileReader(this.name + ".arff")));
            Instances newData = null;
            Add filter;
            newData = new Instances(data);
            filter = new Add();
            filter.setAttributeIndex("last");
            filter.setNominalLabels("rods,punctua,networks");
            filter.setAttributeName("target");
            filter.setInputFormat(newData);
            newData = Filter.useFilter(newData, filter);
            System.out.print(newData);
            Vector vec = new Vector();
            newData.setClassIndex(newData.numAttributes() - 1);
            if (!newData.equalHeaders(newData)) {
                throw new IllegalArgumentException("Train and test are not compatible!");
            }

            URL urlToModel = this.getClass().getResource("/" + "Final.model");
            InputStream stream = urlToModel.openStream();

            Classifier cls = (Classifier) weka.core.SerializationHelper.read(stream);
            System.out.println("PROVANT MODEL.classifyInstance");
            for (int i = 0; i < newData.numInstances(); i++) {
                double pred = cls.classifyInstance(newData.instance(i));
                double[] dist = cls.distributionForInstance(newData.instance(i));
                System.out.print((i + 1) + " - ");
                System.out.print(newData.classAttribute().value((int) pred) + " - ");
                //txtarea2.setText(Utils.arrayToString(dist));

                System.out.println(Utils.arrayToString(dist));

                vec.add(newData.classAttribute().value((int) pred));
                
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

                    out = new PrintWriter(this.name + "_morphology.txt");
                    out.println(vec);
                    out.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //System.out.println(vec.get(i));
            }     
        
            System.out.println("VECTOR-> punctua: " + p + ", rods: " + r + ", networks: " + n);
            IJ.showMessage("Your file:" + this.name + "arff"
                    + "\nhas been analysed, and it is composed by-> \npunctua: " + p + ", rods: " + r + ", networks: " + n);
            classi.setText("Your file:" + this.name + "arff"
                    + "\nhas been analysed, and it is composed by: \npunctua: " + p + ", rods: " + r + ", networks: " + n);
        } catch (IOException ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        IJ.run("Clear Results");
        IJ.run("Clear Results");
        IJ.run("Close All", "");

        if (WindowManager.getFrame("Results") != null) {
            IJ.selectWindow("Results");
            IJ.run("Close");
        }
        if (WindowManager.getFrame("Summary") != null) {
            IJ.selectWindow("Summary");
            IJ.run("Close");
        }
        if (WindowManager.getFrame("Results") != null) {
            IJ.selectWindow("Results");
            IJ.run("Close");
        }
        if (WindowManager.getFrame("ROI Manager") != null) {
            IJ.selectWindow("ROI Manager");
            IJ.run("Close");
        }
        IJ.run("Close All", "roiManager");
        IJ.run("Close All", "");

    }//GEN-LAST:event_ClassifyActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        setVisible(false);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MachinLearningInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MachinLearningInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MachinLearningInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MachinLearningInterface.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MachinLearningInterface().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Classify;
    private javax.swing.JTextArea classi;
    private javax.swing.JEditorPane editor;
    private javax.swing.JTextArea instance;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JTextArea txtdirecotry2;
    // End of variables declaration//GEN-END:variables

}
