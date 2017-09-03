package uneedtestingplugin;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jdt.junit.JUnitCore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.TitleEvent;
import org.eclipse.swt.browser.TitleListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.osgi.framework.BundleContext;

import uneedtestingplugin.DataBase.MD5;
//import uneedtestingplugin.DataBase.NewUser;
import uneedtestingplugin.DataBase.UserDao;
import uneedtestingplugin.Modal.ProcessData;
import uneedtestingplugin.Modal.TestResult;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	private Image pluginIcon;
	private TrayItem trayItem;

	// The plug-in ID
	public static final String PLUGIN_ID = "UNeedTestingPlugin"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		final Display display = Display.getDefault();
		
		// instance TestRunListener
		TestResult testResult = new TestResult();
		
		// call TestRunListenrer, get testing result
		JUnitCore.addTestRunListener(testResult);
		
		display.asyncExec(() -> {
			pluginIcon = new Image(display, Activator.class.getResourceAsStream("/icons/U.png"));
			Tray tray = display.getSystemTray();
			if (tray != null && pluginIcon != null) {
				trayItem = new TrayItem(tray, SWT.NONE);
				trayItem.setToolTipText("UNeedTesting");
				trayItem.setVisible(true);
				trayItem.setText("UNeedTesting");
				trayItem.setImage(pluginIcon);
			}
			
			trayItem.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					final Shell dashboard = new Shell(trayItem.getDisplay(), SWT.SHELL_TRIM);
					dashboard.setLayout(new GridLayout(1, false));
					dashboard.setText("UNeedTesting");
				    // get the size of the screen
				    Monitor currentScreen = display.getPrimaryMonitor();
				    Rectangle bounds = currentScreen.getBounds();
				    dashboard.setSize(300, 100);
				    dashboard.setLocation(bounds.width/2 - 100, bounds.height/2 - 50);
				    
				 // get current user name
					ProcessData pt = new ProcessData();
					String username = pt.readUsername();
					
					Label uname = new Label(dashboard, SWT.CENTER);
					uname.setText("Current User: " + username);
					
					Button changeUser = new Button(dashboard, SWT.PUSH);
					changeUser.setText("Change User");
					changeUser.addListener(SWT.Selection, new Listener(){
						public void handleEvent(Event event) {
							dashboard.close();
							
							// open login form
							Shell loginForm = new Shell(trayItem.getDisplay(), SWT.SHELL_TRIM);
						    loginForm.setLocation(bounds.width/2 - 100, bounds.height/2 - 50);
						    loginForm.setSize(300, 100);
						    
							Label label1, label2;
							Text username;
							Text password;
							UserDao userDao = new UserDao();
				
							loginForm.setLayout(new GridLayout(2, false));
							loginForm.setText("Login Form");
							label1 = new Label(loginForm, SWT.NULL);
							label1.setText("User Name: ");
								
							username = new Text(loginForm, SWT.SINGLE | SWT.BORDER);
							username.setText("");
							username.setTextLimit(30);
								
							label2 = new Label(loginForm, SWT.NULL);
							label2.setText("Password: ");
								
							password = new Text(loginForm, SWT.SINGLE | SWT.BORDER);
							System.out.println(password.getEchoChar());
							password.setEchoChar('*');
							password.setTextLimit(30);
								
							Button button = new Button(loginForm, SWT.PUSH);
							button.setText("Submit");
							button.addListener(SWT.Selection, new Listener(){
								public void handleEvent(Event event) {
									String selected = username.getText();
									String selected1 = password.getText();
										
									if (selected == ""){
										MessageBox messageBox = new MessageBox(loginForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
										messageBox.setMessage("Enter the User Name");
										messageBox.open();
									} else if (selected1 == ""){
										MessageBox messageBox = new MessageBox(loginForm, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
										messageBox.setMessage("Enter the Password");
										messageBox.open();
									} else if (userDao.verfyUser(selected, MD5.transMD5(selected1))){
										MessageBox messageBox = new MessageBox(loginForm, SWT.OK | SWT.CANCEL);
										messageBox.setText("Login Form");
										messageBox.setMessage("Welcome: " + username.getText());
										messageBox.open();
										
										// save current user name into a text file
										try{
										    PrintWriter writer = new PrintWriter("currentuser.txt");
										    writer.print(username.getText());
										    writer.close();
										    System.out.println("saved user: " + username.getText());
										} catch (IOException e) {
										    System.out.println("write failed");
										}
										
										// update user rank and points
										int points = userDao.sumPoints(selected);
										userDao.updatePoints(selected, points);
										
										int rank = userDao.rankUser(selected);
										userDao.updateRank(selected, rank);
										
										loginForm.dispose();
										
									} else {
										MessageBox messageBox = new MessageBox(loginForm, SWT.OK | SWT.CANCEL);
										messageBox.setMessage("Wrong Password!");
										messageBox.open();
									}
								}
							});
							username.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
							password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
							  
							loginForm.pack();
							loginForm.open();
								  
							while (!loginForm.isDisposed()) {
								if (!display.readAndDispatch()) {
									display.sleep();
								}
							}
						}
					});
					
					Button openDash = new Button(dashboard, SWT.PUSH);
					openDash.setText("Open Dashboard");
					openDash.addListener(SWT.Selection, new Listener(){
						public void handleEvent(Event event){
							dashboard.close();
							// open browser
							Shell webpage = new Shell (trayItem.getDisplay(), SWT.SHELL_TRIM);
							webpage.setText("UNeedTesting");
							webpage.setLayout(new FillLayout());
							webpage.setBounds(10,10,800,600);
							Browser browser = new Browser(webpage, SWT.NONE);
							browser.addTitleListener(new TitleListener() {
								public void changed(TitleEvent event) {
									webpage.setText(event.title);
								}
							});
							browser.setBounds(0,0,800,800);
//							dashboard.pack();
							webpage.open();
							browser.setUrl("http://143.167.9.202:8080/UNeedTestingWeb/");
							while(!webpage.isDisposed())
								if (!display.readAndDispatch())
									display.sleep();	
						}
					});
					  
					dashboard.pack();
					dashboard.open();
						  
					while (!dashboard.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
				}
			});
		});	
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
