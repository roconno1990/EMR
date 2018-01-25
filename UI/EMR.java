package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JList;


public class EMR {

   private JFrame frame;
   private final JLabel lblNewLabel = new JLabel("ELECTRONIC MEDICAL RECORD");
   private JTextField txtPatientNameMrn;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               EMR window = new EMR();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public EMR() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(0, 0, 1195, 679);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
      lblNewLabel.setBounds(10, 0, 697, 35);
      frame.getContentPane().add(lblNewLabel);
      
      // column tab
      JPanel panel_2 = new JPanel();
      panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
      panel_2.setBounds(30, 67, 190, 900);
      frame.getContentPane().add(panel_2);

      JButton patSearch = new JButton("Patient Search");
      JButton regInfo = new JButton("Registration");
      JButton patTrack = new JButton("Patient tracker");
      JButton phyExam = new JButton("Physical Exam");
      JButton meds = new JButton("Medication");
      JButton orders = new JButton("Orders");
      JButton labRes = new JButton("Lab Results");
      JButton radRes = new JButton("Radiology Results");
      JButton asess = new JButton("Asessment");
      JButton probList = new JButton("Problem List");
      JButton diag = new JButton("Diagnoses");
      JButton vital = new JButton("Vital Signs");
      JButton addRemove = new JButton("Add/Remove Patient");
      JButton patientInfo = new JButton("Patient Information");
      JButton physRep = new JButton("Physician Reports");
      JButton inbox = new JButton("Inbox");
      JButton complaints = new JButton("Complaints");

      panel_2.add(patSearch);
      panel_2.add(regInfo);
      panel_2.add(patTrack);
      panel_2.add(phyExam);
      panel_2.add(meds);
      panel_2.add(orders);
      panel_2.add(labRes);
      panel_2.add(radRes);
      panel_2.add(asess);
      panel_2.add(probList);
      panel_2.add(diag);
      panel_2.add(vital);
      panel_2.add(addRemove);
      panel_2.add(patientInfo);
      panel_2.add(physRep);
      panel_2.add(inbox);
      panel_2.add(complaints);

      JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane_1.setBounds(220, 67, 1735, 920);
      frame.getContentPane().add(tabbedPane_1);

      PatientSearch patientSearch = new PatientSearch( tabbedPane_1 );
      patSearch.addActionListener(patientSearch);

      PatientInfo patInfAct = new PatientInfo( tabbedPane_1,
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "",
    		                                   "" );
      patientInfo.addActionListener(patInfAct);
   }
}
