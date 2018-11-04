import java.awt.EventQueue;

import com.pack.frame.layout.ColorSimulator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ColorSimulator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
