/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.corba.se.impl.orbutil.GetPropertyAction;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextArea;
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
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import static java.security.AccessController.doPrivileged;
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
import javax.swing.Timer;
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
/**
 *
 * @author usuario
 */
public class A_MachineLearning extends javax.swing.JInternalFrame {
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
    private String valor6;
    private String valor7;
    private String label;
    private ArrayList<String> list = new ArrayList<String>();
    public String liststring;
    private ArrayList<String> target = new ArrayList<String>();
    private String target2;
    private String name1;
    private String name2;
    private String name4;
    private String file3;
    private String name3;
    public String nf1;
    public String absolutePath;
    /**
     * Creates new form caja
     */
    public A_MachineLearning() {
        super("Machine Learning Interface");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtdata3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtresult2 = new javax.swing.JTextArea();
        interval1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        interval2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtdata = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtresults1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        editor = new javax.swing.JEditorPane();

        txtarea.setEditable(false);
        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);
        txtarea.getAccessibleContext().setAccessibleName("");

        jLabel15.setText("Step 1 - Directory window will be display in order");
        jLabel15.setMaximumSize(new java.awt.Dimension(228, 14));
        jLabel15.setMinimumSize(new java.awt.Dimension(228, 14));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture.png"))); // NOI18N
        jButton5.setText("Step 1 - Classify from Image");
        jButton5.setActionCommand("Step 2.2 - Open Image");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtdata3.setEditable(false);
        txtdata3.setBackground(new java.awt.Color(255, 255, 255));
        txtdata3.setForeground(new java.awt.Color(153, 153, 153));
        txtdata3.setText("(Image Name)");
        txtdata3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdata3ActionPerformed(evt);
            }
        });

        jLabel16.setText("to select and upload the Image, to perform it´s classification");
        jLabel16.setMaximumSize(new java.awt.Dimension(228, 14));
        jLabel16.setMinimumSize(new java.awt.Dimension(228, 14));

        txtresult2.setEditable(false);
        txtresult2.setColumns(20);
        txtresult2.setRows(5);
        jScrollPane5.setViewportView(txtresult2);

        interval1.setForeground(new java.awt.Color(153, 153, 153));
        interval1.setText("20.000");
        interval1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interval1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Lower limit");

        interval2.setForeground(new java.awt.Color(153, 153, 153));
        interval2.setText("1.000E16");
        interval2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interval2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Upper limit");

        jLabel17.setText("Step 2 - Select your pixel interval ");
        jLabel17.setMaximumSize(new java.awt.Dimension(228, 14));
        jLabel17.setMinimumSize(new java.awt.Dimension(228, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdata3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(interval1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(interval2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(txtdata3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interval1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(interval2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton5, txtdata3});

        jTabbedPane1.addTab("Clasification From Image", jPanel1);

        jLabel6.setText("Step 1.A - Directory window will be display in order");
        jLabel6.setMaximumSize(new java.awt.Dimension(228, 14));
        jLabel6.setMinimumSize(new java.awt.Dimension(228, 14));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classi.png"))); // NOI18N
        jButton7.setText("Step 1.B - Classify data with our model of machine learning  ");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel13.setText("file in [Step 1.A] using our default model ");

        jLabel14.setText("to select and upload the machine learning model    ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/load.png"))); // NOI18N
        jButton3.setText("Step 1.A - Upload previews output files [CSV]");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtdata.setEditable(false);
        txtdata.setBackground(new java.awt.Color(255, 255, 255));
        txtdata.setForeground(new java.awt.Color(153, 153, 153));
        txtdata.setText("(Data Field name)");
        txtdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataActionPerformed(evt);
            }
        });

        jLabel8.setText("Step 1.B - Classification of the data ");

        txtresults1.setEditable(false);
        txtresults1.setColumns(20);
        txtresults1.setRows(5);
        jScrollPane4.setViewportView(txtresults1);
        txtresults1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(27, 27, 27)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Classification from [CSV] files", jPanel2);

        txtarea2.setEditable(false);
        txtarea2.setColumns(20);
        txtarea2.setRows(5);
        jScrollPane2.setViewportView(txtarea2);

        jLabel3.setText(" Special thanks to the developers of WEKA ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        txtarea.setText("Set & open image...  ");
        String prova = IJ.getFilePath("");
        IJ.open(prova);
        //ImagePlus imp = IJ.openImage(prova);
        //imp.show();
        IJ.setTool("freehand");
        this.name3 = IJ.getImage().getTitle();
        this.name3 = prova.replaceFirst("[.][^.]+$", "");
        setTitle(this.name3);
        txtresult2.setText("the image you want to analyse is..."
            + "\n" + this.name3);
        txtdata3.setText(this.name3);
        
        Class<?> clazz = classifyfromimage.class;
        String url = clazz.getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".class").toString();
        String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir);
        IJ.runPlugIn(clazz.getName(), "");
        this.valor6 = this.interval1.getText();
        this.valor7 = this.interval2.getText();
        System.out.println("VECTOR-> punctua: "+this.valor6+ " "+this.valor7 );
        classifyfromimage nf1 = new classifyfromimage();
        classifyfromimage.interval3.setText(this.valor6);
        classifyfromimage.interval4.setText(this.valor7);
        nf1.setVisible(true);

        try {
            FileReader reader = new FileReader(this.file3 + ".arff");
            BufferedReader br = new BufferedReader(reader);
            txtarea2.read(br, null);
            br.close();
            txtarea2.requestFocus();
        
        } catch (Exception e2) {
            System.out.println(e2);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtdata3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdata3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "csv", "text");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
        //chooser.setMultiSelectionEnable(true);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            this.file2 = chooser.getSelectedFile().getAbsolutePath();
            try {
                CSVLoader loader = new CSVLoader();
                loader.setSource(new File(this.file2));
                Instances data = loader.getDataSet();
                System.out.println(data);

                // save ARFF
                this.file2 = this.file2.replaceFirst("[.][^.]+$", "");
                String arffile = this.file2 + ".arff";
                System.out.println(arffile);
                ArffSaver saver = new ArffSaver();
                saver.setInstances(data);
                saver.setFile(new File(arffile));
                saver.writeBatch();
            } catch (IOException ex) {
                Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            //txtdata2.setText(this.file2);

        }
        txtarea.setText("Succesfully converted " + this.file2);
        try {
            FileReader reader = new FileReader(this.file2 + ".arff");
            BufferedReader br = new BufferedReader(reader);
            txtarea2.read(br, null);
            br.close();
            txtarea2.requestFocus();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        txtarea.setText("You have choose to load the file: " + chooser.getSelectedFile().getName());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed
        txtdata.setEditable(false);
        txtdata.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_txtdataActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       Instances data;
        try {
            data = new Instances(new BufferedReader(new FileReader(this.file2 + ".arff")));
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

                    out = new PrintWriter(this.file2 + "_morphology.txt");
                    out.println(vec);
                    out.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //System.out.println(vec.get(i));
            }
            System.out.println("VECTOR-> punctua: " + p + ", rods: " + r + ", networks: " + n);
            IJ.showMessage("Your file:" + this.file2 + "arff"
                    + "\nhas been analysed, and it is composed by-> punctua: " + p + ", rods: " + r + ", networks: " + n);
            txtresults1.setText("Your file:" + this.file2 + "arff"
                    + "\nhas been analysed, and it is composed by: \npunctua: " + p + ", rods: " + r + ", networks: " + n);

        } catch (IOException ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        IJ.showMessage("analysing complete ");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void interval1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interval1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interval1ActionPerformed

    private void interval2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interval2ActionPerformed

    }//GEN-LAST:event_interval2ActionPerformed
 
    private void copyFile(InputStream in, FileOutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);

        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editor;
    public static javax.swing.JTextField interval1;
    public static javax.swing.JTextField interval2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea txtarea;
    public static javax.swing.JTextArea txtarea2;
    protected javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtdata3;
    public static javax.swing.JTextArea txtresult2;
    public static javax.swing.JTextArea txtresults1;
    // End of variables declaration//GEN-END:variables
}
