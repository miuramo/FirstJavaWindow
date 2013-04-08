package ist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TimeTable extends JPanel {

	//メンバ変数
	JFrame parent;
	int w=100,h=50; //時刻表の幅(width)と高さ(height)
	ArrayList<Yotei> yotei;
	SimpleDateFormat sdf;

	//最初に実行される
	public static void main(String[] args) {
		JFrame jf = new JFrame("TimeTable");
		TimeTable t = new TimeTable(jf);
		jf.getContentPane().add(t);
		jf.pack();
		jf.setVisible(true);
	}
	public TimeTable(JFrame p){
		parent = p;
		yotei = new ArrayList<Yotei>();
		loadYotei();
		sdf = new SimpleDateFormat("F km");
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(w*6,h*6);
	}
	
	public void paint(Graphics g){
		String date = sdf.format(new Date());
		System.out.println(date);
		String[] dateary = date.split(" ");
		int youbi = Integer.parseInt(dateary[0])-1;
		int time = Integer.parseInt(dateary[1]);
		int jigen = 0;
//		if (850 <= time && time <= 1020) jigen = 1;
//		else if (1030 <= time && time <= 1200) jigen = 2;
//		else if (1300 <= time && time <= 1430) jigen = 3;
//		else if (1440 <= time && time <= 1610) jigen = 4;
//		else if (1620 <= time && time <= 1750) jigen = 5;
//		else if (1800 <= time && time <= 1930) jigen = 6;
//		else if (1940 <= time && time <= 2110) jigen = 7;
		if (time <= 1020) jigen = 1;
		else if (time <= 1200) jigen = 2;
		else if (time <= 1430) jigen = 3;
		else if (time <= 1610) jigen = 4;
		else if (time <= 1750) jigen = 5;
		else if (time <= 1930) jigen = 6;
		else if (time <= 2110) jigen = 7;

		g.setColor(Color.yellow);
		g.fillRect(youbi*w, jigen*h, w, h);
		
		g.setColor(Color.black);
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				g.drawRect(i*w, j*h, w, h);
			}
		}
		for(Yotei y: yotei){
			y.draw(g,w,h);
		}		
	}
	void loadYotei(){
		ArrayList<String> lines = FileReadWriter.getLinesList("data.txt");
		for(String l:lines){
			if (l.startsWith("#")) continue; //#ではじまっていたらコメントとしてスキップ
			String[] ary = l.split(" ");
			if (ary.length < 5) continue; //空行など，要素が5つなければスキップ
			Yotei y = new Yotei(ary);
			yotei.add(y);
			System.out.println(y.toString());
		}
	}
}
