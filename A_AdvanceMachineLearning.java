/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ij.plugin.filter.GaussianBlur;
import ij.process.ImageProcessor;
import org.scijava.plugin.Plugin;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.swing.UIManager;
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
import weka.core.converters.Loader;
import weka.core.converters.TextDirectoryLoader;
import weka.core.pmml.Function;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.StringToWordVector;
import static weka.gui.explorer.ExplorerDefaults.set;

/**
 *
 * @author usuario
 */
public class A_AdvanceMachineLearning extends javax.swing.JInternalFrame {

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
    public ArrayList<String> classif = new ArrayList<String>();
    private ArrayList<String> list = new ArrayList<String>();
    public String liststring;
    private ArrayList<String> target = new ArrayList<String>();
    private String target2;
    private String name1;
    private String name2;
    private String file3;
    private String name3;
    public String nf1;

    /**
     * Creates new form AdvanceMachineLearning
     */
    public A_AdvanceMachineLearning() {
        super("Advanced Machine Learning Interface");
        initComponents();
        textArea = new JTextArea();
        btn = new JButton("Click Me!");
        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        initComponents();
        txtlabel.setVisible(false);
        txtpath.setVisible(false);
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

        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtmodel = new javax.swing.JTextField();
        txtlabel = new javax.swing.JTextField();
        txtpath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        editor = new javax.swing.JEditorPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        txtcodigo7 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtcodigo5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtcodigo2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtcodigo3 = new javax.swing.JTextField();
        txtcodigo4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtcodigo1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtcodigo6 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        interval2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        interval1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtdata4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtdata = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setTitle("Advance Machine Learning");
        setMinimumSize(new java.awt.Dimension(38, 33));
        setPreferredSize(new java.awt.Dimension(891, 662));

        jLabel7.setText("Select a single file you want to classify ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model.png"))); // NOI18N
        jButton2.setText(" New model premade with WEKA software");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtmodel.setEditable(false);
        txtmodel.setBackground(new java.awt.Color(255, 255, 255));
        txtmodel.setForeground(new java.awt.Color(153, 153, 153));
        txtmodel.setText("(Model of prediction name)");
        txtmodel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodelActionPerformed(evt);
            }
        });

        txtlabel.setEditable(false);
        txtlabel.setForeground(new java.awt.Color(232, 232, 232));
        txtlabel.setText("txtlabel");
        txtlabel.setBorder(null);
        txtlabel.setCaretColor(new java.awt.Color(232, 232, 232));
        txtlabel.setDisabledTextColor(new java.awt.Color(232, 232, 232));
        txtlabel.setEnabled(false);
        txtlabel.setSelectedTextColor(new java.awt.Color(232, 232, 232));
        txtlabel.setSelectionColor(new java.awt.Color(232, 232, 232));
        txtlabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlabelActionPerformed(evt);
            }
        });

        txtpath.setEditable(false);
        txtpath.setForeground(new java.awt.Color(232, 232, 232));
        txtpath.setText("txtlabel");
        txtpath.setBorder(null);
        txtpath.setCaretColor(new java.awt.Color(232, 232, 232));
        txtpath.setDisabledTextColor(new java.awt.Color(232, 232, 232));
        txtpath.setEnabled(false);
        txtpath.setSelectedTextColor(new java.awt.Color(232, 232, 232));
        txtpath.setSelectionColor(new java.awt.Color(232, 232, 232));
        txtpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpathActionPerformed(evt);
            }
        });

        txtarea.setEditable(false);
        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        txtarea2.setEditable(false);
        txtarea2.setColumns(20);
        txtarea2.setRows(5);
        jScrollPane2.setViewportView(txtarea2);

        jLabel3.setText(" Special thanks to the developers of WEKA ");

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcodigo7.setText("target");

        jLabel1.setText("Set attribute name :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtcodigo7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(341, 341, 341))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcodigo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Attribute name :", jPanel4);

        txtcodigo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo5ActionPerformed(evt);
            }
        });

        jLabel18.setText("4º label");

        jLabel17.setText("3º Label ");

        jLabel19.setText("1º Label ");

        txtcodigo2.setText("rods");
        txtcodigo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Morphological label used in your training model ");

        txtcodigo3.setText("networks");

        txtcodigo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo4ActionPerformed(evt);
            }
        });

        jLabel20.setText("2º Label");

        jLabel21.setText("5º label");

        txtcodigo1.setText("punctua");
        txtcodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo1ActionPerformed(evt);
            }
        });

        jLabel23.setText("6º label");

        txtcodigo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcodigo5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtcodigo6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtcodigo3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo6)
                    .addComponent(txtcodigo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        jTabbedPane2.addTab("Morphological label :", jPanel3);

        jLabel24.setText("Select your pixel interval :");
        jLabel24.setMaximumSize(new java.awt.Dimension(228, 14));
        jLabel24.setMinimumSize(new java.awt.Dimension(228, 14));

        interval2.setForeground(new java.awt.Color(153, 153, 153));
        interval2.setText("1.000E16");

        jLabel10.setText("Upper limit");

        interval1.setForeground(new java.awt.Color(153, 153, 153));
        interval1.setText("20.000");

        jLabel11.setText("Lower limit");

        jLabel25.setText("Option only available for \"Classification From Image\"");
        jLabel25.setMaximumSize(new java.awt.Dimension(228, 14));
        jLabel25.setMinimumSize(new java.awt.Dimension(228, 14));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(interval2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(interval1))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interval1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interval2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(56, 56, 56))
        );

        jTabbedPane2.addTab("Display selection :", jPanel5);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Select a single file you want to classify ");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture.png"))); // NOI18N
        jButton6.setText("Classify directly from Image");
        jButton6.setActionCommand("Step 2.2 - Open Image");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtdata4.setEditable(false);
        txtdata4.setBackground(new java.awt.Color(255, 255, 255));
        txtdata4.setForeground(new java.awt.Color(153, 153, 153));
        txtdata4.setText("(Image Name)");
        txtdata4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdata4ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loadfile.png"))); // NOI18N
        jButton1.setText("Display an example of training data, used for generation WEKA models");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdata4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(txtdata4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clasification From Image", jPanel1);

        jLabel9.setText("using your settings");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classi.png"))); // NOI18N
        jButton10.setText("Step 2 - Make Prediction with custom model ");
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel12.setText("Classificy your [CSV] fiel data ");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/load.png"))); // NOI18N
        jButton3.setText("Step 1 - Upload previews output files [CSV]");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Classification from [CSV] files", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //select model
        //IJ.showMessage("upload a model of machine learning ");        // TODO add your handling code here:
        UIManager.put("OptionPane.yesButtonText", "Confirm");
        UIManager.put("OptionPane.noButtonText", "Cancel");
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "We strongly recommend to use the algorith J48 in your model", "Advance Machine learning", dialogButton, JOptionPane.WARNING_MESSAGE);
        if (dialogResult == 0) {
            System.out.println("Yes option");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("MODEL FILES", "model", "text");
            chooser.setFileFilter(filter);
            chooser.setMultiSelectionEnabled(false);
            //chooser.setMultiSelectionEnable(true);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                txtpath.setText(selectedFile.getAbsolutePath());
                this.model = chooser.getSelectedFile().getAbsolutePath();
                txtarea.setText("You have choose to load the model: " + chooser.getSelectedFile().getName());
                txtmodel.setText(chooser.getSelectedFile().getName());
            }

        } else {
            System.out.println("No Option");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtmodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodelActionPerformed
        txtmodel.setEditable(false);
        txtmodel.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodelActionPerformed

    private void txtcodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo1ActionPerformed

    private void txtcodigo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo2ActionPerformed

    private void txtcodigo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo4ActionPerformed

    private void txtcodigo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo5ActionPerformed

    private void txtcodigo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo6ActionPerformed

    private void txtlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlabelActionPerformed

    private void txtpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpathActionPerformed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed
        txtdata.setEditable(false);
        txtdata.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_txtdataActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "csv", "text");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(true);
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
            System.out.println(this.file2);
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

        txtdata.setText(chooser.getSelectedFile().getName());
        txtarea.setText("You have choose to load the file: " + chooser.getSelectedFile().getName());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirm");
        UIManager.put("OptionPane.noButtonText", "Cancel");
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "The labels must be the same used in the weka model", "Advance Machine learning", dialogButton, JOptionPane.WARNING_MESSAGE);
        if (dialogResult == 0) {
            this.list.clear();
            //txtcodigo1.setText("hola");
            this.valor = txtcodigo1.getText();
            this.valor1 = txtcodigo2.getText();
            this.valor2 = txtcodigo3.getText();
            this.valor3 = txtcodigo4.getText();
            this.valor4 = txtcodigo5.getText();
            this.valor5 = txtcodigo6.getText();
            //IJ.showMessage("your label 1 is = "+valor+", "+valor1+", "+valor2+", "+valor3+", "+valor4);
            // Array list
            this.list.add(this.valor);
            this.list.add(this.valor1);
            this.list.add(this.valor2);
            this.list.add(this.valor3);
            this.list.add(this.valor4);
            this.list.add(this.valor5);
            this.list.removeAll(Arrays.asList("", null));
            System.out.println(this.list);
            this.liststring = "";

            for (String s : this.list) {
                this.liststring += s + ",";
            }
            txtlabel.setText(this.liststring);

            System.out.println(this.liststring);
            txtarea.setText("Your labels are = " + this.list + "\nThe labels had been saved");
            //txtarea.setText("The labels had been saved");

            System.out.println(label);

        } else {
            System.out.println("No Option");

        }
        Instances data;
        try {
            System.out.println(this.file2 + "arff");
            FileReader reader = new FileReader(this.file2 + ".arff");
            BufferedReader br = new BufferedReader(reader);

            data = new Instances(br);
            System.out.println(data);
            Instances newData = null;
            Add filter;
            newData = new Instances(data);
            filter = new Add();
            filter.setAttributeIndex("last");
            filter.setNominalLabels(this.liststring);
            filter.setAttributeName(txtcodigo7.getText());
            filter.setInputFormat(newData);
            newData = Filter.useFilter(newData, filter);
            System.out.print("hola" + newData);
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

                classif.add(newData.classAttribute().value((int) pred));
            }

            classif.removeAll(Arrays.asList("", null));
            System.out.println(classif);
            String vecstring = "";

            for (Object s : classif) {
                vecstring += s + ",";
                
            }
            Map<String, Integer> seussCount = new HashMap<String, Integer>();
            for (String t : classif) {
                Integer i = seussCount.get(t);
                if (i == null) {
                    i = 0;
                }
                seussCount.put(t, i + 1);
            }
                        String s = vecstring;
