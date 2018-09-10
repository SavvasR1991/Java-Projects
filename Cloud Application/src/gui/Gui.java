/*
 * @Copyrights 2014
 * Authors : Melina Rousia
 * 		     Savvas Rostantis
 * 		     Marios Gavriil
 */

package gui;

import Database.Database;
import Settings.Settings;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Gui {
	public JFrame jframe;
	JTextField textXcoordinate, textYcoordinate, textUsername;
	Database database = Database.getInstance();
	long gui_refresh = Settings.getInstance().getGui_Refresh();
	JTextArea textAreaUser;
	JTextArea textAreaOverall;
	JTextArea textAreaCoordinates;

	/*
	 * Gui initialization
	 */

	public Gui() {
		jframe = new JFrame("Administrator's Interface ");
		jframe.setSize(640, 480);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(jframe.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								628, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								446, Short.MAX_VALUE).addContainerGap()));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Statistics", null, panel, null);

		JButton buttonRefGui = new JButton("Refresh Gui");

		textAreaOverall = new JTextArea();
		textAreaOverall.setWrapStyleWord(true);
		textAreaOverall.setEditable(false);
		GroupLayout panel_2 = new GroupLayout(panel);

		panel_2.setHorizontalGroup(panel_2
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						panel_2.createSequentialGroup()
								.addContainerGap(144, Short.MAX_VALUE)
								.addGroup(
										panel_2.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														Alignment.TRAILING,
														panel_2.createSequentialGroup()
																.addComponent(
																		buttonRefGui,
																		GroupLayout.PREFERRED_SIZE,
																		160,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(234))
												.addGroup(
														Alignment.TRAILING,
														panel_2.createSequentialGroup()
																.addComponent(
																		textAreaOverall,
																		GroupLayout.PREFERRED_SIZE,
																		321,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(142)))));

		panel_2.setVerticalGroup(panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(
						panel_2.createSequentialGroup()
								.addGap(46)
								.addComponent(textAreaOverall,
										GroupLayout.PREFERRED_SIZE,193,
										GroupLayout.PREFERRED_SIZE).addGap(56)
								.addComponent(buttonRefGui,
										GroupLayout.PREFERRED_SIZE,75,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(75, Short.MAX_VALUE)));

		panel.setLayout(panel_2);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("User info", null, panel_1, null);

		JButton buttonDel = new JButton("Delete User");

		textUsername = new JTextField();
		textUsername.setText("Username");
		textUsername.setColumns(10);

		JLabel labelUser = new JLabel("Type Username");

		JLabel labelPoi = new JLabel("Or type POI coordinates");

		textXcoordinate = new JTextField();
		textXcoordinate.setText("xcoordinate");
		textXcoordinate.setColumns(10);

		textYcoordinate = new JTextField();
		textYcoordinate.setText("yCoordinate");
		textYcoordinate.setColumns(10);

		JButton buttonUser = new JButton("Select User");

		JButton buttoncoord = new JButton("Select Coordinates");

		JButton buttonRef = new JButton("Refresh Gui");

		textAreaUser = new JTextArea();
		textAreaCoordinates = new JTextArea();
		GroupLayout panel_2_1 = new GroupLayout(panel_1);

		panel_2_1
				.setHorizontalGroup(panel_2_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								panel_2_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panel_2_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																labelUser,
																GroupLayout.PREFERRED_SIZE,
																116,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textUsername,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textXcoordinate,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																labelPoi,
																GroupLayout.PREFERRED_SIZE,
																161,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																panel_2_1
																		.createSequentialGroup()
																		.addComponent(
																				buttonUser)
																		.addGap(18)
																		.addComponent(
																				buttonDel))
														.addComponent(
																textYcoordinate,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 73,
												Short.MAX_VALUE)
										.addGroup(
												panel_2_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textAreaUser,
																GroupLayout.PREFERRED_SIZE,
																255,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textAreaCoordinates,
																GroupLayout.PREFERRED_SIZE,
																255,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18))
						.addGroup(
								panel_2_1.createSequentialGroup()
										.addComponent(buttoncoord)
										.addContainerGap(446, Short.MAX_VALUE))
						.addGroup(
								panel_2_1
										.createSequentialGroup()
										.addGap(176)
										.addComponent(buttonRef,
												GroupLayout.PREFERRED_SIZE,
												218, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(213, Short.MAX_VALUE)));

		panel_2_1
				.setVerticalGroup(panel_2_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								panel_2_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												panel_2_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																panel_2_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				labelUser)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textUsername,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addGroup(
																				panel_2_1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								buttonUser)
																						.addComponent(
																								buttonDel))
																		.addGap(18)
																		.addComponent(
																				labelPoi)
																		.addGap(18)
																		.addComponent(
																				textXcoordinate,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				textYcoordinate,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				buttoncoord))
														.addGroup(
																panel_2_1
																		.createSequentialGroup()
																		.addGap(18)
																		.addComponent(
																				textAreaUser,
																				GroupLayout.PREFERRED_SIZE,
																				165,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				textAreaCoordinates,
																				GroupLayout.PREFERRED_SIZE,
																				97,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)))
										.addPreferredGap(
												ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(buttonRef,
												GroupLayout.PREFERRED_SIZE, 48,
												GroupLayout.PREFERRED_SIZE)));
		panel_1.setLayout(panel_2_1);

		jframe.getContentPane().setLayout(groupLayout);

		buttonUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent su) {
				String username = textUsername.getText();
				if (!username.equals("Username")) {
					String pr = Database.getInstance().usInfo(username);
					textAreaUser.setText(pr);
				}
			}
		});

		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent du) {
				String del = textUsername.getText();
				if (!del.equals("Username")) {
					Database.getInstance().deleteUser(del);
				}
			}
		});

		buttoncoord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent coo) {
				String x = textXcoordinate.getText();
				String y = textYcoordinate.getText();
				if ((!x.equals("xcoordinate")) && (!y.equals("yCoordinate"))) {
					float xaxis = Float.parseFloat(x);
					float yaxis = Float.parseFloat(y);
					String xy = Database.getInstance().koko(xaxis, yaxis);
					textAreaCoordinates.setText(xy);
				}
			}
		});
		buttonRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ref) {
				String username = textUsername.getText();
				if (!username.equals("Username")) {
					String pr = Database.getInstance().usInfo(username);
					textAreaUser.setText(pr);
				}
				String x = textXcoordinate.getText();
				String y = textYcoordinate.getText();
				if ((!x.equals("xcoordinate")) && (!y.equals("yCoordinate"))) {
					float xaxis = Float.parseFloat(x);
					float yaxis = Float.parseFloat(y);
					String xy = Database.getInstance().koko(xaxis, yaxis);
					textAreaCoordinates.setText(xy);
				}
			}
		});

		buttonRefGui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent re) {
				String getset = String.valueOf(Database.getInstance()
						.fCounter());
				textAreaOverall
						.setText("The aggregate calls of setMonitorData \n"
								+ " and getMapData per hour are " + getset
								+ " /h \n\n\n\n");
				String set = String.valueOf(Database.getInstance().sCounter());
				textAreaOverall.append("The aggregate calls of \n"
						+ "setMonitorData ONLY\n" + "per hour are : " + set
						+ " /h");
			}
		});

		ActionListener secondTab = new ActionListener() {
			public void actionPerformed(ActionEvent refresh) {
				String username = textUsername.getText();
				if (!username.equals("Username")) {
					String pr = Database.getInstance().usInfo(username);
					textAreaUser.setText(pr);
				}
				String x = textXcoordinate.getText();
				String y = textYcoordinate.getText();
				if ((!x.equals("xcoordinate")) && (!y.equals("yCoordinate"))) {
					float xaxis = Float.parseFloat(x);
					float yaxis = Float.parseFloat(y);
					String xy = Database.getInstance().koko(xaxis, yaxis);
					textAreaCoordinates.setText(xy);
				}
			}
		};
		Timer displayTimer = new Timer(Settings.getInstance().getGui_Refresh(), secondTab);
		displayTimer.start();

		ActionListener firstTab = new ActionListener() {
			public void actionPerformed(ActionEvent refreshgui) {
				String getset = String.valueOf(Database.getInstance()
						.fCounter());
				textAreaOverall
						.setText("The aggregate calls of setMonitorData \n"
								+ " and getMapData per hour are " + getset
								+ " /h \n\n\n\n");
				String set = String.valueOf(Database.getInstance().sCounter());
				textAreaOverall.append("The aggregate calls of \n"
						+ "setMonitorData ONLY\n" + "per hour are : " + set
						+ " /h");
			}
		};
		Timer refreshTimer = new Timer(Settings.getInstance().getGui_Refresh(), firstTab);
		refreshTimer.start();

	}

}
