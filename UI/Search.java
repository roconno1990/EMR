package UI;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swt.LoadPatients;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search {

	private JFrame frmSearch;
	private javax.swing.JTable JTable;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
					window.frmSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection=null;
	private JList list;
	private JScrollPane scrollPane;
	/**
	 * Create the application.
	 */
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setResizable(false);
		frmSearch.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmSearch.setTitle("Search");
		frmSearch.setBounds(100, 100, 555, 354);
		
		JButton btnLoadPatients = new JButton("Load Patients");	
			btnLoadPatients.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DefaultListModel DLM=new DefaultListModel();
					DLM.addElement("MRN                                    First Name                    	       Last Name                                      Visit Reason");
					DLM.addElement("01                                      Triumfia                                 Fulks                                                    Migranes");
					DLM.addElement("02                                       Felicia                                 Pounds                                                  Back Pain");
					DLM.addElement("03                                       Joshua                                  Chambers                                                     Clot");
					DLM.addElement("04                                       Ryan                                     O'Connor                                                      	 Flu");
					list.setModel(DLM);
					
					
				}
			});
			frmSearch.getContentPane().setLayout(null);
			btnLoadPatients.setBounds(0, 0, 549, 23);
			frmSearch.getContentPane().add(btnLoadPatients);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 23, 549, 302);
			frmSearch.getContentPane().add(scrollPane);
			
			list = new JList();
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
							LoadPatients nw = new LoadPatients();
							nw.NewScreen();
				}
			});
			scrollPane.setViewportView(list);
			list.setLayoutOrientation(JList.VERTICAL_WRAP);
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
	}

	
