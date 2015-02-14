package goodtime.Launcher.lite.core;

import goodtime.Launcher.lite.config.Config;
import goodtime.Launcher.lite.config.Info;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class GTLLite extends JFrame {

	/**
	 * 
	 */
	public static final GTLLite mainWindow = new GTLLite();
	
	private static final long serialVersionUID = 1L;
	private MainPanel mainPane = new MainPanel();
	
	private JButton buttonLauncher;
	private JButton buttonOptions;
	private JButton buttonDownload;
	
	public static JComboBox<Object> selectVersion;

	int mx, my, fx, fy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GTLLite() {
		setUndecorated(true);
		
		setTitle("GoodTime\u542F\u52A8\u5668 Lite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		mainPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				setLocation(fx + (arg0.getXOnScreen() - mx), fy + (arg0.getYOnScreen() - my));
			}
		});
		mainPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mx = arg0.getXOnScreen();
				my = arg0.getYOnScreen();
				fx = getX();
				fy = getY();
			}
		});
		
		mainPane.setOpaque(false);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Info.version = selectVersion.getSelectedItem().toString();
					Config.setConfig("select", Info.version);
					Config.save();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnNewButton.setUI(new MyButtonUI());
		btnNewButton.setForeground(Color.WHITE);
		GroupLayout gl_mainPane = new GroupLayout(mainPane);
		gl_mainPane.setHorizontalGroup(
			gl_mainPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_mainPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(10))
		);
		gl_mainPane.setVerticalGroup(
			gl_mainPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(null);
		
		buttonDownload = new JButton();
		buttonDownload.setOpaque(false);
		buttonDownload.setBounds(668, 387, 112, 36);
		buttonDownload.setText("œ¬‘ÿ”Œœ∑");
		buttonDownload.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		buttonDownload.setUI(new MyButtonUI());
		
		buttonLauncher = new JButton();
		buttonLauncher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Info.getLaunchInfo();
				Launch.main(null);
			}
		});
		buttonLauncher.setOpaque(false);
		buttonLauncher.setBounds(508, 387, 148, 79);
		buttonLauncher.setText("∆Ù∂Ø”Œœ∑");
		buttonLauncher.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));
		buttonLauncher.setUI(new MyButtonUI());
		
		buttonOptions = new JButton();
		buttonOptions.setOpaque(false);
		buttonOptions.setBounds(668, 433, 112, 36);
		buttonOptions.setText("…Ë÷√");
		buttonOptions.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		buttonOptions.setUI(new MyButtonUI());
		buttonOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Options.main();
			}
		});
		
		selectVersion = new JComboBox<Object>();
		selectVersion.setBounds(508, 354, 272, 20);
		selectVersion.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		
		panel.add(buttonDownload);
		panel.add(buttonLauncher);
		panel.add(buttonOptions);
		panel.add(selectVersion);

		
		mainPane.setLayout(gl_mainPane);
		
		
		//==================================
		Info.findAllVersion();
		
		try {
			Info.version = Config.getConfig("select");
			selectVersion.setSelectedItem(Info.version);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
