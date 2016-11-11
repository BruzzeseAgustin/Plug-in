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

/**
 *
 * @author usuario
 */
public class MachinLearningInterface extends javax.swing.JFrame {

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

    /**
     * Creates new form NewJFrame1
     */
    public MachinLearningInterface() {
        super("Machine Learning Interface");
        
        textArea = new JTextArea();
        btn = new JButton("Click Me!");
        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        initComponents();
        jInternalFrame2.setVisible(false);
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
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtdata = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtdata3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtmodel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtcodigo1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        txtcodigo5 = new javax.swing.JTextField();
        txtcodigo4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtcodigo3 = new javax.swing.JTextField();
        txtcodigo2 = new javax.swing.JTextField();
        txtcodigo6 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtdata4 = new javax.swing.JTextField();
        txtlabel = new javax.swing.JTextField();
        txtpath = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();
        advmachine = new javax.swing.JCheckBox();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Default Machine Learning ");
        jInternalFrame1.setVisible(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/load.png"))); // NOI18N
        jButton3.setText("Step 1 - Upload previews output files [CSV]");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Step 1 - Directory window will be display in order");

        jLabel8.setText("Step 2 - Prediction and classification of the data ");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classi.png"))); // NOI18N
        jButton7.setText("Step 2 - Classify data with our model of machine learning  ");
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel13.setText("            file in [step 1] using our default model ");

        txtdata.setEditable(false);
        txtdata.setBackground(new java.awt.Color(255, 255, 255));
        txtdata.setForeground(new java.awt.Color(153, 153, 153));
        txtdata.setText("(Data Field name)");
        txtdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdataActionPerformed(evt);
            }
        });

        jLabel14.setText("to select and upload the machine learning model    ");

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

        jLabel15.setText("Step 1 - Directory window will be display in order");

        jLabel16.setText("to select and upload the machine learning model    ");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture.png"))); // NOI18N
        jButton4.setText("Step 1 - Classify from Example Image");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tools.png"))); // NOI18N
        jMenu2.setText("Options");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hola.png"))); // NOI18N
        jMenuItem2.setText("Single file CSV convertor to ARFF");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/directory.png"))); // NOI18N
        jMenuItem3.setText("Directory File CSV converter to ARFF");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jInternalFrame1.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdata3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdata))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(txtdata3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jInternalFrame2.setTitle("Custom Machine Learning ");
        jInternalFrame2.setVisible(true);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classi.png"))); // NOI18N
        jButton10.setText("Step 5 - Make Prediction with custom model ");
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel9.setText("file in [step 2] using the model upload in [step 1]");

        jLabel12.setText("Step 5 - Prediction and classification of the data ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model.png"))); // NOI18N
        jButton2.setText("Step 3 - New model premade with WEKA software");
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

        jLabel7.setText("Step 3 - Select a single file you want to classify ");

        jLabel17.setText("3º Label ");

        jLabel18.setText("4º label");

        jLabel19.setText("1º Label ");

        jLabel20.setText("2º Label");

        txtcodigo1.setText("punctua");
        txtcodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo1ActionPerformed(evt);
            }
        });

        jLabel21.setText("5º label");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labels.png"))); // NOI18N
        jButton11.setText("Step 4 - Save  new costum labels");
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        txtcodigo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo5ActionPerformed(evt);
            }
        });

        txtcodigo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo4ActionPerformed(evt);
            }
        });

        jLabel22.setText("Step 4 - Morphological label used in your training model ");

        txtcodigo3.setText("networks");

        txtcodigo2.setText("rods");
        txtcodigo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo2ActionPerformed(evt);
            }
        });

        txtcodigo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo6ActionPerformed(evt);
            }
        });

        jLabel23.setText("6º label");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture.png"))); // NOI18N
        jButton6.setText("Step 1 - Classify from Image");
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

        jMenu8.setText("                                                                                                             ");
        jMenu8.setEnabled(false);
        jMenuBar2.add(jMenu8);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled-4.png"))); // NOI18N
        jMenu1.setText("Close Plugin");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        jInternalFrame2.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdata4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel20)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel17))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addComponent(txtcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtcodigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcodigo4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(txtcodigo5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(txtcodigo6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addGap(29, 29, 29)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodigo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo6)
                    .addComponent(txtcodigo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(txtlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(txtdata4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instruc.png"))); // NOI18N
        jButton8.setText("Instructions ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setText("      Special thanks to the developers of WEKA ");

        txtarea.setEditable(false);
        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        txtarea2.setColumns(20);
        txtarea2.setRows(5);
        jScrollPane2.setViewportView(txtarea2);

        jScrollPane5.setViewportView(editor);

        advmachine.setSelected(true);
        advmachine.setText("Advance Machine learning");
        advmachine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advmachineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jButton8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(advmachine)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(advmachine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jInternalFrame1)
            .addComponent(jInternalFrame2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //select model
        //IJ.showMessage("upload a model of machine learning ");        // TODO add your handling code here:
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        txtarea.setText("Converting, please wait...  ");
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

        txtdata.setText(chooser.getSelectedFile().getName());
        txtarea.setText("You have choose to load the file: " + chooser.getSelectedFile().getName());
    }//GEN-LAST:event_jButton3ActionPerformed


    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        setVisible(false);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        /**
         * Creates new form NonModelJDialogDemo
         */
        txtarea.setText("Set & open image...  ");
        String prova = IJ.getFilePath("");
        //ImagePlus imp = IJ.openImage(prova);
        IJ.open(prova);
        IJ.setTool("freehand");
        //imp.show();
        this.name3 = IJ.getImage().getTitle();
        //txtdata5.setText(prova);
        this.name3 = prova.replaceFirst("[.][^.]+$", "");
        setTitle(this.name3);
        txtarea2.setText("the image you want to analyse is..."
                + "\n" + this.name3);
        //new classifyfromimage1();
        //new classifyfromimage1().setVisible(true);
        classifyfromimage1 nf1 = new classifyfromimage1();
        classifyfromimage1.txtlabel.setText(this.txtlabel.getText());
        classifyfromimage1.txtpath.setText(this.txtpath.getText());
        nf1.setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        IJ.showMessage("With this plugin you will be abel to classify with a machine learning the mitochondria output. "
                + "\nobtain in the other part of the plugin. In order to classify, the data file MUST be ARFF "
                + "\n extension, otherwise, the prediction will not work. You can convert your CSV files to ARFF"
                + "\nUsing [step 1]. We have attach a trained machine learning with the J48 algorith using the  "
                + "\nWEKA software with the opportunitifor the user to develop, using the WEKA, and upload(with [step 3])"
                + "\nhis own model of machine learning. For any question or suggestion contact us in this email "
                + "\nbruzzese.agustin@gmail.com");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Instances data;
        try {
            data = new Instances(new BufferedReader(new FileReader(this.name3 + ".arff")));
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
            

        } catch (IOException ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        IJ.showMessage("analysing complete ");  
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdataActionPerformed
        txtdata.setEditable(false);
        txtdata.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_txtdataActionPerformed

    private void txtmodelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodelActionPerformed
        txtmodel.setEditable(false);
        txtmodel.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodelActionPerformed

    private void txtcodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
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
            txtarea.setText("Your labels are = " + this.list
                    + "\nThe labels had been saved");
            //txtarea.setText("The labels had been saved");

            System.out.println(label);

        } else {
            System.out.println("No Option");

        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtcodigo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo5ActionPerformed

    private void txtcodigo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
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

        IJ.showMessage("analysing complete ");  // TODO add your handling code here:         // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtcodigo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo4ActionPerformed

    private void txtcodigo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigo6ActionPerformed

    private void txtdata2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata2ActionPerformed
        //txtdata2.setEditable(false);
        //txtdata2.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_txtdata2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        /**
         * Creates new form NonModelJDialogDemo
         */
        txtarea.setText("Set & open image...  ");
        String prova = IJ.getFilePath("");
        //ImagePlus imp = IJ.openImage(prova);
        IJ.open(prova);
        IJ.setTool("freehand");
        //imp.show();
        this.name3 = IJ.getImage().getTitle();
        //txtdata5.setText(prova);
        this.name3 = prova.replaceFirst("[.][^.]+$", "");
        setTitle(this.name3);
        txtarea2.setText("the image youwant to analyse is..."
                + "\n" + this.name3);
        new classifyfromimage();
        new classifyfromimage().setVisible(true);


    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtdata3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdata3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void txtdata4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdata4ActionPerformed

    private void txtlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlabelActionPerformed

    private void txtpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpathActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
new sampleoption();
        new sampleoption().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void advmachineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advmachineActionPerformed
int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would you like to classify your results with our machin learning model of classification?", "Machine learning", dialogButton, JOptionPane.WARNING_MESSAGE);
        if (dialogResult == 0) {
             if (advmachine.isSelected()) {
jInternalFrame2.setVisible(false);}
        } else {
            System.out.println("No Option");

        }        
    }//GEN-LAST:event_advmachineActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2MouseClicked

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
    private javax.swing.JCheckBox advmachine;
    private javax.swing.JEditorPane editor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextArea txtarea2;
    private javax.swing.JTextField txtcodigo1;
    public javax.swing.JTextField txtcodigo2;
    private javax.swing.JTextField txtcodigo3;
    private javax.swing.JTextField txtcodigo4;
    private javax.swing.JTextField txtcodigo5;
    private javax.swing.JTextField txtcodigo6;
    protected javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtdata3;
    private javax.swing.JTextField txtdata4;
    private javax.swing.JTextField txtlabel;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtpath;
    // End of variables declaration//GEN-END:variables

}
