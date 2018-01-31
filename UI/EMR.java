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
      JButton visit = new JButton("Patient Visit");
      JButton labRes = new JButton("Lab Results");
      JButton radRes = new JButton("Radiology Results");
      JButton asess = new JButton("Asessment");
      JButton diag = new JButton("Diagnoses");
      JButton vital = new JButton("Vital Signs");
      JButton patientInfo = new JButton("Patient Information");
      JButton allergy = new JButton("Allergies");
      JButton dischargeButt = new JButton("Patient Discharge");

      panel_2.add(patSearch);
      panel_2.add(visit);
      panel_2.add(dischargeButt);
      panel_2.add(allergy);
      panel_2.add(labRes);
      panel_2.add(radRes);
      panel_2.add(asess);
      panel_2.add(diag);
      panel_2.add(vital);
      panel_2.add(patientInfo);

      JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
      tabbedPane_1.setBounds(220, 67, 1735, 920);
      frame.getContentPane().add(tabbedPane_1);

      Allergies allergies = new Allergies( tabbedPane_1 );
      allergy.addActionListener(allergies);

      PatientSearch patientSearch = new PatientSearch( tabbedPane_1 );
      patSearch.addActionListener(patientSearch);

      Visit visitAct = new Visit( tabbedPane_1 );
      visit.addActionListener(visitAct);

      Vitals vitals = new Vitals( tabbedPane_1 );
      vital.addActionListener(vitals);

      Assessment notes = new Assessment( tabbedPane_1 );
      asess.addActionListener( notes );

      Discharge discharge = new Discharge( tabbedPane_1 );
      dischargeButt.addActionListener(discharge);

      LabResults labResults = new LabResults( tabbedPane_1 );
      labRes.addActionListener(labResults);

      RadResults radResults = new RadResults( tabbedPane_1 );
      radRes.addActionListener(radResults);

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
    		                                   "",
    		                                   "" );
      patientInfo.addActionListener(patInfAct);
   }
}
