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

	//�����o�ϐ�
	JFrame parent;
	int w=50,h=50; //�����\�̕�(width)�ƍ���(height)

	//�ŏ��Ɏ��s�����
	public static void main(String[] args) {
		//�܂��E�B���h�E�t���[�����쐬
		JFrame jf = new JFrame("�����̓E�B���h�E�^�C�g��");
		//���ɃE�B���h�E�t���[���ɖ��ߍ��ށC�p�l�����쐬�D�t���[���ւ̎Q�Ƃ��ꉞ��������
		FirstJavaWindow t = new FirstJavaWindow(jf);
		//�����Ŗ��ߍ���
		jf.getContentPane().add(t);
		//�t���[�����p�b�N����ƁC�p�l���̃f�t�H���g�T�C�Y�ɍ��킹�ăt���[���T�C�Y��ݒ肷��
		jf.pack();
		//�t���[����\��
		jf.setVisible(true);
	}
	
	//�p�l���̃R���X�g���N�^
	public FirstJavaWindow(JFrame p){
		parent = p;
	}
	//�p�l���̃f�t�H���g�T�C�Y�͂����Őݒ�
	public Dimension getPreferredSize(){
		return new Dimension(w*6,h*6);
	}
	//�p�l�����̕`��
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
