import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HiloMario extends Thread {

	ArrayList<ImageIcon> lista = new ArrayList<ImageIcon> ();
	ArrayList<ImageIcon> leftlist = new ArrayList<ImageIcon> ();
	
	JLabel mario;
	
	int contador = 0;
	
	boolean mover = true;
	boolean direccion = false; 
	boolean salto = true;
	
	public HiloMario(JLabel label) {
		super();
		mario = label;
		ImageIcon im1 = new ImageIcon ("mario-1.jpg");
		ImageIcon im2 = new ImageIcon ("mario-2.jpg");
		ImageIcon im3 = new ImageIcon ("mario-3.jpg");
		lista.add(im1);
		lista.add(im2);
		lista.add(im3);
		
		ImageIcon im4 = new ImageIcon ("mario-12.jpg");
		ImageIcon im5 = new ImageIcon ("mario-12.jpg");
		ImageIcon im6 = new ImageIcon ("mario-12.jpg");
		
		leftlist.add(im4);
		leftlist.add(im5);
		leftlist.add(im6);
	}
	
	public void setMover(boolean mov, boolean direccion) {
		this.mover = mov;
		this.direccion = direccion;
	}
	
	public void setSalto(boolean jmp)
	{
		this.salto = jmp;
	}
	
	public void run()
	{
		while(true) {
			
			if(mover == true && direccion == false) {
				mario.setIcon(lista.get(contador));
				contador++;
				System.out.println("forward");
				if(contador==2)
				{
					contador = 0;
				}
					
			}
			
			if( mover == true && direccion == true) {
				mario.setIcon(leftlist.get(contador));
				contador++;
				System.out.println("behind");
				if(contador == 2) 
				{
					contador = 0;
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}