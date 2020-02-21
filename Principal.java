import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Timer; 
import java.util.TimerTask;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel etiqueta;
	private JLabel Imagen_fondo;
	private ImageIcon imagen;
	private ImageIcon imagen_fondo;
	private HiloMario hm;
	private Timer timer;
	private JTextField Cronometro;
	
	private HiloReloj tiempo;
		
	public class Helper extends TimerTask
	{
		public int arriba = 0;
		public double abajo = 0;
		public void run()
		{
			if (arriba < 5) {
				etiqueta.setBounds(etiqueta.getBounds().x, etiqueta.getBounds().y-20, etiqueta.getBounds().width, etiqueta.getBounds().height);
				arriba++;
			}
			
			else if(abajo < 5) {
				etiqueta.setBounds(etiqueta.getBounds().x, etiqueta.getBounds().y+20, etiqueta.getBounds().width, etiqueta.getBounds().height);
				abajo++;
			}
			else if (abajo == 0) {
				timer.cancel();
			}
			
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg) {
				switch(arg.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					hm.setMover(true, true);
					etiqueta.setBounds(etiqueta.getBounds().x-11, etiqueta.getBounds().y, etiqueta.getBounds().width, etiqueta.getBounds().height);
					break;
					
				case KeyEvent.VK_RIGHT:
					hm.setMover(true, false);
					etiqueta.setBounds(etiqueta.getBounds().x+11, etiqueta.getBounds().y, etiqueta.getBounds().width, etiqueta.getBounds().height);
					break;
					
				case KeyEvent.VK_SPACE:	
					Timer timer = new Timer();
					TimerTask task = new Helper();
					
					timer.schedule(task, 200,40);
					
					break;
					
				case KeyEvent.VK_DOWN:
					etiqueta.setBounds(etiqueta.getBounds().x, etiqueta.getBounds().y+20, etiqueta.getBounds().width, etiqueta.getBounds().height);
					break;
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				hm.setMover(false, false);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1355, 1046);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		imagen = new ImageIcon("mario-1.jpg");
		imagen_fondo = new ImageIcon("fondo.jpg");
		
		etiqueta = new JLabel(imagen);
		hm = new HiloMario(etiqueta);
		hm.setMover(false, false);
		hm.start();
		etiqueta.setBounds(62, 632, 90, 120);
		contentPane.add(etiqueta);
		
		Imagen_fondo = new JLabel(imagen_fondo);
		Imagen_fondo.setBounds(0, 0, 1327, 967);
		contentPane.add(Imagen_fondo);
		
		Cronometro = new JTextField();
		Cronometro.setBounds(12, 13, 116, 22);
		contentPane.add(Cronometro);
		Cronometro.setColumns(10);
		Cronometro.enable(false);
		
		tiempo = new HiloReloj(Cronometro);
		tiempo.start();
	}
}
