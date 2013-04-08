package ist;

import java.awt.Graphics;

public class Yotei {
	int youbi;
	int jigen;
	String lecture;
	String name;
	String place;
	
	//�������̃R���X�g���N�^�͂����Ă��Ȃ�
	public Yotei(int y, int j, String lec, String n){
		youbi = y;
		jigen = j;
		lecture = lec;
		name = n;
	}
	//�������������Ă���
	public Yotei(String[] ary){
		lecture = ary[3];
		name = ary[2];
		place = ary[4];
		youbi = "�����ΐ��؋��y".indexOf(ary[0]);
		jigen = "�O�P�Q�R�S�T�U�V�W�X".indexOf(ary[1]);
	}
	public String toString(){
		return new String(youbi+" "+jigen+" "+name+" "+lecture+" "+place);
	}

	public void draw(Graphics g, int w, int h) {
		g.drawString(lecture+" "+name, youbi*w+5, jigen*h+20);
	}
}
