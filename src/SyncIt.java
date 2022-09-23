import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SyncIt implements Runnable {
public String title;
public static int height,width;
public static Thread thread;
private BufferStrategy bs;
public Framed f;
public static Graphics g;
public static int[] black_initializer = new int[8],white_initializer=new int[8];
public static int y=width,x=0,p=0,j=-80,chance=1;;
static WPlayer w1;static BPlayer b1;Color xx,c,t;
public static boolean isEnem=false;
public static ArrayList<Integer> kni,kni2,platformx,platformy,kngx,kngy;

public SyncIt(int width,int height){
this.width=width;
this.height=height;
new Elements();
w1 = new WPlayer();
t=new Color(55,152,211);
c=new Color(0,128,0);
xx = new Color(51,0,0);


w1.eposx=0;w1.hposx=80;w1.cposx=160;w1.kposx=240;w1.qposx=320;
w1.eposy=0;w1.hposy=0;w1.cposy=0;w1.kposy=0;w1.qposy=0;

w1.eposx1=560;w1.hposx1=480;w1.cposx1=400;
w1.eposy1=0;w1.hposy1=0;w1.cposy1=0;
platformx = new ArrayList<Integer>();
platformy = new ArrayList<Integer>();
kngx = new ArrayList<Integer>();
kngy = new ArrayList<Integer>();


kni = new ArrayList<Integer>();
kni2 = new ArrayList<Integer>();

kni.add(w1.k1x= 0);kni.add(w1.k1y= 80);kni.add(w1.k2x= 80);kni.add(w1.k2y=80) ;kni.add(w1.k3x= 160);kni.add(w1.k3y=80) ;
kni.add(w1.k4x= 240);kni.add(w1.k4y=80);kni.add(w1.k5x= 320);kni.add(w1.k5y=80);kni.add(w1.k6x= 400);
kni.add(w1.k6y= 80);kni.add(w1.k7x=480) ;kni.add(w1.k7y=80) ;kni.add(w1.k8x= 560);kni.add(w1.k8y=80) ;

b1= new BPlayer();
b1.eposx=0;b1.hposx=80;b1.cposx=160;b1.kposx=240;b1.qposx=320;
b1.eposy=560;b1.hposy=560;b1.cposy=560;b1.kposy=560;b1.qposy=560;

b1.eposx1=560; b1.hposx1=480; b1.cposx1=400;
b1.eposy1=560; b1.hposy1=560; b1.cposy1=560;

kni2.add(b1.k1x= 0);kni2.add(b1.k1y= 480);kni2.add(b1.k2x= 80);kni2.add(b1.k2y=480) ;kni2.add(b1.k3x= 160);
kni2.add(b1.k3y=480 );kni2.add(b1.k4x= 240);kni2.add(b1.k4y=480) ;kni2.add(b1.k5x= 320);kni2.add(b1.k5y=480) ;
kni2.add(b1.k6x= 400);kni2.add(b1.k6y= 480);kni2.add(b1.k7x=480) ;kni2.add(b1.k7y=480) ;
kni2.add(b1.k8x= 560);kni2.add(b1.k8y=480) ;

f = new Framed(width,height);

start();
}

public void init(){
f.display();
f.getCanvas().addMouseListener(new Moused());
while(true){
render();
}
}

@Override
public void run() {
JOptionPane.showMessageDialog(null, "Instruction:\n1. Once the knight is clicked,no other move can be made"
		+ "\n2. Enjoy\nDeveloped By: Aman Kothiyal");
init();	
}

public void start(){

thread=new Thread(this);
thread.start();
}

public void render(){
bs = Framed.getCanvas().getBufferStrategy();
if (bs==null){
Framed.getCanvas().createBufferStrategy(3);
return;
}
g=bs.getDrawGraphics();


g.clearRect(0,0,width,height);
g.setColor(Color.decode("000061"));
if(chance==0)f.getFrame().setTitle("Black's Turn");
else f.getFrame().setTitle("White's Turn");
for(int i=0;i<width;){
	if(p==0){g.setColor(Color.white);p=1;}else{g.setColor(xx); p=0;}
	j+=80;
if(j>width){
	j=-80;i+=80;
	if(p==0){g.setColor(Color.white);p=1;}else{g.setColor(xx); p=0;}
}
try{
for(int p=0;(p<platformx.size() && p<platformy.size());p++){
	if(platformx.get(p)!=null)
	if((int)platformx.get(p)==i && (int)platformy.get(p)==j){
		g.setColor(c);break;}
}}catch(Exception e){}
try{
for(int p=0;(p<kngx.size() && p<kngy.size());p++){
	if((int)kngx.get(p)==i && (int)kngy.get(p)==j){
		g.setColor(t);break;}
}}catch(Exception e){}

if(j<width){
g.fillRect(i, j, 80, 80);
checkForWhite(i,j);
checkForBlack(i,j);
}isEnem=false;
}

bs.show();
g.dispose();
}

public void checkForWhite(int x,int y){
	if(chance==0){
		if(g.getColor()==c){
			isEnem=true;
		}
	}
	
	WPlayer ws = w1;
	char s='s',y1='w';
	if(p==0)s='b'; else s='w';
	if(ws.cposx==x && ws.cposy==y){
		g.drawImage(WPlayer.camelPosition(y1,s),x,y,null);
	}else if(ws.cposx1==x && ws.cposy1==y){
		g.drawImage(WPlayer.camelPosition(y1,s),x,y,null);
	}else if(ws.eposx==x && ws.eposy==y){
		g.drawImage(WPlayer.elephantPosition(y1,s),x,y,null);
	}else if(ws.eposx1==x && ws.eposy1==y){
		g.drawImage(WPlayer.elephantPosition(y1,s),x,y,null);
	}else if(ws.hposx==x && ws.hposy==y){
		g.drawImage(WPlayer.horsePosition(y1,s),x,y,null);
	}else if(ws.hposx1==x && ws.hposy1==y){
		g.drawImage(WPlayer.horsePosition(y1,s),x,y,null);
	}else if(ws.kposx==x && ws.kposy==y){
		if(g.getColor()==t && chance==1)g.drawImage(WPlayer.kingPosition(y1,'k'),x,y,null);
		else
		g.drawImage(WPlayer.kingPosition(y1,s),x,y,null);
	}else if(ws.qposx==x && ws.qposy==y){
		g.drawImage(WPlayer.queenPosition(y1,s),x,y,null);
	}else if(ws.k1x==x && ws.k1y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k2x==x && ws.k2y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k3x==x && ws.k3y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k4x==x && ws.k4y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k5x==x && ws.k5y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k6x==x && ws.k6y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k7x==x && ws.k7y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k8x==x && ws.k8y==y){
		g.drawImage(WPlayer.warriorPosition(y1,s),x,y,null);
	}
}

public void checkForBlack(int x,int y){
	if(chance==1){
		if(g.getColor()==c){
			isEnem=true;
		}
	}
	BPlayer ws = b1;
	char s='s',y1='b';
	if(p==0)s='b'; else s='w';
	if(ws.cposx==x && ws.cposy==y){
		g.drawImage(BPlayer.camelPosition(y1,s),x,y,null);
	}else if(ws.cposx1==x && ws.cposy1==y){
		g.drawImage(BPlayer.camelPosition(y1,s),x,y,null);
	}else if(ws.eposx==x && ws.eposy==y){
		g.drawImage(BPlayer.elephantPosition(y1,s),x,y,null);
	}else if(ws.eposx1==x && ws.eposy1==y){
		g.drawImage(BPlayer.elephantPosition(y1,s),x,y,null);
	}else if(ws.hposx==x && ws.hposy==y){
		g.drawImage(BPlayer.horsePosition(y1,s),x,y,null);
	}else if(ws.hposx1==x && ws.hposy1==y){
		g.drawImage(BPlayer.horsePosition(y1,s),x,y,null);
	}else if(ws.kposx==x && ws.kposy==y){
		if(g.getColor()==t && chance==0)g.drawImage(WPlayer.kingPosition(y1,'k'),x,y,null);
		else
		g.drawImage(BPlayer.kingPosition(y1,s),x,y,null);
	}else if(ws.qposx==x && ws.qposy==y){
		g.drawImage(BPlayer.queenPosition(y1,s),x,y,null);
	}else if(ws.k1x==x && ws.k1y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k2x==x && ws.k2y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k3x==x && ws.k3y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k4x==x && ws.k4y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k5x==x && ws.k5y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k6x==x && ws.k6y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k7x==x && ws.k7y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}else if(ws.k8x==x && ws.k8y==y){
		g.drawImage(BPlayer.warriorPosition(y1,s),x,y,null);
	}
}
}
