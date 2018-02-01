
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.ButtonGroup;
import javax.swing.JMenuItem;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.JTextArea;
import java.awt.Choice;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.JRadioButton;

public class Allergies implements ActionListener {
	private JTabbedPane tabbedPane;
	
	Allergies( JTabbedPane tabbedPaneInput ) {
		this.tabbedPane = tabbedPaneInput;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel panel_1;
		JLabel lblNewLabel_2;
		JLabel lblNewLabel_3;
		JLabel lblNewLabel_4;
		JLabel lblNewLabel_5;
		JList list;
		JLabel lblNewLabel_6;
		JLabel lblNewLabel_7;
		JLabel lblNewLabel_8;
		JLabel lblNewLabel_9;
		JLabel lblNewLabel_10;
		JLabel lblNewLabel_11;
		JLabel lblNewLabel_12;
		JLabel lblNewLabel_13;
		JEditorPane editorPane_6;
		JComboBox comboBox;
		JComboBox comboBox_1;
		JComboBox comboBox_2;
		JTextField textField;
		JTextField textField_1;
		JTextField textField_3;
		JTextField textField_4;
		JTextField textField_5;
		JTextField textField_6;
		JTextField textField_7;
		JCheckBox chckbxNewCheckBox;
		JComboBox comboBox_3;
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Allergy", null, panel_1, null);
		panel_1.setLayout(null);
		
		list = new JList();
		list.setBounds(4, 17, 0, 0);
		panel_1.add(list);
		
		lblNewLabel_13 = new JLabel("Substance");
		lblNewLabel_13.setBounds(4, 9, 61, 16);
		panel_1.add(lblNewLabel_13);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 7, 114, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Type");
		lblNewLabel_12.setBounds(4, 41, 27, 16);
		panel_1.add(lblNewLabel_12);
		
		lblNewLabel_11 = new JLabel("Category");
		lblNewLabel_11.setBounds(4, 69, 51, 16);
		panel_1.add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 71, 114, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_10 = new JLabel("Severity");
		lblNewLabel_10.setBounds(4, 97, 46, 16);
		panel_1.add(lblNewLabel_10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Low", "Medium", "High", "Critical"}));
		comboBox_1.addContainerListener(new ContainerAdapter() {
			public void componentAdded(ContainerEvent arg0) {
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox_1.setBounds(133, 93, 90, 25);
		comboBox_1.setToolTipText("");
		panel_1.add(comboBox_1);
		
		lblNewLabel_9 = new JLabel("Reactions");
		lblNewLabel_9.setBounds(4, 125, 57, 16);
		panel_1.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(99, 123, 114, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Interaction");
		lblNewLabel_8.setBounds(4, 198, 61, 16);
		panel_1.add(lblNewLabel_8);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox_2.setBounds(133, 194, 80, 25);
		panel_1.add(comboBox_2);
		
		lblNewLabel_7 = new JLabel("Comment");
		lblNewLabel_7.setBounds(306, 102, 55, 16);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_7);
		
		editorPane_6 = new JEditorPane();
		editorPane_6.setBounds(420, 97, 106, 22);
		panel_1.add(editorPane_6);
		
		lblNewLabel_6 = new JLabel("Source");
		lblNewLabel_6.setBounds(4, 242, 41, 16);
		panel_1.add(lblNewLabel_6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Drug", "Food ", "Rhinitis", "Seasonal", "Skin", "Pet"}));
		comboBox.setBounds(133, 238, 100, 25);
		panel_1.add(comboBox);
		
		lblNewLabel_5 = new JLabel("Reaction Status");
		lblNewLabel_5.setBounds(4, 153, 90, 16);
		panel_1.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(420, 67, 114, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Reviewed By Who?");
		lblNewLabel_4.setBounds(306, 41, 108, 16);
		panel_1.add(lblNewLabel_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(420, 35, 114, 20);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Estimated Onset");
		lblNewLabel_3.setBounds(308, 69, 94, 16);
		panel_1.add(lblNewLabel_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(99, 155, 114, 20);
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Updated Time");
		lblNewLabel_2.setBounds(306, 9, 78, 16);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(420, 7, 114, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Show As Red");
		chckbxNewCheckBox.setBounds(4, 297, 100, 24);
		panel_1.add(chckbxNewCheckBox);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"FOOD", "Balsam of Peru", "Egg", "Fish or shellfish", "Fruit", "Gluten", "Garlic", "Hot peppers", "Oats", "Meat", "Milk", "Peanut", "Rice", "Sesame", "Soy", "Sulfites", "Tartrazine", "Tree nut", "Wheat", "", "DRUG", "Balsam of Peru", "Cephalosporins", "Dilantin", "Intravenous contrast dye", "Local anesthetics", "Non-Seroidal anti-inflammatories", "(Cromolyn sodium, nedocrmil sodium, etc.)", "Penicillin", "Sulfonamides", "Tegretol", "Tetracycline", "", "ENVIRONMENTAL", "Balsam of Peru", "Cat", "Chromium", "Cobalt Chloride", "Cosmetics", "Dog ", "Formaldehyde", "Fungicide", "Gold (gold sodium thiosulfate)", "House dust mite", "Insect Sting", "Latex", "Mold", "Nickel(nickel sulfate hexahydrate)", "Perfume", "Photographic developers", "Pollen", "Semen", "Water"}));
		comboBox_3.setBounds(133, 32, 150, 25);
		panel_1.add(comboBox_3);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(4, 380, 98, 26);
		panel_1.add(btnSave);
	}
}