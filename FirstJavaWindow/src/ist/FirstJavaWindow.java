package ist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstJavaWindow extends JPanel {

	//メンバ変数
	JFrame parent;
	int w=50,h=50; //時刻表の幅(width)と高さ(height)

	//最初に実行される
	public static void main(String[] args) {
		//まずウィンドウフレームを作成
		JFrame jf = new JFrame("ここはウィンドウタイトル");
		//つぎにウィンドウフレームに埋め込む，パネルを作成．フレームへの参照を一応もたせる
		FirstJavaWindow t = new FirstJavaWindow(jf);
		//ここで埋め込む
		jf.getContentPane().add(t);
		//フレームをパックすると，パネルのデフォルトサイズに合わせてフレームサイズを設定する
		jf.pack();
		//フレームを表示
		jf.setVisible(true);
	}
	
	//パネルのコンストラクタ
	public FirstJavaWindow(JFrame p){
		parent = p;
	}
	//パネルのデフォルトサイズはここで設定
	public Dimension getPreferredSize(){
		return new Dimension(w*6,h*6);
	}
	//パネル内の描画
	public void paint(Graphics g){
		g.setColor(Color.black);
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				g.drawRect(i*w, j*h, w, h);
			}
		}
		g.drawString("width = "+getWidth()+"  height = "+getHeight(), getWidth()/10, getHeight()/2);
	}
}
