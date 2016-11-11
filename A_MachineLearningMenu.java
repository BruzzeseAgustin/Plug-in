
import ij.IJ;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usuario
 */
public class A_MachineLearningMenu extends javax.swing.JFrame {
public String pathway;
public String file2;
public String file;
    /**
     * Creates new form menu
     */
    public A_MachineLearningMenu() {
        super("Machine Learning Interface");
        initComponents();
        Class<?> clazz = A_MachineLearning.class;
        String url = clazz.getResource("/" + clazz.getName().replace('.', '/') + ".class").toString();
        String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir);
        IJ.runPlugIn(clazz.getName(), "");
        Class<?> clazz2 = A_AdvanceMachineLearning.class;
        String url2 = clazz2.getResource("/" + clazz2.getName().replace('.', '/') + ".class").toString();
        String pluginsDir2 = url2.substring(5, url2.length() - clazz2.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir2);
        IJ.runPlugIn(clazz.getName(), "");
        A_MachineLearning f = new A_MachineLearning();
        desktop.add(f);
        f.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        Menu = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/instruc.png"))); // NOI18N
        jMenu9.setText("Instructions ");
        jMenu9.setAlignmentX(1.0F);
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
        Menu.add(jMenu9);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tools.png"))); // NOI18N
        jMenu2.setText("Options");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convert.png"))); // NOI18N
        jMenuItem2.setText("Single file CSV convertor to ARFF");
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

        Menu.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/load.png"))); // NOI18N
        jMenu3.setText("Advanced Options");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });

        jRadioButtonMenuItem2.setText("Advanced Machine Learing ");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem2);

        Menu.add(jMenu3);

        jMenu8.setText("                                                                                          ");
        jMenu8.setEnabled(false);
        Menu.add(jMenu8);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled-4.png"))); // NOI18N
        jMenu1.setText("Close Machine Learning Plugin");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        Menu.add(jMenu1);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser chooser = new JFileChooser(".");
        chooser.setApproveButtonText("OK");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        Component fileChooserDialog = null;
        chooser.showOpenDialog(fileChooserDialog);
        //ActionMap am = chooser.getActionMap();
        //Action key = am.get("OK");
        //key.setEnabled(false);
        this.pathway = chooser.getSelectedFile().getAbsolutePath();
        File[] filesInDirectory = new File(this.pathway).listFiles();
        for (File f : filesInDirectory) {
            String filepath2 = f.getAbsolutePath();
            String fileExtenstion = filepath2.substring(filepath2.lastIndexOf(".") + 1, filepath2.length());
            if ("csv".equals(fileExtenstion)) {
                System.out.println("CSV file found ->" + filepath2);

                try {
                    String fipa = this.pathway + File.separator + file;
                    System.out.println(filepath2);
                    System.out.println(fipa);
                    CSVLoader loader = new CSVLoader();
                    loader.setSource(new File(filepath2));
                    Instances data = loader.getDataSet();
                    System.out.println(data);
                    // save ARFF
                    String arffile = filepath2 + ".arff";
                    System.out.println(arffile);
                    ArffSaver saver = new ArffSaver();
                    saver.setInstances(data);
                    saver.setFile(new File(arffile));
                    saver.writeBatch();

                } catch (IOException ex) {
                    Logger.getLogger(A_MachineLearningMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

    }                                        
        IJ.showMessage("Conversion complete");
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        setVisible(false);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
/*String[] options = new String[2];
options[0] = new String ("Enable Advance Machine Learning");
options[1] = new String ("Disable Advance Machine Learnig");*/
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would you like to classify your results with our machin learning model of classification?", "Machine learning", dialogButton, JOptionPane.WARNING_MESSAGE);
        UIManager.put("OptionPane.yesButtonText", "Enable Advance machine learning");
        UIManager.put("OptionPane.noButtonText", "Disable Advance machine learning");
        if (dialogResult == 0) {
            
            A_AdvanceMachineLearning a = new A_AdvanceMachineLearning();
            desktop.add(a);
            a.setVisible(true);
            A_MachineLearning m = new A_MachineLearning();
            desktop.add(m);
            m.setVisible(false);
            m.dispose();
            System.out.println("yes Option");
            revalidate();
            repaint();
        } else {
           
            A_AdvanceMachineLearning a = new A_AdvanceMachineLearning();
            desktop.add(a);
            a.setVisible(false);
            a.dispose();
            A_MachineLearning m = new A_MachineLearning();
            desktop.add(m);
            m.setVisible(true);
            System.out.println("no Option");
            a.dispose();
            revalidate();
            repaint();
        }
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
   IJ.showMessage("With this plugin you will be abel to classify with a machine learning the mitochondria output. "
                + "\nobtain in the other part of the plugin. In order to classify, the data file MUST be ARFF "
                + "\n extension, otherwise, the prediction will not work. You can convert your CSV files to ARFF"
                + "\nUsing [step 1]. We have attach a trained machine learning with the J48 algorith using the  "
                + "\nWEKA software with the opportunitifor the user to develop, using the WEKA, and upload(with [step 3])"
                + "\nhis own model of machine learning. For any question or suggestion contact us in this email "
                + "\nbruzzese.agustin@gmail.com");          // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu9ActionPerformed
        IJ.showMessage("With this plugin you will be abel to classify with a machine learning the mitochondria output. "
            + "\nobtain in the other part of the plugin. In order to classify, the data file MUST be ARFF "
            + "\n extension, otherwise, the prediction will not work. You can convert your CSV files to ARFF"
            + "\nUsing [step 1]. We have attach a trained machine learning with the J48 algorith using the  "
            + "\nWEKA software with the opportunitifor the user to develop, using the WEKA, and upload(with [step 3])"
            + "\nhis own model of machine learning. For any question or suggestion contact us in this email "
            + "\nbruzzese.agustin@gmail.com");          // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu9ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        //chooser.setMultiSelectionEnable(true);
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            this.file2 = chooser.getSelectedFile().getAbsolutePath();
      try{        
                CSVLoader loader = new CSVLoader();
                loader.setSource(new File(this.file2));
                Instances data = loader.getDataSet();
                System.out.println(data);
      
                // save ARFF
                String arffile = this.file2 + ".arff";
                System.out.println(arffile);
                ArffSaver saver = new ArffSaver();
                saver.setInstances(data);
                saver.setFile(new File(arffile));
                saver.writeBatch();
            } catch (IOException ex) {
                Logger.getLogger(A_MachineLearningMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

      }           // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(A_MachineLearningMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A_MachineLearningMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A_MachineLearningMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A_MachineLearningMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Class<?> clazz = A_MachineLearningMenu.class;
                String url = clazz.getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".class").toString();
                String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);

                System.setProperty(
                        "plugins.dir", pluginsDir);
                IJ.runPlugIn(clazz.getName(), "");
                //new A_MachineLearningMenu().run("");
                new A_MachineLearningMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    // End of variables declaration//GEN-END:variables

}