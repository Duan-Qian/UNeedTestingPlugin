package uneedtestingplugin;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import uneedtestingplugin.DataBase.MD5;
import uneedtestingplugin.DataBase.UserDao;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Monitor;

public class Popout {

	public void loginForm() {
	    Display display = Display.getDefault();
	    display.asyncExec(() -> {
		    Shell shell = new Shell(display);
		
		    // get the size of the screen
		    Monitor primary = display.getPrimaryMonitor();
		    Rectangle bounds = primary.getBounds();
		
		    shell.setLocation(bounds.width/2 - 100, bounds.height/2 - 50);
		    shell.setText("UNeedTesting");
			shell.setLayout(new GridLayout(2, false));
			shell.setSize(300,150);
			Label hey = new Label(shell, SWT.CENTER);
			hey.setText("Hello!");
		    Label warnL = new Label(shell, SWT.CENTER);
		    warnL.setText("Please log in!");
		    
		    Label label1, label2;
			Text username;
			Text password;
			UserDao userDao = new UserDao();

			label1 = new Label(shell, SWT.NULL);
			label1.setText("User Name: ");
				
			username = new Text(shell, SWT.SINGLE | SWT.BORDER);
			username.setText("");
			username.setTextLimit(30);
				
			label2 = new Label(shell, SWT.NULL);
			label2.setText("Password: ");
				
			password = new Text(shell, SWT.SINGLE | SWT.BORDER);
			System.out.println(password.getEchoChar());
			password.setEchoChar('*');
			password.setTextLimit(30);
				
			Button button = new Button(shell, SWT.PUSH | SWT.CENTER);
			button.setText("Submit");
			button.addListener(SWT.Selection, new Listener(){
				public void handleEvent(Event event) {
					String selected = username.getText();
					String selected1 = password.getText();
						
					if (selected == ""){
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
						messageBox.setMessage("Enter the User Name");
						messageBox.open();
					} else if (selected1 == ""){
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING | SWT.CANCEL);
						messageBox.setMessage("Enter the Password");
						messageBox.open();
					} else if (userDao.verfyUser(selected, MD5.transMD5(selected1))){
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.CANCEL);
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
						
						shell.dispose();	
						
					} else {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.CANCEL);
						messageBox.setMessage("Wrong Password!");
						messageBox.open();
					}
				}
			});
			username.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		    shell.open();
		    while (!shell.isDisposed()) {
		      if (!display.readAndDispatch())
		        display.sleep();
		    }
	    });
	}
}