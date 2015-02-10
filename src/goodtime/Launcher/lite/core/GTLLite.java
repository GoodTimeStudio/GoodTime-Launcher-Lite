package goodtime.Launcher.lite.core;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GTLLite extends JFrame {

	/**
	 * 
	 */
	public static final GTLLite mainWindow = new GTLLite();
	
	private static final long serialVersionUID = 1L;
	private JPanel mainPane = new JPanel();
	
	private JButton buttonLauncher = new JButton();
	private JButton buttonOptions = new JButton();
	private JButton buttonDownload = new JButton();

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
		
		setTitle("GoodTime\u542F\u52A8\u5668 Lite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		

		buttonLauncher.setBounds(500, 387, 163, 84);
		buttonLauncher.setText("∆Ù∂Ø”Œœ∑");
		buttonLauncher.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 20));
		
		buttonOptions.setBounds(674, 434, 100, 37);
		buttonOptions.setText("…Ë÷√");
		buttonOptions.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		buttonDownload.setBounds(674, 387, 100, 37);
		buttonDownload.setText("œ¬‘ÿ”Œœ∑");
		buttonDownload.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 12));
		
		
		//Add to Plan
		mainPane.add(buttonLauncher);
		mainPane.add(buttonOptions);
		mainPane.add(buttonDownload);
	}
}
