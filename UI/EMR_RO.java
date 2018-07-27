package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JList;


public class EMR_RO {

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
            	EMR_RO window = new EMR_RO();
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
   public EMR_RO() {
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
      JButton pCharges = new JButton("Patient Charges");

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
      panel_2.add(pCharges);

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

      PatientCharges patientCharges = new PatientCharges( tabbedPane_1 );
      pCharges.addActionListener(patientCharges);

      JPanel panel = new JPanel();
	  tabbedPane_1.addTab("Home", null, panel, null);
  
    
      JFrame frame_2 = new JFrame();
      JTable table = new JTable();
       
     
      Object[] columns = {"MRN", "First Name", "Last Name", "Age"};
      DefaultTableModel model = new DefaultTableModel();
      model.setColumnIdentifiers(columns);
      table.setModel(model);
     
      table.setBackground(Color.black);
      table.setForeground(Color.white);
      Font font = new Font("", 1, 22);
      table.setFont(font);
      table.setRowHeight(30);
     
      JTextField textMRN = new JTextField();
      JTextField textFname = new JTextField();
      JTextField textLname = new JTextField();
      JTextField textAge = new JTextField();
      JTextField textAddress = new JTextField();

      JButton btnAdd = new JButton ("Add");
      JButton btnDelete = new JButton ("Delete");
      JButton btnUpdate = new JButton ("Update");
     
      textMRN.setBounds(20, 220, 100, 25);
      textFname.setBounds(20, 250, 100, 25);
      textLname.setBounds(20, 280, 100, 25);
      textAge.setBounds(20, 310, 100, 25);
     
      btnAdd.setBounds(150, 220, 100, 25);
      btnUpdate.setBounds(150, 265, 100, 25);
      btnDelete.setBounds(150, 310, 100, 25);
     
      JScrollPane pane = new JScrollPane(table);
      pane.setBounds(0, 0, 880, 200);
     
      frame_2.getContentPane().setLayout(null);
     
      frame_2.getContentPane().add(pane);
     
      frame_2.getContentPane().add(textMRN);
      frame_2.getContentPane().add(textFname);
      frame_2.getContentPane().add(textLname);
      frame_2.getContentPane().add(textAge);
     
      frame_2.getContentPane().add(btnAdd);
      frame_2.getContentPane().add(btnDelete);
      frame_2.getContentPane().add(btnUpdate);
      
      Object[] row = new Object[4]; 
      btnAdd.addActionListener(new ActionListener(){
  
           @Override
           public void actionPerformed(ActionEvent e){
            
               row[0] = textMRN.getText();
               row[1] = textFname.getText();
               row[2] = textLname.getText();
               row[3] = textAge.getText();
          
            
               model.addRow(row);
           }
       });
          
          
     btnDelete.addActionListener(new ActionListener(){
     
           @Override
           public void actionPerformed(ActionEvent e) {
           
               int i = table.getSelectedRow();
               if(i >= 0){
                   model.removeRow(i);
                }
                else{
                   System.out.println("Delete Error");
                }
            }
       });

      table.addMouseListener(new MouseAdapter() {
      
      @Override
      public void mouseClicked(MouseEvent e){
      
           int i = table.getSelectedRow();
           textMRN.setText(model.getValueAt(i, 0).toString());
           textFname.setText(model.getValueAt(i, 1).toString());
           textLname.setText(model.getValueAt(i, 2).toString());
           textAge.setText(model.getValueAt(i, 3).toString());
      
      }
      });
      
      
      btnUpdate.addActionListener(new ActionListener(){
      
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        
		        int i = table.getSelectedRow();
		        
		        if (i >= 0)
		        {
		          model.setValueAt(textMRN.getText(), i, 0);
		          model.setValueAt(textFname.getText(), i, 1);
		          model.setValueAt(textLname.getText(), i, 2);
		          model.setValueAt(textAge.getText(), i, 3);
		        }
		        
		        else{
		        	System.out.println("Update Error");
		        }
	        }
      });
      
      
      frame_2.setSize(900, 400);
      frame_2.setLocationRelativeTo(null);
      frame_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame_2.setVisible(true); 
   }
}
