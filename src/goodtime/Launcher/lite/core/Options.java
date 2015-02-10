package goodtime.Launcher.lite.core;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Options extends JFrame {

	/**
	 * 
	 */
	public static Options optWindow = new Options();
	
	private static final long serialVersionUID = 2L;
	private JPanel contentPane = new JPanel();
	private JButton buttonSaveOptions = new JButton();
	private JButton buttonAbout = new JButton();
	
	private JLabel labelOption = new JLabel();
	private JLabel labelAdvOption = new JLabel();
	private JLabel labelUsername = new JLabel();
	private JLabel labelPassword = new JLabel();
	private JLabel labelMemory = new JLabel();
	private JLabel labelGameDir = new JLabel();
	private JLabel labelJavaPath = new JLabel();
	private JLabel labelJavaArgs = new JLabel();
	
	private JTextField textUsername = new JTextField();
	private JTextField textMemory = new JTextField();
	private JTextField textGameDir = new JTextField();
	private JTextField textJavaPath = new JTextField();
	private JTextField textJavaArgs = new JTextField();
	
	private JPasswordField password = new JPasswordField();
	
	private JCheckBox checkBoxOnline = new JCheckBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					optWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Options() {
		setTitle("\u8BBE\u7F6E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 400);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//button
		buttonSaveOptions.setBounds(464, 304, 100, 47);
		buttonSaveOptions.setText("±£´æÉèÖÃ");
		buttonSaveOptions.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		buttonAbout.setBounds(10, 304, 100, 47);
		buttonAbout.setText("¹ØÓÚ");
		buttonAbout.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		//label
		labelOption.setBounds(10, 10, 135, 20);
		labelOption.setText("ÉèÖÃ");
		labelOption.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		
		labelUsername.setBounds(10, 40, 135, 20);
		labelUsername.setText("ÓÃ»§Ãû");
		labelUsername.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		labelPassword.setBounds(10, 70, 135, 20);
		labelPassword.setText("ÃÜÂë");
		labelPassword.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		labelMemory.setBounds(10, 100, 135, 20);
		labelMemory.setText("×î´óÄÚ´æ");
		labelMemory.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		labelGameDir.setBounds(10, 130, 135, 20);
		labelGameDir.setText("ÓÎÏ·Ä¿Â¼ (°æ±¾¶ÀÁ¢)");
		labelGameDir.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		labelAdvOption.setBounds(10, 160, 135, 20);
		labelAdvOption.setText("¸ß¼¶ÉèÖÃ");
		labelAdvOption.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		
		labelJavaPath.setBounds(10, 190, 135, 20);
		labelJavaPath.setText("JavaÂ·¾¶");
		labelJavaPath.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		labelJavaArgs.setBounds(10, 220, 135, 20);
		labelJavaArgs.setText("Java¶îÍâ²ÎÊý");
		labelJavaArgs.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		//Text
		textUsername.setBounds(135, 40, 135, 20);
		textUsername.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		textMemory.setBounds(135, 100, 135, 20);
		textMemory.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		
		textGameDir.setBounds(135, 130, 235, 20);
		textGameDir.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textGameDir.setText("Áô¿ÕÎªÄ¬ÈÏÄ¿Â¼");
		textGameDir.setEditable(false);
		
		textJavaPath.setBounds(135, 190, 235, 20);
		textJavaPath.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textJavaPath.setText("×Ô¶¨ÒåJavaÄ¿Â¼£¬Áô¿ÕÎª×Ô¶¯Ñ°ÕÒJava");
		textJavaPath.setEditable(false);
		
		textJavaArgs.setBounds(135, 220, 235, 20);
		textJavaArgs.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textJavaArgs.setText("¸ß¼¶¹¦ÄÜ£¬¿ÉÄÜµ¼ÖÂÓÎÏ·±ÀÀ£");
		textJavaArgs.setEditable(false);
		
		//JPassword
		password.setBounds(135, 70, 135, 20);
		password.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		password.setEditable(false);
			
		//CheckBox
		checkBoxOnline.setBounds(270, 40, 100, 20);
		checkBoxOnline.setText("Õý°æµÇÂ¼");
		checkBoxOnline.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		checkBoxOnline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		//Add to Pane
		contentPane.add(buttonSaveOptions);
		contentPane.add(buttonAbout);
		
		contentPane.add(labelOption);
		contentPane.add(labelUsername);
		contentPane.add(labelPassword);
		contentPane.add(labelMemory);
		contentPane.add(labelGameDir);
		contentPane.add(labelAdvOption);
		contentPane.add(labelJavaPath);
		contentPane.add(labelJavaArgs);
		
		contentPane.add(textUsername);
		contentPane.add(textMemory);
		contentPane.add(textGameDir);
		contentPane.add(textJavaPath);
		contentPane.add(textJavaArgs);
		
		contentPane.add(password);
		
		contentPane.add(checkBoxOnline);
	}

}
