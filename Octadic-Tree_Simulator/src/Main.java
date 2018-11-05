import java.awt.EventQueue;

import com.pack.binary.converter.binaryConverter;
import com.pack.colours.ColorInputTable;
import com.pack.colours.ColorValue;
import com.pack.frame.layout.ColorSimulator;
import com.pack.octadic.tree.function.OctadicTree;

public class Main {
	

	public static void main(String[] args) throws InterruptedException {

		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ColorSimulator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		int depth= 3;
		ColorInputTable inputColor = new ColorInputTable(3);
		inputColor.ColorInputValue(22, 22, 22, 0,1);
		inputColor.ColorInputValue(22, 22, 22, 1,1);
		inputColor.ColorInputValue(22, 22, 22, 2,1);
		inputColor.ColorInputValue(22, 22, 22, 3,1);
		inputColor.ColorInputValue(22, 22, 22, 4,1);
		inputColor.ColorInputValue(22, 22, 22, 5,1);
		inputColor.ColorInputValue(22, 22, 22, 6,1);
		inputColor.ColorInputValue(22, 22, 22, 7,1);
		inputColor.ColorInputValue(22, 22, 22, 8,1);
		
		
		OctadicTree octadicTreeAlgorith = new OctadicTree(depth,inputColor);

		
	}

}