String in = vecstring;
int i = 0;
Pattern p = Pattern.compile(this.valor1);
Matcher m = p.matcher( in );
while (m.find()) {
    i++;
}

System.out.println("hola "+ i); // Prints 2

            System.out.println(seussCount);
            txtarea2.append("Your file:" + this.file2 + "arff"
                    + "\n is composed by" + seussCount);
IJ.showMessage("Your file:" + this.file2 + "arff"
                    + "\n is composed by" + seussCount);
        } catch (Exception ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IJ.showMessage("analysing complete ");// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtdata4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdata4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Confirm");
        UIManager.put("OptionPane.noButtonText", "Cancel");
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "The labels must be the same used in the weka model", "Advance Machine learning", dialogButton, JOptionPane.WARNING_MESSAGE);
        if (dialogResult == 0) {
            this.list.clear();
            //txtcodigo1.setText("hola");
            this.valor = txtcodigo1.getText();
            this.valor1 = txtcodigo2.getText();
            this.valor2 = txtcodigo3.getText();
            this.valor3 = txtcodigo4.getText();
            this.valor4 = txtcodigo5.getText();
            this.valor5 = txtcodigo6.getText();
            //IJ.showMessage("your label 1 is = "+valor+", "+valor1+", "+valor2+", "+valor3+", "+valor4);
            // Array list
            this.list.add(this.valor);
            this.list.add(this.valor1);
            this.list.add(this.valor2);
            this.list.add(this.valor3);
            this.list.add(this.valor4);
            this.list.add(this.valor5);
            this.list.removeAll(Arrays.asList("", null));
            System.out.println(this.list);
            this.liststring = "";

            for (String s : this.list) {
                this.liststring += s + ",";
            }
            txtlabel.setText(this.liststring);

            System.out.println(this.liststring);
            txtarea.setText("Your labels are = " + this.list + "\nThe labels had been saved");
            //txtarea.setText("The labels had been saved");

            System.out.println(label);

        } else {
            System.out.println("No Option");

        }
        txtarea.setText("Set & open image...  ");
        String prova = IJ.getFilePath("");
        //ImagePlus imp = IJ.openImage(prova);
        //ImagePlus imp = IJ.openImage(prova);
        //imp.show();
        IJ.open(prova);
        IJ.setTool("freehand");
        //imp.show();
        this.name3 = IJ.getImage().getTitle();
        //txtdata5.setText(prova);
        this.name3 = prova.replaceFirst("[.][^.]+$", "");
        setTitle(this.name3);
        txtdata4.setText(this.name3);
        txtarea2.setText("the image you want to analyse is..."
                + "\n" + this.name3);
        //new classifyfromimage1();
        //new classifyfromimage1().setVisible(true);
        Class<?> clazz = classifyfromimage1.class;
        String url = clazz.getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".class").toString();
        String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir);
        classifyfromimage1 nf1 = new classifyfromimage1();
        classifyfromimage1.txtlabel.setText(this.txtlabel.getText());
        classifyfromimage1.txtpath.setText(this.txtpath.getText());
        classifyfromimage1.txtpath2.setText(this.txtcodigo7.getText());
        classifyfromimage1.interval1.setText(this.interval1.getText());
        classifyfromimage1.interval2.setText(this.interval2.getText());
        nf1.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            /*URL urlToTraining = this.getClass().getResourceAsStream("/" + "train.arff");
             InputStream stream = urlToTraining.openStream();*/
            InputStream stream = this.getClass().getResourceAsStream("/" + "train.arff");
            //BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            Instances data = new Instances(new BufferedReader(new InputStreamReader(stream)));
            String data1 = data.toString();
            txtarea2.setText(data1);
            txtarea.setText("You have choose to display an example training file: ");
        } catch (IOException ex) {
            Logger.getLogger(A_AdvanceMachineLearning.class.getName()).log(Level.SEVERE, null, ex);
    }//GEN-LAST:event_jButton1ActionPerformed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editor;
    private javax.swing.Box.Filler filler1;
    public static javax.swing.JTextField interval1;
    public static javax.swing.JTextField interval2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextArea txtarea2;
    private javax.swing.JTextField txtcodigo1;
    public javax.swing.JTextField txtcodigo2;
    private javax.swing.JTextField txtcodigo3;
    private javax.swing.JTextField txtcodigo4;
    private javax.swing.JTextField txtcodigo5;
    private javax.swing.JTextField txtcodigo6;
    private javax.swing.JTextField txtcodigo7;
    protected javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtdata4;
    private javax.swing.JTextField txtlabel;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtpath;
    // End of variables declaration//GEN-END:variables
}
