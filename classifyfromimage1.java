/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ij.IJ;
import static ij.IJ.URL;
import static ij.IJ.selectWindow;
import ij.ImagePlus;
import ij.Prefs;
import ij.WindowManager;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
public class classifyfromimage1 extends javax.swing.JFrame {

    public ArrayList<String> classif = new ArrayList<String>();
    private String name3;
    private String name4;
    private Object txtarea;
    private String image;
    private ImagePlus imp;
    public String valor1;
    public String valor2;
    public String text;

    void v() {
        //MachinLearningInterface.liststring.getClass();
    }

    /**
     * Creates new form NewJFrame1
     */
    public classifyfromimage1() {
        initComponents();
        txtpath.setVisible(false);
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
        jTextArea1 = new javax.swing.JTextArea();
        interval1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        interval2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtlabel = new javax.swing.JTextField();
        txtpath = new javax.swing.JTextField();
        txtpath2 = new javax.swing.JTextField();
        txtpath3 = new javax.swing.JTextField();
        interval3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        interval4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        interval1.setEditable(false);
        interval1.setForeground(new java.awt.Color(153, 153, 153));
        interval1.setText("15.000");
        interval1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interval1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Lower limit");

        interval2.setEditable(false);
        interval2.setForeground(new java.awt.Color(153, 153, 153));
        interval2.setText("1.000E16");
        interval2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interval2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Upper limit");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select your region of interest from your image ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/correct.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled-4.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtlabel.setEditable(false);
        txtlabel.setBackground(new java.awt.Color(255, 255, 255));
        txtlabel.setForeground(new java.awt.Color(153, 153, 153));
        txtlabel.setText("(You have not set your labels!");
        txtlabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlabelActionPerformed(evt);
            }
        });

        txtpath.setEditable(false);
        txtpath.setForeground(new java.awt.Color(232, 232, 232));
        txtpath.setText("jTextField1");
        txtpath.setBorder(null);
        txtpath.setDisabledTextColor(new java.awt.Color(232, 232, 232));
        txtpath.setSelectedTextColor(new java.awt.Color(232, 232, 232));
        txtpath.setSelectionColor(new java.awt.Color(232, 232, 232));
        txtpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpathActionPerformed(evt);
            }
        });

        txtpath2.setEditable(false);
        txtpath2.setForeground(new java.awt.Color(232, 232, 232));
        txtpath2.setText("jTextField1");
        txtpath2.setBorder(null);
        txtpath2.setDisabledTextColor(new java.awt.Color(232, 232, 232));
        txtpath2.setSelectedTextColor(new java.awt.Color(232, 232, 232));
        txtpath2.setSelectionColor(new java.awt.Color(232, 232, 232));
        txtpath2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpath2ActionPerformed(evt);
            }
        });

        txtpath3.setEditable(false);
        txtpath3.setForeground(new java.awt.Color(232, 232, 232));
        txtpath3.setText("jTextField1");
        txtpath3.setBorder(null);
        txtpath3.setDisabledTextColor(new java.awt.Color(232, 232, 232));
        txtpath3.setSelectedTextColor(new java.awt.Color(232, 232, 232));
        txtpath3.setSelectionColor(new java.awt.Color(232, 232, 232));
        txtpath3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpath3ActionPerformed(evt);
            }
        });

        interval3.setForeground(new java.awt.Color(153, 153, 153));
        interval3.setText("15.000");
        interval3.setFocusable(false);
        interval3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interval3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Lower limit");

        interval4.setForeground(new java.awt.Color(153, 153, 153));
        interval4.setText("1.000E16");
        interval4.setFocusable(false);
        interval4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interval4ActionPerformed(evt);
            }
        });

        jLabel12.setText("Upper limit");

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/options.png"))); // NOI18N
        jMenu2.setText("Selection Tool");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/options.png"))); // NOI18N
        jMenuItem1.setText("Free Selection ");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/options.png"))); // NOI18N
        jMenuItem2.setText("Rectangular Selection ");
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

        jMenuBar1.add(jMenu2);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tools.png"))); // NOI18N
        jMenu9.setText("Options");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash.png"))); // NOI18N
        jMenuItem3.setText("Clear Selection");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jMenuItem4.setText("jMenuItem1");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/all.png"))); // NOI18N
        jMenuItem5.setText("Select All");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem5);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(txtlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtpath2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(1, 1, 1)
                        .addComponent(txtpath3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(interval3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(interval4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpath3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interval3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(interval4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtpath3.getAccessibleContext().setAccessibleName("info");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectWindow(this.name3);
        this.name3 = IJ.getImage().getTitle();
        this.name4 = this.name3.replaceFirst("[.][^.]+$", "");
        RoiManager rm = RoiManager.getInstance();
        IJ.run("Duplicate...", this.name4);
        IJ.run("Set Measurements...", "area perimeter fit shape limit scientific redirect=None decimal=5");
        selectWindow(this.name3);
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
        this.valor1 = this.interval3.getText();
        this.valor2 = this.interval4.getText();
        this.text = "size=" + this.valor1 + "-" + this.valor2 + " pixel show=Outlines display include summarize add";
        IJ.saveAs("tif", this.name3 + "_processed");
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

        Instances data;
        try {
            data = new Instances(new BufferedReader(new FileReader(this.name3 + ".arff")));
            Instances newData = null;
            Add filter;
            newData = new Instances(data);
            filter = new Add();
            filter.setAttributeIndex("last");
            filter.setNominalLabels(txtlabel.getText());
            filter.setAttributeName(txtpath2.getText());
            filter.setInputFormat(newData);
            newData = Filter.useFilter(newData, filter);
            System.out.print(newData);
            Vector vec = new Vector();
            newData.setClassIndex(newData.numAttributes() - 1);

            if (!newData.equalHeaders(newData)) {
                throw new IllegalArgumentException("Train and test are not compatible!");
            }

            Classifier cls = (Classifier) weka.core.SerializationHelper.read(txtpath.getText());
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
                classif.add(newData.classAttribute().value((int) pred));
            }

            classif.removeAll(Arrays.asList("", null));
            System.out.println(classif);
            String vecstring = "";

            for (Object s : classif) {
                vecstring += s + ",";
                System.out.println("Hola " + vecstring);
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
int counter = 0;
for( int i=0; i<s.length(); i++ ) {
    if( s.charAt(i) == '$' ) {
        counter++;
    } 
}
            System.out.println(seussCount);
            System.out.println("hola "+ counter++);
            IJ.showMessage("Your file:" + this.name3 + "arff"
                    + "\n is composed by" + seussCount);
            txtpath2.setText("Your file:" + this.name3 + "arff"
                    + "\n is composed by" + seussCount);
            A_MachineLearning nf2 = new A_MachineLearning();
            A_MachineLearning.txtresult2.append(this.txtpath2.getText());
            nf2.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(MachinLearningInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        setVisible(false);
        dispose();// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        dispose();// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlabelActionPerformed

    private void txtpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpathActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        IJ.setTool("freehand");  // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        IJ.setTool("freehand");  // TODO add your handling code here:          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        IJ.setTool("rectangle");// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IJ.setTool("rectangle");     // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        IJ.run(this.imp, "Select None", "");         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        IJ.run("Restore Selection", "");        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IJ.run(imp, "Select All", "");        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu9ActionPerformed

    private void txtpath2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpath2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpath2ActionPerformed

    private void txtpath3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpath3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpath3ActionPerformed

    private void interval1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interval1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interval1ActionPerformed

    private void interval2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interval2ActionPerformed

    }//GEN-LAST:event_interval2ActionPerformed

    private void interval3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interval3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interval3ActionPerformed

    private void interval4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interval4ActionPerformed

    }//GEN-LAST:event_interval4ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(classifyfromimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(classifyfromimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(classifyfromimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(classifyfromimage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new classifyfromimage().setVisible(true);
         }
         });*/
        new classifyfromimage().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField interval1;
    public static javax.swing.JTextField interval2;
    public static javax.swing.JTextField interval3;
    public static javax.swing.JTextField interval4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField txtlabel;
    public static javax.swing.JTextField txtpath;
    public static javax.swing.JTextField txtpath2;
    public static javax.swing.JTextField txtpath3;
    // End of variables declaration//GEN-END:variables
}
