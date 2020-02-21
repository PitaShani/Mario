import javax.swing.JTextField;

public class HiloReloj extends Thread {

	public int cronometro;
	public JTextField q;
	
	public HiloReloj(JTextField cuadrito) {
		super();
		q = cuadrito;
		cronometro = 400;
		q.enable(false);
	}
	
	public void run() {
		while(true) {
			q.setText(""+cronometro);
			cronometro--;
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 q.setText("t" + cronometro);
		}
		
	}

}
