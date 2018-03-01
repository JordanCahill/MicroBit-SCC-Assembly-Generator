package sccassemblyparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jorda
 */
public class GUIJavascriptIn extends javax.swing.JFrame {

    private String directory;
    private static ArrayList<String> ISRTimer = new ArrayList<>();
    private static ArrayList<String> ISR0 = new ArrayList<>();
    private static ArrayList<String> ISR1 = new ArrayList<>();
    private static boolean buttonDetected;
    private static boolean buttonA; 
    private static boolean buttonB;
    private static boolean ISRA;
    private static boolean ISRB;
    private static ArrayList<String> displayImage = new ArrayList<>();
    
    /**
     * Creates new form GUIJavaScriptIn
     */
    public GUIJavascriptIn() {
        initComponents();
        this.setVisible(true);
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | 
                 IllegalAccessException | 
                 InstantiationException | 
                 UnsupportedLookAndFeelException ex) {}
        //</editor-fold>
        //</editor-fold>
        
    }

    /**
     * This method is called from within the constructor to initialize the form
     * Code generated using the NetBeans JFrame Form Editor
     * Creates the GUI Components
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        SubmitDirectoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setToolTipText("");

        jButton1.setText("Open File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetDirectoryButtonActionPerformed(evt);
            }
        });

        SubmitDirectoryButton.setText("Convert");
        SubmitDirectoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitDirectoryButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Please select the Javascript file you wish to convert..");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(SubmitDirectoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(SubmitDirectoryButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetDirectoryButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JavaScript Files (*.js)", "js");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.directory = fileChooser.getSelectedFile().toString();
            jTextField1.setText(directory);      
        }
    }//GEN-LAST:event_GetDirectoryButtonActionPerformed

    private void SubmitDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitDirectoryButtonActionPerformed
        FileReader in = null;
        try {
            in = new FileReader(directory);
        } catch (FileNotFoundException ex) {}
        BufferedReader br = new BufferedReader(in);
        System.out.println("File found..");
     
        String[] assemText = new String[100]; // Text to be formatted and added to .asm file
        assemText[0] = "; File created using a python to assembly converter";
        int L=1; // Counter for the length of the assembly
        String line;
        System.out.println("Reading python file and converting..");
        //String[] ISR = new String[30];
        
        boolean buttonDetected = false; // Boolean to keep track of button presses
        
        try {
            while ((line = br.readLine()) != null) { // Loop through the text file
                assemText[L] = Format(line);
                
//                if (assemText[L].contains("Displaying image for line")){
//                    for (String s: displayImage){
//                        assemText[L] = s;
//                        L++;
//                    }
//                }
                
                L++; // Increment size counter
                    
            }
        } catch (IOException ex) {}
        
        assemText[L] = "END"; L++; // All programs must finish with "END"
        try {in.close(); // Close the buffer
        }catch (IOException ex) {}
             
        // Add setUpTimer functionality
        assemText[L] = ";"; L++;
        for (String s: ISRTimer){
            assemText[L] = s;
            L++;
        }
        // Enable Interrupts
        assemText[L] = ";"; L++;
        assemText[L] = "enableInterrupts:"; L++;
        assemText[L] = "SETBSFR SFR0, 0"; L++;
        assemText[L] = "SETBSFR SFR0, 1"; L++;
        assemText[L] = "SETBSFR SFR0, 2"; L++;
        assemText[L] = "RET"; L++;
        
        // Add button functionality
        if (ISRA == true){
            assemText[L] = ";"; L++;
            assemText[L] = "ISR0:   ORG 92"; L++;
            for (String s: ISR0){
                String f = Format(s);
                if(s != null){
                    assemText[L] = f;
                    L++;
                }
            }
            assemText[L] = "RETI"; L++;
        }
        if (ISRB == true){
            assemText[L] = ";"; L++;
            assemText[L] = "ISR1:   ORG 104"; L++;
            for (String s: ISR1){
                String f = Format(s);
                if(s != null){
                    assemText[L] = f;
                    L++;
                }
            }
            assemText[L] = "RETI"; L++;
        }
      
        Formatter formatOut = new Formatter();
        String[] outputText = formatOut.formatOutputText(assemText,L);
        // Remove empty and null elements from the array
        //String[] outputText = formatOutputText(assemText, L);
        
        try {
            formatOut.CreateAsmFile(this, outputText); // Output final text to a .asm file
        } catch (FileNotFoundException ex) {}
    }//GEN-LAST:event_SubmitDirectoryButtonActionPerformed

    private static String Format(String line) {
        String formatted = "";
     
        // Sleep functionality
        if(line.contains("pause") && buttonDetected == false){
            Sleep sleep = new Sleep(line,false);
            String[] TmrVals = sleep.getOutputVals();
            formatted = "CALL settingUpTimer";
            Timer setupNoReload = new Timer();
            ISRTimer = setupNoReload.setUpTimerNoReload(TmrVals);
        }
        // Display functions
        if(line.contains("led.plot") && buttonDetected == false){
            LED led = new LED(line);
            formatted = led.getOutputLine();
        }
        if(line.contains("display.show")){
            LED led = new LED(line);
            displayImage = led.displayImage();
            formatted = "; Displaying image for line: " + line;
        }
                
        
        // Button functions
        if((line.contains("button")) && (line.contains("is_pressed"))){
            if(line.contains("button_a")){
                buttonA = true; buttonB = false;
                ISRA = true;
            }else if(line.contains("button_b")){
                buttonB = true; buttonA = false;
                ISRB = true;
            }
            buttonDetected = true;
            if(ISRA ^ ISRB){formatted = "CALL enableInterrupts";}
            line = "\t"; // So the line is not added to loop array
        } // Count number of lines following the function call
        line = line.replace("\t", "foobar");
        if(buttonDetected==true){
            if(line.contains("foobar")){
                if(!line.equals("foobar")){
                    line = line.replace("foobar", "");
                    if (buttonA == true){;
                        ISR0.add(line);
                    }
                    if(buttonB == true){
                        ISR1.add(line);
                    }
                }
            }else{ // Reset loop variables
                buttonDetected = false; // Finished button loop
            }

            // NOTE: WILL NEED TO ADD buttonDetected check to every other loop
        }

        return formatted;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIJavascriptIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SubmitDirectoryButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
