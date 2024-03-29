package ist;

import java.awt.Graphics;

public class Yotei {
	int youbi;
	int jigen;
	String lecture;
	String name;
	String place;
	
	//こっちのコンストラクタはつかっていない
	public Yotei(int y, int j, String lec, String n){
		youbi = y;
		jigen = j;
		lecture = lec;
		name = n;
	}
	//こっちをつかっている
	public Yotei(String[] ary){
		lecture = ary[3];
		name = ary[2];
		place = ary[4];
		youbi = "日月火水木金土".indexOf(ary[0]);
		jigen = "０１２３４５６７８９".indexOf(ary[1]);
	}
	public String toString(){
		return new String(youbi+" "+jigen+" "+name+" "+lecture+" "+place);
	}

	public void draw(Graphics g, int w, int h) {
		g.drawString(lecture+" "+name, youbi*w+5, jigen*h+20);
	}
}
