package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Choice;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.DefaultComboBoxModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.SystemColor;


public class Order {

	private JFrame frmOrder;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
					window.frmOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrder = new JFrame();
		frmOrder.setResizable(false);
		frmOrder.setTitle("Order");
		frmOrder.setBounds(100, 100, 1610, 900);
		frmOrder.getContentPane().setLayout(null);
		
		Label label = new Label("Search");
		label.setBounds(1375, 24, 62, 22);
		frmOrder.getContentPane().add(label);
		
		Choice choice = new Choice();
		choice.setBounds(1472, 24, 112, 20);
		frmOrder.getContentPane().add(choice);
		
		JPanel panel = new JPanel();
		panel.setBounds(721, 509, 832, 321);
		frmOrder.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label label_1 = new Label("Dose");
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		label_1.setBounds(109, 38, 38, 22);
		panel.add(label_1);
		
		Label label_2 = new Label("Route of Adminstration");
		label_2.setFont(new Font("Dialog", Font.BOLD, 12));
		label_2.setBounds(10, 64, 137, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("PRN");
		label_3.setBounds(121, 88, 26, 22);
		panel.add(label_3);
		
		JLabel lblInfuseOverUnit = new JLabel("Infuse over unit");
		lblInfuseOverUnit.setBounds(70, 116, 77, 14);
		panel.add(lblInfuseOverUnit);
		
		JLabel lblPriorexStat = new JLabel("Prior (ex: STAT or NOW)");
		lblPriorexStat.setBounds(24, 142, 125, 14);
		panel.add(lblPriorexStat);
		
		JLabel lblRequestedStartDatetime = new JLabel("Requested Start Date/Time");
		lblRequestedStartDatetime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRequestedStartDatetime.setBounds(10, 168, 137, 14);
		panel.add(lblRequestedStartDatetime);
		
		JLabel lblNewLabel = new JLabel("Drug Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(500, 38, 62, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Frequency");
		lblNewLabel_1.setBounds(510, 64, 52, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Duration");
		lblNewLabel_2.setBounds(511, 90, 51, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions");
		lblSpecialInstructions.setBounds(465, 116, 99, 14);
		panel.add(lblSpecialInstructions);
		
		JLabel lblStopType = new JLabel("Stop type");
		lblStopType.setBounds(515, 142, 47, 14);
		panel.add(lblStopType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox_1.setBounds(153, 38, 133, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"a", "a", "c", "d", "e", "f", "j", "h", "e"}));
		comboBox_2.setBounds(153, 66, 133, 20);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(153, 90, 133, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(153, 116, 133, 20);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Stat", "Now"}));
		comboBox_5.setBounds(153, 142, 133, 20);
		panel.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(153, 168, 133, 20);
		panel.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(568, 38, 133, 20);
		panel.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(568, 64, 133, 20);
		panel.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(568, 90, 133, 20);
		panel.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(568, 113, 133, 20);
		panel.add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(568, 139, 133, 20);
		panel.add(comboBox_11);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(568, 165, 133, 20);
		panel.add(comboBox_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(98, 208, 286, 550);
		frmOrder.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTree tree = new JTree();
		tree.setShowsRootHandles(true);
		tree.setForeground(Color.WHITE);
		tree.setBackground(new Color(32, 178, 170));
		tree.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("View") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Plans");
						node_1.add(new DefaultMutableTreeNode("Medical"));
						node_1.add(new DefaultMutableTreeNode("Subphases"));
						node_1.add(new DefaultMutableTreeNode("Interdisciplinary"));
						node_1.add(new DefaultMutableTreeNode(""));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Orders");
						node_1.add(new DefaultMutableTreeNode("Admit/Transfer/Discharge"));
						node_1.add(new DefaultMutableTreeNode("Diet/Nutrition"));
						node_1.add(new DefaultMutableTreeNode("Laboratory"));
						node_1.add(new DefaultMutableTreeNode("Alerts"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Medication History");
						node_1.add(new DefaultMutableTreeNode("Medication History Snapshot"));
					add(node_1);
				}
			}
		));
		tree.setBounds(10, 0, 266, 501);
		panel_1.add(tree);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(721, 208, 832, 243);
		frmOrder.getContentPane().add(panel_2);
	}
}
