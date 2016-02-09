/*File:Exercise9.java
 *-------------------
 *Creates a GraphicProgram that draws a 6 color rainbow
 *over a Cyan colored sky. The graphic will only depict
 *the top portion of all circles created to generate the
 *"rainbow" from visible arcs of circles that stay out
 *of view.
 *-'Clipping' allows circles to be seen as only arc in graphic
 *window.
 */

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class Rainbow extends GraphicsProgram {
	
	public void run() {
		GRect sky = new GRect(0,0,760,500);
		sky.setColor(Color.CYAN);
		sky.setFilled(true);
		sky.setFillColor(Color.CYAN);
		add(sky);
		
		GOval red = new GOval(10,120,740,740);
		red.setColor(Color.RED);
		red.setFilled(true);
		red.setFillColor(Color.RED);
		add(red);
		
		GOval orange = new GOval(40,150,680,680);
		orange.setColor(Color.ORANGE);
		orange.setFilled(true);
		orange.setFillColor(Color.ORANGE);
		add(orange);
		
		GOval yellow = new GOval(70,180,620,620);
		yellow.setColor(Color.YELLOW);
		yellow.setFilled(true);
		yellow.setFillColor(Color.YELLOW);
		add(yellow);
		
		GOval green = new GOval(100,210,560,560);
		green.setColor(Color.GREEN);
		green.setFilled(true);
		green.setFillColor(Color.GREEN);
		add(green);
		
		GOval blue = new GOval(130,240,500,500);
		blue.setColor(Color.BLUE);
		blue.setFilled(true);
		blue.setFillColor(Color.BLUE);
		add(blue);
		
		GOval magenta = new GOval(160,270,440,440);
		magenta.setColor(Color.MAGENTA);
		magenta.setFilled(true);
		magenta.setFillColor(Color.MAGENTA);
		add(magenta);
		
		GOval cyan = new GOval(190,300,380,380);
		cyan.setColor(Color.CYAN);
		cyan.setFilled(true);
		cyan.setFillColor(Color.CYAN);
		add(cyan);
	}
	
}