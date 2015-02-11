package goodtime.Launcher.lite.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;

import java.awt.event.MouseMotionAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import goodtime.Launcher.lite.config.Config;
import goodtime.Launcher.lite.config.Info;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Options extends JFrame {
	
	/**
	 * 
	 */
	public static Options optWindow = new Options();
	
	private static final long serialVersionUID = 2L;
	private OptionPanel contentPane = new OptionPanel();
	private final JPanel panel = new JPanel();
	
	private JButton buttonSaveOptions = new JButton();
	private JButton buttonAbout = new JButton();
	
	private JLabel labelOption = new JLabel();
	private JLabel labelAdvOption = new JLabel();
	private JLabel labelUsername = new JLabel();
	private JLabel labelPassword = new JLabel();
	private JLabel labelMemory = new JLabel();
	private JLabel labelJavaPath = new JLabel();
	private JLabel labelJavaArgs = new JLabel();
	
	private static JTextField textUsername;
	private static JTextField textMemory;
	private static JTextField textJavaPath;
	private static JTextField textJavaArgs;
	
	private static JPasswordField password;
	
	static String on;
	
	private JCheckBox checkBoxOnline = new JCheckBox();

	/**
	 * Launch the application.
	 */
	public static void main() {	
		
		try {
			if (Info.configPath.exists()) {
				new load();
			} else {
				Info.configPath.createNewFile();
				new save();
				Config.save();
			}
			textUsername.setText(Info.username);
			password.setText(Info.password);
			textMemory.setText(Info.memory);
			textJavaPath.setText(Info.javaPath);
			textJavaArgs.setText(Info.javaArgs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		optWindow.setVisible(true);
	}

	
	int mx, my, fx, fy;
	/**
	 * Create the frame.
	 */
	public Options() {
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(0, 0, 0, 0);
		setTitle("\u8BBE\u7F6E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 400);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				setLocation(fx + (arg0.getXOnScreen() - mx), fy + (arg0.getYOnScreen() - my));
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mx = arg0.getXOnScreen();
				my = arg0.getYOnScreen();
				fx = getX();
				fy = getY();
			}
		});
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel.setOpaque(false);
		panel.setLayout(null);
		
		buttonSaveOptions.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				Info.username = textUsername.getText();
				Info.password = password.getText();
				Info.memory = textMemory.getText();
				Info.javaPath = textJavaPath.getText();
				Info.javaArgs = textJavaArgs.getText();
				if (checkBoxOnline.isSelected()) {
					on = "true";
				}
				new save();
				Config.save();
				optWindow.dispose();
				optWindow.setVisible(false);
			}
		});
		
		buttonSaveOptions.setBounds(470, 303, 100, 47);
		buttonSaveOptions.setText("±£¥Ê…Ë÷√");
		buttonSaveOptions.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		buttonSaveOptions.setUI(new MyButtonUI());
		
		buttonAbout.setBounds(10, 303, 100, 47);
		buttonAbout.setText("πÿ”⁄");
		buttonAbout.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		buttonAbout.setUI(new MyButtonUI());
		
		labelUsername.setBounds(10, 10, 135, 20);
		labelUsername.setText("”√ªß√˚");
		labelUsername.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		labelPassword.setBounds(10, 40, 135, 20);
		labelPassword.setText("√‹¬Î");
		labelPassword.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		labelMemory.setBounds(10, 70, 135, 20);
		labelMemory.setText("◊Ó¥Ûƒ⁄¥Ê");
		labelMemory.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		labelAdvOption.setBounds(10, 130, 135, 20);
		labelAdvOption.setText("∏ﬂº∂…Ë÷√");
		labelAdvOption.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 18));
		
		labelJavaPath.setBounds(10, 160, 135, 20);
		labelJavaPath.setText("Java¬∑æ∂");
		labelJavaPath.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		labelJavaArgs.setBounds(10, 190, 135, 20);
		labelJavaArgs.setText("Java∂ÓÕ‚≤Œ ˝");
		labelJavaArgs.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		
		textUsername = new JTextField();
		textUsername.setBounds(135, 10, 135, 20);
		textUsername.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		textMemory = new JTextField();
		textMemory.setBounds(135, 70, 135, 20);
		textMemory.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		textJavaPath = new JTextField();
		textJavaPath.setBounds(135, 160, 235, 20);
		textJavaPath.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		textJavaArgs = new JTextField();
		textJavaArgs.setBounds(135, 190, 235, 20);
		textJavaArgs.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		password = new JPasswordField();
		password.setBounds(135, 40, 135, 20);
		password.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		password.setEditable(false);
		
		
		checkBoxOnline.setBounds(270, 10, 80, 20);
		checkBoxOnline.setText("’˝∞Êµ«¬º");
		checkBoxOnline.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		checkBoxOnline.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (checkBoxOnline.isSelected()) {
					password.setEditable(true);
				} else {
					password.setEditable(false);
				}
			}
		});
		labelOption.setForeground(Color.WHITE);


		labelOption.setText("…Ë÷√");
		labelOption.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 18));
		
		
		panel.add(buttonSaveOptions);
		panel.add(buttonAbout);
		panel.add(labelUsername);
		panel.add(labelPassword);
		panel.add(labelMemory);
		panel.add(labelAdvOption);
		panel.add(labelJavaPath);
		panel.add(labelJavaArgs);
		
		panel.add(textUsername);
		panel.add(textMemory);
		panel.add(textJavaPath);
		panel.add(textJavaArgs);
		
		panel.add(password);
		
		panel.add(checkBoxOnline);
		
		JButton exit = new JButton("X");
		exit.setForeground(Color.WHITE);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				optWindow.dispose();
				optWindow.setVisible(false);
			}
		});
		exit.setOpaque(false);
		exit.setUI(new MyButtonUI());
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(labelOption, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
					.addComponent(exit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(labelOption, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(exit))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		try {
			on = Config.getConfig("online");
			if (on.equals("true")) {
				checkBoxOnline.setSelected(true);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

class load {
	public load() {
		try {
			Info.username = Config.getConfig("username");
			Info.password = Config.getConfig("password");
			Info.memory = Config.getConfig("memory");
			Info.javaPath = Config.getConfig("javaPath");
			Info.javaArgs = Config.getConfig("args");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class save {
	public save() {
		try {
			Config.setConfig("username", Info.username);
			Config.setConfig("password", Info.password);
			Config.setConfig("memory", Info.memory);
			Config.setConfig("javaPath", Info.javaPath);
			Config.setConfig("args", Info.javaArgs);
			Config.setConfig("online", Options.on);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
