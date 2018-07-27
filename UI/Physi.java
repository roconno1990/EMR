package UI;

import java.lang.Object;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;

import java.awt.Frame;

import org.eclipse.swt.awt.SWT_AWT;

import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.sql.ConnectionEvent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.core.internal.registry.Contribution;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ArmEvent;
import org.eclipse.swt.events.ArmListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.custom.SashForm;

import swing2swt.layout.BoxLayout;
import java.awt.FileDialog;

import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Label;

import org.eclipse.wb.swt.DischargeReadiness;
import org.eclipse.wb.swt.About;
import org.eclipse.wb.swt.Depart;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.Scan;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Decorations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.awt.Desktop;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;

import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import javax.swing.JFrame;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;



public class Physi{
	public Physi() {
	}
	

	public Shell shlEmrPhysicianView;
	private Text text_LoadPatients;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
			Physi window = new Physi();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		
				
				
		Display display = Display.getDefault();
		createContents();
		shlEmrPhysicianView.open();
		shlEmrPhysicianView.layout();
		while (!shlEmrPhysicianView.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEmrPhysicianView = new Shell();
		shlEmrPhysicianView.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\TH047345\\Pictures\\cnhu.png"));
		shlEmrPhysicianView.setSize(1484, 670);
		shlEmrPhysicianView.setText("EMR Physician View");
		shlEmrPhysicianView.setLayout(new FormLayout());
		shlEmrPhysicianView.setFullScreen(true);

		
		Menu menu = new Menu(shlEmrPhysicianView, SWT.BAR);
		shlEmrPhysicianView.setMenuBar(menu);
		
		MenuItem mntmTask = new MenuItem(menu, SWT.CASCADE);
		mntmTask.setText("Task");
		
		Menu menu_1 = new Menu(mntmTask);
		mntmTask.setMenu(menu_1);
		
		MenuItem mntmPrint = new MenuItem(menu_1, SWT.NONE);
		mntmPrint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
										PrinterJob job = PrinterJob.getPrinterJob();
										
										boolean ok = job.printDialog();
										if (ok) {
											try {
												job.print();
											} catch (PrinterException arg) {
											}
										}
									}
								});
		
		
		
		
		mntmPrint.setText("Print");

		MenuItem mntmScan = new MenuItem(menu_1, SWT.NONE);
		mntmScan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Scan nw = new Scan();
				nw.NewScreen();

			}
		});
		
		mntmScan.setText("Scan");
		
		
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
							 {
							 System.exit(0);
							 }
							 }	
						
					}
				);
		
		
		mntmExit.setText("Exit");
		
		MenuItem mntmAbout = new MenuItem(menu, SWT.CASCADE);
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
						About nw = new About();
						nw.NewScreen();	
			}
		});
		mntmAbout.setText("About");
		
		
		Button btnMedicalLibrary = new Button(shlEmrPhysicianView, SWT.NONE);
		FormData fd_btnMedicalLibrary = new FormData();
		fd_btnMedicalLibrary.left = new FormAttachment(0, 10);
		btnMedicalLibrary.setLayoutData(fd_btnMedicalLibrary);
		
		btnMedicalLibrary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.ncbi.nlm.nih.gov/pubmed/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnMedicalLibrary.setText("Medical Library");
		
		Button btnCommunication = new Button(shlEmrPhysicianView, SWT.NONE);
		fd_btnMedicalLibrary.top = new FormAttachment(btnCommunication, 0, SWT.TOP);
		fd_btnMedicalLibrary.right = new FormAttachment(btnCommunication, -6);
		FormData fd_btnCommunication = new FormData();
		fd_btnCommunication.right = new FormAttachment(0, 244);
		fd_btnCommunication.top = new FormAttachment(0, 10);
		fd_btnCommunication.left = new FormAttachment(0, 130);
		btnCommunication.setLayoutData(fd_btnCommunication);
		btnCommunication.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
					d.browse(new URI("https://www.ipswitch.com/moveit-transfer"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCommunication.setText("Communication");
		
		Button btnCalculator = new Button(shlEmrPhysicianView, SWT.NONE);
		FormData fd_btnCalculator = new FormData();
		fd_btnCalculator.right = new FormAttachment(0, 480);
		fd_btnCalculator.top = new FormAttachment(0, 10);
		btnCalculator.setLayoutData(fd_btnCalculator);
		btnCalculator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Calc nw = new Calc();
				nw.NewScreen();	
			}
		});
		btnCalculator.setText("Calculator");
		
		
		
		Button btnHippa = new Button(shlEmrPhysicianView, SWT.NONE);
		fd_btnCalculator.left = new FormAttachment(btnHippa, 6);
		FormData fd_btnHippa = new FormData();
		fd_btnHippa.right = new FormAttachment(0, 364);
		fd_btnHippa.top = new FormAttachment(0, 10);
		fd_btnHippa.left = new FormAttachment(0, 250);
		btnHippa.setLayoutData(fd_btnHippa);
		btnHippa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
						Desktop d = Desktop.getDesktop();
						try {
							d.browse(new URI("https://www.hhs.gov/hipaa/for-professionals/privacy/laws-regulations/index.html"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
		btnHippa.setText("HIPPA");
		
		ViewForm viewForm_5 = new ViewForm(shlEmrPhysicianView, SWT.NONE);
		FormData fd_viewForm_5 = new FormData();
		fd_viewForm_5.top = new FormAttachment(0, 100);
		fd_viewForm_5.left = new FormAttachment(0, 91);
		viewForm_5.setLayoutData(fd_viewForm_5);
		
		// might decide to you this option later instead of doubleclicking 
		/*text_LoadPatients = new Text(shlEmrPhysicianView, SWT.BORDER);
		text_LoadPatients.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				Search nw = new Search();
				nw.NewScreen();
	
			}
		}); 
		text_LoadPatients.setToolTipText("");
		text_LoadPatients.setBounds(1774, 14, 76, 21);*/
		
		Button btnPatients = new Button(shlEmrPhysicianView, SWT.NONE);
		FormData fd_btnPatients = new FormData();
		fd_btnPatients.bottom = new FormAttachment(0, 34);
		fd_btnPatients.right = new FormAttachment(0, 1458);
		fd_btnPatients.top = new FormAttachment(0, 9);
		fd_btnPatients.left = new FormAttachment(0, 1292);
		btnPatients.setLayoutData(fd_btnPatients);
		btnPatients.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Jtable_Load_Clear_Data nw = new Jtable_Load_Clear_Data();
				nw.NewScreen();
			}
		});
		
		btnPatients.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		btnPatients.setText("Load Patients");
		
		Button btnLogout = new Button(shlEmrPhysicianView, SWT.NONE);
		btnLogout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				 {
				 System.exit(0);
				 }
				 }	
			
		
			
		});
	
		FormData fd_btnLogout = new FormData();
		fd_btnLogout.left = new FormAttachment(btnCalculator, 6);
		fd_btnLogout.right = new FormAttachment(btnCalculator, 123, SWT.RIGHT);
		fd_btnLogout.top = new FormAttachment(btnMedicalLibrary, 0, SWT.TOP);
		btnLogout.setLayoutData(fd_btnLogout);
		btnLogout.setText("Sign Out");

	}

	public Window getframe() {
		// TODO Auto-generated method stub
		return null;
		
	}
}
