import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Moused extends MouseAdapter {
	int p = 0, pos, i,a,b,c,d,g,gg;
	String element,killed;
	static int temp=0;int savedx,savedy,savedkx,savedky;
	public boolean include,alreadyAttacked;
	boolean found = false, camel, king, queen, elephant, horse, d1, d2, enemy = false,go_on=true;

///////////////////////////////////////////////////////.........New Method...................................
public void mouseClicked(MouseEvent e) {
		if (isPresent(e.getX(), e.getY()) && p == 0) {
				if(SyncIt.chance==0){
					if(king){element="k";savedx=SyncIt.b1.kposx;savedy=SyncIt.b1.kposy;}
					else if(queen){element="q";savedx=SyncIt.b1.qposx;savedy=SyncIt.b1.qposy;}
					else if(horse && d1){element="h1";savedx=SyncIt.b1.hposx;savedy=SyncIt.b1.hposy;}
					else if(horse && d2){element="h2";savedx=SyncIt.b1.hposx1;savedy=SyncIt.b1.hposy1;}
					else if(camel && d1){element="c1";savedx=SyncIt.b1.cposx;savedy=SyncIt.b1.cposy;}
					else if(camel && d2){element="c2";savedx=SyncIt.b1.cposx1;savedy=SyncIt.b1.cposy1;}
					else if(elephant && d1){element="e1";savedx=SyncIt.b1.eposx;savedy=SyncIt.b1.eposy;}
					else if(elephant && d2){element="e2";savedx=SyncIt.b1.eposx1;savedy=SyncIt.b1.eposy1;}
				}else{
					if(king){element="k";savedx=SyncIt.w1.kposx;savedy=SyncIt.w1.kposy;}
					else if(queen){element="q";savedx=SyncIt.w1.qposx;savedy=SyncIt.w1.qposy;}
					else if(horse && d1){element="h1";savedx=SyncIt.w1.hposx;savedy=SyncIt.w1.hposy;}
					else if(horse && d2){element="h2";savedx=SyncIt.w1.hposx1;savedy=SyncIt.w1.hposy1;}
					else if(camel && d1){element="c1";savedx=SyncIt.w1.cposx;savedy=SyncIt.w1.cposy;}
					else if(camel && d2){element="c2";savedx=SyncIt.w1.cposx1;savedy=SyncIt.w1.cposy1;}
					else if(elephant && d1){element="e1";savedx=SyncIt.w1.eposx;savedy=SyncIt.w1.eposy;}
					else if(elephant && d2){element="e2";savedx=SyncIt.w1.eposx1;savedy=SyncIt.w1.eposy1;}
				}
			if(king){
				isKingTargeted(80*(e.getX()/80), 80*(e.getY()/80));
				if(checkKing(80*(e.getX()/80), 80*(e.getY()/80))){
					alreadyAttacked=true;
					a=80*(e.getX()/80);b=80*(e.getY()/80);
					SyncIt.kngx.clear();SyncIt.kngy.clear();
				}else{
					SyncIt.kngx.clear();SyncIt.kngy.clear();
				}
			}
			
			checkForPosition(80 * (e.getX() / 80), 80 * (e.getY() / 80));
			if (!SyncIt.platformx.isEmpty())
				p++;
		}
		if (p == 1) {
			if(SyncIt.chance==0 && (compared(e.getX(),e.getY(),SyncIt.b1.qposx,SyncIt.b1.qposy)||compared(e.getX(),e.getY(),SyncIt.b1.cposx1,SyncIt.b1.cposy1)||
						compared(e.getX(),e.getY(),SyncIt.b1.kposx,SyncIt.b1.kposy)||compared(e.getX(),e.getY(),SyncIt.b1.eposx,SyncIt.b1.eposy)||
						compared(e.getX(),e.getY(),SyncIt.b1.hposx,SyncIt.b1.hposy)||compared(e.getX(),e.getY(),SyncIt.b1.cposx,SyncIt.b1.cposy)||
						compared(e.getX(),e.getY(),SyncIt.b1.hposx1,SyncIt.b1.hposy1)||compared(e.getX(),e.getY(),SyncIt.b1.eposx1,SyncIt.b1.eposy1))){
					temp++;
					if(temp>1){
						p =0;
						reset();
					}
			}if(SyncIt.chance==1 && (compared(e.getX(),e.getY(),SyncIt.w1.qposx,SyncIt.w1.qposy)||compared(e.getX(),e.getY(),SyncIt.w1.cposx1,SyncIt.w1.cposy1)||
						compared(e.getX(),e.getY(),SyncIt.w1.kposx,SyncIt.w1.kposy)||compared(e.getX(),e.getY(),SyncIt.w1.eposx,SyncIt.w1.eposy)||
						compared(e.getX(),e.getY(),SyncIt.w1.hposx,SyncIt.w1.hposy)||compared(e.getX(),e.getY(),SyncIt.w1.cposx,SyncIt.w1.cposy)||
						compared(e.getX(),e.getY(),SyncIt.w1.hposx1,SyncIt.w1.hposy1)||compared(e.getX(),e.getY(),SyncIt.w1.eposx1,SyncIt.w1.eposy1))){
					temp++;
					if(temp>1){
						p=0; 
						reset();
					}
				}
			boolean s=true;
			if(king)isKingTargeted(80 * (e.getX() / 80), 80 * (e.getY() / 80));
			if(alreadyAttacked && checkKing(80 * (e.getX() / 80), 80 * (e.getY() / 80))){
				if(SyncIt.chance==0){
					SyncIt.b1.kposx=a;
					SyncIt.b1.kposy=b;
				}else{
					SyncIt.w1.kposx=a;
					SyncIt.w1.kposy=b;
				}
			}else if(checkKing(80 * (e.getX() / 80), 80 * (e.getY() / 80))){
				if(SyncIt.chance==0)SyncIt.chance=1;else SyncIt.chance=0;
				p+=3;
				s=false;
				reset();
			}
			if(s)
			if (valid(e.getX(), e.getY()) && !SyncIt.platformx.isEmpty()) {
				p += 2;
				reset();
			}
		}
		if (p == 2) {
			for (int j = 0; j < SyncIt.platformx.size(); j++) {
				if (80 * (e.getX() / 80) == SyncIt.platformx.get(j)
						&& 80 * (e.getY() / 80) == SyncIt.platformy.get(j)) {
					compareAndKill(SyncIt.platformx.get(j), SyncIt.platformy.get(j));
					found = false;
					if (pos == 1) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k1x = SyncIt.platformx.get(j);
							SyncIt.w1.k1y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							
							SyncIt.b1.k1x = SyncIt.platformx.get(j);
							SyncIt.b1.k1y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 2) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k2x = SyncIt.platformx.get(j);
							SyncIt.w1.k2y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k2x = SyncIt.platformx.get(j);
							SyncIt.b1.k2y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 3) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k3x = SyncIt.platformx.get(j);
							SyncIt.w1.k3y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k3x = SyncIt.platformx.get(j);
							SyncIt.b1.k3y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 4) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k4x = SyncIt.platformx.get(j);
							SyncIt.w1.k4y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k4x = SyncIt.platformx.get(j);
							SyncIt.b1.k4y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 5) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k5x = SyncIt.platformx.get(j);
							SyncIt.w1.k5y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k5x = SyncIt.platformx.get(j);
							SyncIt.b1.k5y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 6) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k6x = SyncIt.platformx.get(j);
							SyncIt.w1.k6y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k6x = SyncIt.platformx.get(j);
							SyncIt.b1.k6y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 7) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k7x = SyncIt.platformx.get(j);
							SyncIt.w1.k7y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k7x = SyncIt.platformx.get(j);
							SyncIt.b1.k7y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					} else if (pos == 8) {
						if (SyncIt.chance == 1) {
							SyncIt.w1.k8x = SyncIt.platformx.get(j);
							SyncIt.w1.k8y = SyncIt.platformy.get(j);
							SyncIt.kni.set(i, SyncIt.platformx.get(j));
							SyncIt.kni.set(i + 1, SyncIt.platformy.get(j));
						} else {
							SyncIt.b1.k8x = SyncIt.platformx.get(j);
							SyncIt.b1.k8y = SyncIt.platformy.get(j);
							SyncIt.kni2.set(i, SyncIt.platformx.get(j));
							SyncIt.kni2.set(i + 1, SyncIt.platformy.get(j));
						}
					}
					SyncIt.platformx.clear();
					SyncIt.platformy.clear();
					p+=3;
				}
			}
			found = false;
		}
		if (SyncIt.chance == 1) {
			if (p == 0) {
				pos = 0;
				for (i = 0; i <= SyncIt.kni.size() - 1; i += 2) {
					if (e.getX() >= SyncIt.kni.get(i) && e.getX() <= SyncIt.kni.get(i) + 80
							&& e.getY() >= SyncIt.kni.get(i + 1) && e.getY() <= SyncIt.kni.get(i + 1) + 80) {
						pos++;
							element = pos+"";
							savedx=SyncIt.kni.get((pos-1)*2);
							savedy=SyncIt.kni.get((pos-1)*2+1);
							g=i;
						found = true;
						break;
					} else
						pos++;
				}

				setKnights(80 * (e.getX() / 80), 80 * (e.getY() / 80));
				found = false;
			}
		} else {

			if (p == 0) {

				pos = 0;
				for (i = 0; i <= SyncIt.kni2.size() - 1; i += 2) {
					if (e.getX() >= SyncIt.kni2.get(i) && e.getX() <= SyncIt.kni2.get(i) + 80
							&& e.getY() >= SyncIt.kni2.get(i + 1) && e.getY() <= SyncIt.kni2.get(i + 1) + 80) {
						pos++;
							element = pos+"";
								savedx=SyncIt.kni2.get((pos-1)*2);
								savedy=SyncIt.kni2.get((pos-1)*2+1);g=i;
						found = true;
						break;
					} else
						pos++;
				}

				setKnights(80 * (e.getX() / 80), 80 * (e.getY() / 80));
				found = false;
			}

		}
		if(p>2){
		if (SyncIt.chance == 0){
			isKingTargeted(SyncIt.b1.kposx,SyncIt.b1.kposy);
			if(checkKing(SyncIt.b1.kposx,SyncIt.b1.kposy)){
				reverse(); 
				JOptionPane.showMessageDialog(null, "king under attack","CAN'T MOVE",JOptionPane.WARNING_MESSAGE);
				go_on=false;
			}
			else{
				go_on=true;
			}
				
		}else{
			isKingTargeted(SyncIt.w1.kposx,SyncIt.w1.kposy);
			if(checkKing(SyncIt.w1.kposx,SyncIt.w1.kposy)){
				reverse();
				JOptionPane.showMessageDialog(null, "king under attack","CAN'T MOVE",JOptionPane.WARNING_MESSAGE);
				go_on=false;
			}
			else{
				go_on=true;
			}
		}			
		SyncIt.kngx.clear();SyncIt.kngy.clear();
		}
		
		if (p > 2) {
			p = 0;
			if (SyncIt.chance == 0 && go_on){
				i=-1;a=-1;b=-1;c=-1;d=-1;g=-1;gg=-1;
				savedx=-1;savedy=-1;savedkx=-1;savedky=-1;
				SyncIt.chance = 1;
			}
			else{
				if(go_on){
				i=-1;a=-1;b=-1;c=-1;d=-1;g=-1;gg=-1;
				savedx=-1;savedy=-1;savedkx=-1;savedky=-1;
				SyncIt.chance = 0;}
				}
			}
	}

///////////////////////////////////////////////////////.........New Method...................................
public void recover(){
	if(SyncIt.chance==0){
			isKingTargeted(SyncIt.b1.kposx,SyncIt.b1.kposy);
			if(checkKing(SyncIt.b1.kposx,SyncIt.b1.kposy)){
				reverse();
			}
	}else{
			isKingTargeted(SyncIt.w1.kposx,SyncIt.w1.kposy);
			if(checkKing(SyncIt.w1.kposx,SyncIt.w1.kposy)){
				reverse();
			}
		}
	SyncIt.kngx.clear();SyncIt.kngy.clear();
}


public void reverse(){
	if(SyncIt.chance==0){
		if(element=="k"){
			SyncIt.b1.kposx=savedx;
			SyncIt.b1.kposy=savedy;
		}else if(element=="q"){
			SyncIt.b1.qposx=savedx;
			SyncIt.b1.qposy=savedy;
		}else if(element=="h1"){
			SyncIt.b1.hposx=savedx;
			SyncIt.b1.hposy=savedy;
		}else if(element=="h2"){
			SyncIt.b1.hposx1=savedx;
			SyncIt.b1.hposy1=savedy;
		}else if(element=="c1"){
			SyncIt.b1.cposx=savedx;
			SyncIt.b1.cposy=savedy;
		}else if(element=="c2"){
			SyncIt.b1.cposx1=savedx;
			SyncIt.b1.cposy1=savedy;
		}else if(element=="e1"){
			SyncIt.b1.eposx=savedx;
			SyncIt.b1.eposy=savedy;
		}else if(element=="e2"){
			SyncIt.b1.eposx1=savedx;
			SyncIt.b1.eposy1=savedy;
		}else{
		int ss=-1;
		try{
		ss = Integer.parseInt(element.charAt(element.length()-1)+"");
		}catch(Exception ee){}
		if(ss!=-1){
			if(1==ss){
				SyncIt.b1.k1x=savedx;
				SyncIt.b1.k1y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(2==ss){
				SyncIt.b1.k2x=savedx;
				SyncIt.b1.k2y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(3==ss){
				SyncIt.b1.k3x=savedx;
				SyncIt.b1.k3y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(4==ss){
				SyncIt.b1.k4x=savedx;
				SyncIt.b1.k4y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(5==ss){
				SyncIt.b1.k5x=savedx;
				SyncIt.b1.k5y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(6==ss){
				SyncIt.b1.k6x=savedx;
				SyncIt.b1.k6y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(7==ss){
				SyncIt.b1.k7x=savedx;
				SyncIt.b1.k7y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}else if(8==ss){
				SyncIt.b1.k8x=savedx;
				SyncIt.b1.k8y=savedy;
				SyncIt.kni2.set(g,savedx);
				SyncIt.kni2.set(g+1,savedy);
			}
		}}
		if(killed!="none"){
			rearrangeKilledOnes();
		}
	p=0;
	}else{
		if(element=="k"){
			SyncIt.w1.kposx=savedx;
			SyncIt.w1.kposy=savedy;
		}else if(element=="q"){
			SyncIt.w1.qposx=savedx;
			SyncIt.w1.qposy=savedy;
		}else if(element=="h1"){
			SyncIt.w1.hposx=savedx;
			SyncIt.w1.hposy=savedy;
		}else if(element=="h2"){
			SyncIt.w1.hposx1=savedx;
			SyncIt.w1.hposy1=savedy;
		}else if(element=="c1"){
			SyncIt.w1.cposx=savedx;
			SyncIt.w1.cposy=savedy;
		}else if(element=="c2"){
			SyncIt.w1.cposx1=savedx;
			SyncIt.w1.cposy1=savedy;
		}else if(element=="e1"){
			SyncIt.w1.eposx=savedx;
			SyncIt.w1.eposy=savedy;
		}else if(element=="e2"){
			SyncIt.w1.eposx1=savedx;
			SyncIt.w1.eposy1=savedy;
		}else{
		int ss=-1;
		try{
		ss = Integer.parseInt(element.charAt(element.length()-1)+"");
		}catch(Exception ee){}
		if(ss!=-1){
			if((g+1)<SyncIt.kni.size() && g>=0)
			if(1==ss){
				SyncIt.w1.k1x=savedx;
				SyncIt.w1.k1y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(2==ss){
				SyncIt.w1.k2x=savedx;
				SyncIt.w1.k2y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(3==ss){
				SyncIt.w1.k3x=savedx;
				SyncIt.w1.k3y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(4==ss){
				SyncIt.w1.k4x=savedx;
				SyncIt.w1.k4y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(5==ss){
				SyncIt.w1.k5x=savedx;
				SyncIt.w1.k5y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(6==ss){
				SyncIt.w1.k6x=savedx;
				SyncIt.w1.k6y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(7==ss){
				SyncIt.w1.k7x=savedx;
				SyncIt.w1.k7y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}else if(8==ss){
				SyncIt.w1.k8x=savedx;
				SyncIt.w1.k8y=savedy;
				SyncIt.kni.set(g,savedx);
				SyncIt.kni.set(g+1,savedy);
			}
		}}
		if(killed!="none"){
			rearrangeKilledOnes();
		}
		p=0;
	}
}

///////////////////////////////////////////////////////.........New Method...................................
public void rearrangeKilledOnes(){
	if(SyncIt.chance==0){
		if(killed=="k"){
			SyncIt.w1.kposx=savedkx;
			SyncIt.w1.kposy=savedky;
		}else if(killed=="q"){
			SyncIt.w1.qposx=savedkx;
			SyncIt.w1.qposy=savedky;
		}else if(killed=="h1"){
			SyncIt.w1.hposx=savedkx;
			SyncIt.w1.hposy=savedky;
		}else if(killed=="h2"){
			SyncIt.w1.hposx1=savedkx;
			SyncIt.w1.hposy1=savedky;
		}else if(killed=="c1"){
			SyncIt.w1.cposx=savedkx;
			SyncIt.w1.cposy=savedky;
		}else if(killed=="c2"){
			SyncIt.w1.cposx1=savedkx;
			SyncIt.w1.cposy1=savedky;
		}else if(killed=="e1"){
			SyncIt.w1.eposx=savedkx;
			SyncIt.w1.eposy=savedky;
		}else if(killed=="e2"){
			SyncIt.w1.eposx1=savedkx;
			SyncIt.w1.eposy1=savedky;
		}else{
		int ss=-1;
		try{
		ss = Integer.parseInt(killed.charAt(killed.length()-1)+"");
		}catch(Exception ee){}
		if(ss!=-1){
			if((gg*2+1)<SyncIt.kni.size() && (gg*2)>=0)
			if(1==ss){
				SyncIt.w1.k1x=savedkx;
				SyncIt.w1.k1y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(2==ss){
				SyncIt.w1.k2x=savedkx;
				SyncIt.w1.k2y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(3==ss){
				SyncIt.w1.k3x=savedkx;
				SyncIt.w1.k3y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(4==ss){
				SyncIt.w1.k4x=savedkx;
				SyncIt.w1.k4y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(5==ss){
				SyncIt.w1.k5x=savedkx;
				SyncIt.w1.k5y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(6==ss){
				SyncIt.w1.k6x=savedkx;
				SyncIt.w1.k6y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(7==ss){
				SyncIt.w1.k7x=savedkx;
				SyncIt.w1.k7y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}else if(8==ss){
				SyncIt.w1.k8x=savedkx;
				SyncIt.w1.k8y=savedky;
				SyncIt.kni.set(gg*2,savedkx);
				SyncIt.kni.set(gg*2+1,savedky);
			}
		}}
	}else{
		if(killed=="k"){
			SyncIt.b1.kposx=savedkx;
			SyncIt.b1.kposy=savedky;
		}else if(killed=="q"){
			SyncIt.b1.qposx=savedkx;
			SyncIt.b1.qposy=savedky;
		}else if(killed=="h1"){
			SyncIt.b1.hposx=savedkx;
			SyncIt.b1.hposy=savedky;
		}else if(killed=="h2"){
			SyncIt.b1.hposx1=savedkx;
			SyncIt.b1.hposy1=savedky;
		}else if(killed=="c1"){
			SyncIt.b1.cposx=savedkx;
			SyncIt.b1.cposy=savedky;
		}else if(killed=="c2"){
			SyncIt.b1.cposx1=savedkx;
			SyncIt.b1.cposy1=savedky;
		}else if(killed=="e1"){
			SyncIt.b1.eposx=savedkx;
			SyncIt.b1.eposy=savedky;
		}else if(killed=="e2"){
			SyncIt.b1.eposx1=savedkx;
			SyncIt.b1.eposy1=savedky;
		}else{
		int ss=-1;
		try{
		ss = Integer.parseInt(killed.charAt(killed.length()-1)+"");
		}catch(Exception ee){}
		try {
		if(ss!=-1){
			if(1==ss){
				SyncIt.b1.k1x=savedkx;
				SyncIt.b1.k1y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(2==ss){
				SyncIt.b1.k2x=savedkx;
				SyncIt.b1.k2y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(3==ss){
				SyncIt.b1.k3x=savedkx;
				SyncIt.b1.k3y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(4==ss){
				SyncIt.b1.k4x=savedkx;
				SyncIt.b1.k4y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(5==ss){
				SyncIt.b1.k5x=savedkx;
				SyncIt.b1.k5y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(6==ss){
				SyncIt.b1.k6x=savedkx;
				SyncIt.b1.k6y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(7==ss){
				SyncIt.b1.k7x=savedkx;
				SyncIt.b1.k7y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}else if(8==ss){
				SyncIt.b1.k8x=savedkx;
				SyncIt.b1.k8y=savedky;
				SyncIt.kni2.set(gg*2,savedkx);
				SyncIt.kni2.set(gg*2+1,savedky);
			}
		}}catch(Exception e) {}}
	}
}

///////////////////////////////////////////////////////.........New Method...................................
public boolean checkKing(int x,int y){
	if(alreadyAttacked){
		for(int i=0;i<SyncIt.kngx.size();i++){
		if(SyncIt.kngx.get(i)==a && SyncIt.kngy.get(i)==b){
			break;
		}
		}
		try{
		SyncIt.kngx.remove(i);SyncIt.kngy.remove(i);}catch(Exception e){}
		alreadyAttacked=false;
	}
	for(int i=0;i<SyncIt.kngx.size();i++){
		if(SyncIt.kngx.get(i)==x && SyncIt.kngy.get(i)==y)return true;
	}
	return false;
}

///////////////////////////////////////////////////////.........New Method...................................
public void isKingTargeted(int x,int y){
include=true;
ArrayList<Integer> l1=new ArrayList<Integer>(),l2=new ArrayList<Integer>();
for(int i = 0;i<SyncIt.platformx.size();i++){
l1.add(SyncIt.platformx.get(i));
l2.add(SyncIt.platformy.get(i));
}

SyncIt.platformx.clear();SyncIt.platformy.clear();
if(SyncIt.chance==1){
SyncIt.chance=0;
king=false;
camel=true;
checkForPosition(SyncIt.b1.cposx,SyncIt.b1.cposy);
checkForPosition(SyncIt.b1.cposx1,SyncIt.b1.cposy1);
camel=false;
elephant=true;
checkForPosition(SyncIt.b1.eposx,SyncIt.b1.eposy);
checkForPosition(SyncIt.b1.eposx1,SyncIt.b1.eposy1);
elephant=false;
horse=true;
checkForPosition(SyncIt.b1.hposx,SyncIt.b1.hposy);
checkForPosition(SyncIt.b1.hposx1,SyncIt.b1.hposy1);
horse=false;
king=true;
checkForPosition(SyncIt.b1.kposx,SyncIt.b1.kposy);
king=false;
queen=true;
checkForPosition(SyncIt.b1.qposx,SyncIt.b1.qposy);
queen=false;
for(int i = 0;i<SyncIt.kni2.size();i+=2){
SyncIt.platformx.add(SyncIt.kni2.get(i)-80);
SyncIt.platformy.add(SyncIt.kni2.get(i+1)-80);
SyncIt.platformx.add(SyncIt.kni2.get(i)+80);
SyncIt.platformy.add(SyncIt.kni2.get(i+1)-80);
}

SyncIt.chance=1;

}else{
SyncIt.chance=1;
king=false;
camel=true;
checkForPosition(SyncIt.w1.cposx,SyncIt.w1.cposy);
checkForPosition(SyncIt.w1.cposx1,SyncIt.w1.cposy1);
camel=false;
elephant=true;
checkForPosition(SyncIt.w1.eposx,SyncIt.w1.eposy);
checkForPosition(SyncIt.w1.eposx1,SyncIt.w1.eposy1);
elephant=false;
horse=true;
checkForPosition(SyncIt.w1.hposx,SyncIt.w1.hposy);
checkForPosition(SyncIt.w1.hposx1,SyncIt.w1.hposy1);
horse=false;
king=true;
checkForPosition(SyncIt.w1.kposx,SyncIt.w1.kposy);
king=false;
queen=true;
checkForPosition(SyncIt.w1.qposx,SyncIt.w1.qposy);
queen=false;
for(int i = 0;i<SyncIt.kni.size();i+=2){
SyncIt.platformx.add(SyncIt.kni.get(i)-80);
SyncIt.platformy.add(SyncIt.kni.get(i+1)+80);
SyncIt.platformx.add(SyncIt.kni.get(i)+80);
SyncIt.platformy.add(SyncIt.kni.get(i+1)+80);
}

SyncIt.chance=0;

}
for(int i=0;i<SyncIt.platformx.size();i++){
SyncIt.kngx.add(SyncIt.platformx.get(i));
SyncIt.kngy.add(SyncIt.platformy.get(i));
}
SyncIt.platformx.clear();SyncIt.platformy.clear();
for(int i=0;i<l1.size();i++)SyncIt.platformx.add(l1.get(i));
for(int i=0;i<l2.size();i++)SyncIt.platformy.add(l2.get(i));

king=true;
include=false;

}


///////////////////////////////////////////////////////.........New Method...................................
public void reset(){
	temp=0;
	camel = false;
	king = false;
	queen = false;
	elephant = false;
	horse = false;
	d1 = false;
	d2 = false;
	enemy = false;
	include=false;
	SyncIt.kngx.clear();SyncIt.kngy.clear();
	SyncIt.platformx.clear();
	SyncIt.platformy.clear();
}

///////////////////////////////////////////////////////.........New Method...................................
public boolean compared(int a,int b,int c,int d){
	if(a>=c && a<c+80 && b>=d && b<d+80){
		return true;
	}
	return false;
}
	
	///////////////////////////////////////////////////////.........New Method...................................
public boolean front(int x, int y,int pos) {
		boolean s = false;
		if (SyncIt.chance == 1 && (checkForOthers( x,y + 80))) {
			s = true;
			if(!sideWays(x,y,false,pos)){
			found = false;
			if (SyncIt.chance == 0)
				SyncIt.chance = 1;
			else
				SyncIt.chance = 0;}
		} else if (SyncIt.chance == 0 && (checkForOthers(x,y - 80))) {
			s = true;
			if(!sideWays(x,y,false,pos)){
			found = false;
			if (SyncIt.chance == 0)
				SyncIt.chance = 1;
			else
				SyncIt.chance = 0;}
		}
		enemy = false;
		return s;
	}



	///////////////////////////////////////////////////////.........New Method...................................
public boolean sideWays(int x, int y,boolean w,int pos) {
		boolean p = false;
		if (SyncIt.chance == 1) {
			if(w){
			SyncIt.platformx.add(x);
			SyncIt.platformy.add(y + 80);}
			if (x + 80 <= SyncIt.width - 80 && y + 80 <= SyncIt.width - 80 && checkForOthers(x + 80, y + 80) && enemy) {
				SyncIt.platformx.add(x + 80);
				SyncIt.platformy.add(y + 80);
				if(!checkForOthers(x,y+160) && y==80) {
					SyncIt.platformx.add(x);
					SyncIt.platformy.add(y + 160);
					SyncIt.white_initializer[pos]=1;
				}
				p=true;
			}
			if (x - 80 >= 0 && y + 80 <= SyncIt.width - 80 && checkForOthers(x - 80, y + 80) && enemy) {
				SyncIt.platformx.add(x - 80);
				SyncIt.platformy.add(y + 80);
				if(!checkForOthers(x,y+160) && y==80) {
					SyncIt.platformx.add(x);
					SyncIt.platformy.add(y + 160);
					SyncIt.white_initializer[pos]=1;
				}
				p=true;
			}
			if (!p){
				SyncIt.platformx.clear();
				SyncIt.platformy.clear();
			}
		} else {
			if(w){
			SyncIt.platformx.add(x);
			SyncIt.platformy.add(y - 80);}
			if (x - 80 >= 0 && y - 80 >= 0 && checkForOthers(x - 80, y - 80) && enemy) {
				SyncIt.platformx.add(x - 80);
				SyncIt.platformy.add(y - 80);
				if(!checkForOthers(x,y-160) && y==480) {
					SyncIt.platformx.add(x);
					SyncIt.platformy.add(y - 160);
					SyncIt.black_initializer[pos]=1;
				}
				p=true;
			}
			if (x + 80 <= SyncIt.width - 80 && y - 80 >= 0 && checkForOthers(x + 80, y - 80) && enemy) {
				SyncIt.platformx.add(x + 80);
				SyncIt.platformy.add(y - 80);
				if(!checkForOthers(x,y-160) && y==480) {
					SyncIt.platformx.add(x);
					SyncIt.platformy.add(y - 160);
					SyncIt.black_initializer[pos]=1;
				}
				p=true;
			}
			if (!p){
				SyncIt.platformx.clear();
				SyncIt.platformy.clear();
			}
		}
		return p;
	}


public boolean checkForFirstMove(int chance,int pos,int x,int y) {
	boolean ff=false;
	if(chance == 1) {
	if(y==80 && !checkForOthers(x,y+160)) {
		SyncIt.platformx.add(x);SyncIt.platformy.add(y+80);
		SyncIt.platformx.add(x);SyncIt.platformy.add(y+160);
		ff=true;
		p=2;
		SyncIt.white_initializer[pos]=1;
	}
	}else {
		if(y==480 && !checkForOthers(x,y-160)) {
			SyncIt.platformx.add(x);SyncIt.platformy.add(y-80);
			SyncIt.platformx.add(x);SyncIt.platformy.add(y-160);
			ff=true;
			p=2;
			SyncIt.black_initializer[pos]=1;
		}	
	}
	return ff;
}
	
	///////////////////////////////////////////////////////.........New Method...................................
	public void setKnights(int x, int y) {
		boolean ee = true;
		if (found) {
			if (pos == 1){if(!front(x, y,0)) {
				if (sideWays(x, y,true,0)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,0,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k1y += 80;
						SyncIt.white_initializer[0]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,0,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k1y -= 80;
						SyncIt.black_initializer[0]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			} else if (pos == 2){if(!front(x, y,1)) {
				if (sideWays(x, y,true,1)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,1,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k2y += 80;
						SyncIt.white_initializer[1]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,1,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k2y -= 80;
						SyncIt.black_initializer[1]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			} else if (pos == 3){if( !front(x, y,2)) {
				if (sideWays(x, y,true,2)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,2,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k3y += 80;
						SyncIt.white_initializer[2]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,2,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k3y -= 80;
						SyncIt.black_initializer[2]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
			if(!SyncIt.platformx.isEmpty()){
				p=2;ee=false;
			}
		}
			} else if (pos == 4){if(!front(x, y,3)) {
				if (sideWays(x, y,true,3)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,3,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k4y += 80;
						SyncIt.white_initializer[3]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,3,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k4y -= 80;
						SyncIt.black_initializer[3]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			}else if (pos == 5){if(!front(x, y,4)) {
				if (sideWays(x, y,true,4)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,4,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k5y += 80;
						SyncIt.white_initializer[4]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,4,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k5y -= 80;
						SyncIt.black_initializer[4]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			} else if (pos == 6){if(!front(x, y,5)) {
				if (sideWays(x, y,true,5)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,5,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k6y += 80;
						SyncIt.white_initializer[5]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,5,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k6y -= 80;
						SyncIt.black_initializer[5]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			} else if (pos == 7){if(!front(x, y,6)) {
				if (sideWays(x, y,true,6)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,6,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k7y += 80;
						SyncIt.white_initializer[6]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,6,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k7y -= 80;
						SyncIt.black_initializer[6]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			} else if (pos == 8){if(!front(x, y,7)) {
				if (sideWays(x, y,true,7)) {
					p = 2;
					ee = false;
				} else {
					if (SyncIt.chance == 1) {
						if(checkForFirstMove(SyncIt.chance,7,x,y)) {
							ee=false;
						}
						else{
						SyncIt.w1.k8y += 80;
						SyncIt.white_initializer[7]=1;
						SyncIt.kni.set(i + 1, SyncIt.kni.get(i + 1) + 80);}
					} else {
						if(checkForFirstMove(SyncIt.chance,7,x,y)) {
							ee=false;
						}
						else{
						SyncIt.b1.k8y -= 80;
						SyncIt.black_initializer[7]=1;
						SyncIt.kni2.set(i + 1, SyncIt.kni2.get(i + 1) - 80);}
					}
				}
			}else{
				if(!SyncIt.platformx.isEmpty()){
					p=2;ee=false;
				}
			}
			}
			if (ee)
				p += 3;
		}
	}
	///////////////////////////////////////////////////////.........New Method...................................
	public void camelAndElephant(int x,int y){
		int i,j;
		if(queen || camel){
			j = y;
			i = x;
			for (i = x - 80; (j >= 0 && i >= 0); i -= 80) {
				j -= 80;
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}

				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && j >= 0 && i >= 0) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
			j = y;
			i = x;
			for (i = x - 80; (j < SyncIt.width && i >= 0); i -= 80) {
				j += 80;
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && j < SyncIt.width && i >= 0) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}

			}
			j = y;
			i = x;
			for (i = x + 80; (j >= 0 && i < SyncIt.width); i += 80) {
				j -= 80;
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && j >= 0 && i < SyncIt.width) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}

			}
			j = y;
			i = x;
			for (i = x + 80; (j < SyncIt.width && i < SyncIt.width); i += 80) {
				j += 80;
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && j < SyncIt.width && i < SyncIt.width) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}

			}
		}
		if(queen || elephant){
			j = y;
			for (i = x - 80; i >= 0; i -= 80) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && i >= 0) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
			j = y;
			for (i = x + 80; i < SyncIt.width; i += 80) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && i < SyncIt.width) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
			i = x;
			for (j = y - 80; j >= 0; j -= 80) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && j >= 0) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
			i = x;
			for (j = y + 80; j < SyncIt.width; j += 80) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					break;
				}
				else if (checkForOthers(i, j)) {
					if (enemy) {
						SyncIt.platformx.add(i);
						SyncIt.platformy.add(j);
						enemy = false;
					}
					break;
				}
				if (add && j < SyncIt.width) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
		}
	}
	
	
	///////////////////////////////////////////////////////.........New Method...................................
	//
	public void checkForPosition(int x, int y) {
		int i, j;
		if (camel) {
			camelAndElephant(x,y);
		}
		if (elephant) {
			camelAndElephant(x,y);
		}
		if (horse) {
			i = x;
			j = y;
			j += 160;
			i += 80;
			if (!(i >= SyncIt.width || j >= SyncIt.width)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			j += 160;
			i -= 80;
			if (!(i < 0 || j >= SyncIt.width)) {
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			j -= 160;
			i += 80;
			if (!(i >= SyncIt.width || j < 0)) {
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			j -= 160;
			i -= 80;
			if (!(i < 0 || j < 0)) {
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i += 160;
			j += 80;
			if (!(i >= SyncIt.width || j >= SyncIt.width)) {
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i += 160;
			j -= 80;
			if (!(j < 0 || i >= SyncIt.width)) {
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i -= 160;
			j += 80;
			if (!(j >= SyncIt.width || i < 0)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i -= 160;
			j -= 80;
			if (!(i < 0 || j < 0)) {
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
		}
		if (king) {
			i = x;
			j = y;
			i -= 80;
			j -= 80;
			if (!(i < 0 || j < 0)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if(checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i -= 80;
			j += 80;
			if (!(i < 0 || j >= SyncIt.width)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i += 80;
			j -= 80;
			if (!(i >= SyncIt.width || j < 0)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i += 80;
			j += 80;
			if (!(i >= SyncIt.width || j >= SyncIt.width)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i -= 80;
			if (!(i < 0 || j < 0)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {

					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			i += 80;
			if (!(i >= SyncIt.width || j < 0)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			j -= 80;
			if (!(i < 0 || j < 0)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}

			i = x;
			j = y;
			j += 80;
			if (!(i < 0 || j >= SyncIt.width)) {
				// then add
				boolean add = true;
				if (SyncIt.platformx.contains(i)) {
					int s = SyncIt.platformx.indexOf(i);
					if (SyncIt.platformy.get(s) == j)
						add = false;
				}
				if(include && checkForOthers(i, j)){
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
				else if (checkForOthers(i, j) && enemy) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
					enemy = false;
				}
				if (add && !checkForOthers(i, j)) {
					SyncIt.platformx.add(i);
					SyncIt.platformy.add(j);
				}
			}
		}
		if (queen) {
			camelAndElephant(x,y);
		}
	}
	
	///////////////////////////////////////////////////////.........New Method...................................
	public boolean valid(int x, int y) {
		boolean v = false;
		for (int i = 0; i < SyncIt.platformx.size(); i++) {
			if (x >= SyncIt.platformx.get(i) && x < SyncIt.platformx.get(i) + 80 && y >= SyncIt.platformy.get(i)
					&& y < SyncIt.platformy.get(i) + 80) {
				if (SyncIt.chance == 1) {
					if (king) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.kposx = (80 * (x / 80));
						SyncIt.w1.kposy = (80 * (y / 80));
						v = true;
					}
					if (elephant && d1) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.eposx = (80 * (x / 80));
						SyncIt.w1.eposy = (80 * (y / 80));
						v = true;
					}
					if (elephant && d2) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.eposx1 = 80 * (x / 80);
						SyncIt.w1.eposy1 = 80 * (y / 80);
						v = true;
					}
					if (queen) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.qposx = 80 * (x / 80);
						SyncIt.w1.qposy = 80 * (y / 80);
						v = true;
					}
					if (camel && d1) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.cposx = 80 * (x / 80);
						SyncIt.w1.cposy = 80 * (y / 80);
						v = true;
					}
					if (camel && d2) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.cposx1 = 80 * (x / 80);
						SyncIt.w1.cposy1 = 80 * (y / 80);
						v = true;
					}
					if (horse && d1) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.hposx = 80 * (x / 80);
						SyncIt.w1.hposy = 80 * (y / 80);
						v = true;
					}
					if (horse && d2) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.w1.hposx1 = 80 * (x / 80);
						SyncIt.w1.hposy1 = 80 * (y / 80);
						v = true;
					}
				} else {
					if (king) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.kposx = (80 * (x / 80));
						SyncIt.b1.kposy = (80 * (y / 80));
						v = true;
					}
					if (elephant && d1) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.eposx = (80 * (x / 80));
						SyncIt.b1.eposy = (80 * (y / 80));
						v = true;
					}
					if (elephant && d2) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.eposx1 = 80 * (x / 80);
						SyncIt.b1.eposy1 = 80 * (y / 80);
						v = true;
					}
					if (queen) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.qposx = 80 * (x / 80);
						SyncIt.b1.qposy = 80 * (y / 80);
						v = true;
					}
					if (camel && d1) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.cposx = 80 * (x / 80);
						SyncIt.b1.cposy = 80 * (y / 80);
						v = true;
					}
					if (camel && d2) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.cposx1 = 80 * (x / 80);
						SyncIt.b1.cposy1 = 80 * (y / 80);
						v = true;
					}
					if (horse && d1) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.hposx = 80 * (x / 80);
						SyncIt.b1.hposy = 80 * (y / 80);
						v = true;
					}
					if (horse && d2) {
						compareAndKill((80 * (x / 80)), (80 * (y / 80)));
						SyncIt.b1.hposx1 = 80 * (x / 80);
						SyncIt.b1.hposy1 = 80 * (y / 80);
						v = true;
					}
				}
			}
		}
		return v;
	}

	///////////////////////////////////////////////////////.........New Method...................................
public void compareAndKill(int x, int y) {
	savedkx=-100;savedky=-100;killed="none";
		if (SyncIt.chance == 1) {
			for (int i = 0; i <= SyncIt.kni2.size() - 1; i += 2) {
				boolean bb = false;
				if (SyncIt.kni2.get(i) == x && SyncIt.kni2.get(i + 1) == y) {
					SyncIt.kni2.set(i, -100);
					SyncIt.kni2.set(i + 1, -100);
					bb = true;
					if (bb) {
						int k = i / 2;
						if (k == 0) {
							killed=1+"";
							savedkx=SyncIt.b1.k1x;
							savedky=SyncIt.b1.k1y;
							SyncIt.b1.k1x = -100;
							SyncIt.b1.k1y = -100;
						} else if (k == 1) {
							killed=2+"";
							savedkx=SyncIt.b1.k2x;
							savedky=SyncIt.b1.k2y;
							SyncIt.b1.k2x = -100;
							SyncIt.b1.k2y = -100;
						} else if (k == 2) {
							killed=3+"";
							savedkx=SyncIt.b1.k3x;
							savedky=SyncIt.b1.k3y;
							SyncIt.b1.k3x = -100;
							SyncIt.b1.k3y = -100;
						} else if (k == 3) {
							killed=4+"";
							savedkx=SyncIt.b1.k4x;
							savedky=SyncIt.b1.k4y;
							SyncIt.b1.k4x = -100;
							SyncIt.b1.k4y = -100;
						} else if (k == 4) {
							killed=5+"";
							savedkx=SyncIt.b1.k5x;
							savedky=SyncIt.b1.k5y;
							SyncIt.b1.k5x = -100;
							SyncIt.b1.k5y = -100;
						} else if (k == 5) {
							killed=6+"";
							savedkx=SyncIt.b1.k6x;
							savedky=SyncIt.b1.k6y;
							SyncIt.b1.k6x = -100;
							SyncIt.b1.k6y = -100;
						} else if (k == 6) {
							killed=7+"";
							savedkx=SyncIt.b1.k7x;
							savedky=SyncIt.b1.k7y;
							SyncIt.b1.k7x = -100;
							SyncIt.b1.k7y = -100;
						} else if (k == 7) {
							killed=8+"";
							savedkx=SyncIt.b1.k8x;
							savedky=SyncIt.b1.k8y;
							SyncIt.b1.k8x = -100;
							SyncIt.b1.k8y = -100;
						}gg=k;
					}
					break;
				}
			}
			if (SyncIt.b1.eposx == x && SyncIt.b1.eposy == y) {
				killed="e1";
				savedkx=SyncIt.b1.eposx;
				savedky=SyncIt.b1.eposy;
				SyncIt.b1.eposx = -100;
				SyncIt.b1.eposy = -100;
			}
			if (SyncIt.b1.hposx == x && SyncIt.b1.hposy == y) {
				killed="h1";
				savedkx=SyncIt.b1.hposx;
				savedky=SyncIt.b1.hposy;
				SyncIt.b1.hposx = -100;
				SyncIt.b1.hposy = -100;
			}
			if (SyncIt.b1.cposx == x && SyncIt.b1.cposy == y) {
				killed="c1";
				savedkx=SyncIt.b1.cposx;
				savedky=SyncIt.b1.cposy;
				SyncIt.b1.cposx = -100;
				SyncIt.b1.cposy = -100;
			}
			if (SyncIt.b1.kposx == x && SyncIt.b1.kposy == y) {
				killed="k";
				savedkx=SyncIt.b1.kposx;
				savedky=SyncIt.b1.kposy;
				SyncIt.b1.kposx = -100;
				SyncIt.b1.kposy = -100;
			}
			if (SyncIt.b1.qposx == x && SyncIt.b1.qposy == y) {
				killed="q";
				savedkx=SyncIt.b1.qposx;
				savedky=SyncIt.b1.qposy;
				SyncIt.b1.qposx = -100;
				SyncIt.b1.qposy = -100;
			}
			if (SyncIt.b1.cposx1 == x && SyncIt.b1.cposy1 == y) {
				killed="c2";
				savedkx=SyncIt.b1.cposx1;
				savedky=SyncIt.b1.cposy1;
				SyncIt.b1.cposx1 = -100;
				SyncIt.b1.cposy1 = -100;
			}
			if (SyncIt.b1.hposx1 == x && SyncIt.b1.hposy1 == y) {
				killed="h2";
				savedkx=SyncIt.b1.hposx1;
				savedky=SyncIt.b1.hposy1;
				SyncIt.b1.hposx1 = -100;
				SyncIt.b1.hposy1 = -100;
			}
			if (SyncIt.b1.eposx1 == x && SyncIt.b1.eposy1 == y) {
				killed="e2";
				savedkx=SyncIt.b1.eposx1;
				savedky=SyncIt.b1.eposy1;
				SyncIt.b1.eposx1 = -100;
				SyncIt.b1.eposy1 = -100;
			}
		} else {
			for (int i = 0; i <= SyncIt.kni.size() - 1; i += 2) {
				boolean bb = false;
				if (SyncIt.kni.get(i) == x && SyncIt.kni.get(i + 1) == y) {
					SyncIt.kni.set(i, -100);
					SyncIt.kni.set(i + 1, -100);
					bb = true;
					if (bb) {
						int k = i / 2;
						if (k == 0) {
							killed=1+"";
							savedkx=SyncIt.w1.k1x;
							savedky=SyncIt.w1.k1y;
							SyncIt.w1.k1x = -100;
							SyncIt.w1.k1y = -100;
						} else if (k == 1) {
							killed=2+"";
							savedkx=SyncIt.w1.k2x;
							savedky=SyncIt.w1.k2y;
							SyncIt.w1.k2x = -100;
							SyncIt.w1.k2y = -100;
						} else if (k == 2) {
							killed=3+"";
							savedkx=SyncIt.w1.k3x;
							savedky=SyncIt.w1.k3y;
							SyncIt.w1.k3x = -100;
							SyncIt.w1.k3y = -100;
						} else if (k == 3) {
							killed=4+"";
							savedkx=SyncIt.w1.k4x;
							savedky=SyncIt.w1.k4y;
							SyncIt.w1.k4x = -100;
							SyncIt.w1.k4y = -100;
						} else if (k == 4) {
							killed=5+"";
							savedkx=SyncIt.w1.k5x;
							savedky=SyncIt.w1.k5y;
							SyncIt.w1.k5x = -100;
							SyncIt.w1.k5y = -100;
						} else if (k == 5) {
							killed=6+"";
							savedkx=SyncIt.w1.k6x;
							savedky=SyncIt.w1.k6y;
							SyncIt.w1.k6x = -100;
							SyncIt.w1.k6y = -100;
						} else if (k == 6) {
							killed=7+"";
							savedkx=SyncIt.w1.k7x;
							savedky=SyncIt.w1.k7y;
							SyncIt.w1.k7x = -100;
							SyncIt.w1.k7y = -100;
						} else if (k == 7) {
							killed=8+"";
							savedkx=SyncIt.w1.k8x;
							savedky=SyncIt.w1.k8y;
							SyncIt.w1.k8x = -100;
							SyncIt.w1.k8y = -100;
						}gg=k;
					}
					break;
				}
			}
			if (SyncIt.w1.eposx == x && SyncIt.w1.eposy == y) {
				killed="e1";
				savedkx=SyncIt.w1.eposx;
				savedky=SyncIt.w1.eposy;
				SyncIt.w1.eposx = -100;
				SyncIt.w1.eposy = -100;
			}
			if (SyncIt.w1.hposx == x && SyncIt.w1.hposy == y) {
				killed="h1";
				savedkx=SyncIt.w1.hposx;
				savedky=SyncIt.w1.hposy;
				SyncIt.w1.hposx = -100;
				SyncIt.w1.hposy = -100;
			}
			if (SyncIt.w1.cposx == x && SyncIt.w1.cposy == y) {
				killed="c1";
				savedkx=SyncIt.w1.cposx;
				savedky=SyncIt.w1.cposy;
				SyncIt.w1.cposx = -100;
				SyncIt.w1.cposy = -100;
			}
			if (SyncIt.w1.kposx == x && SyncIt.w1.kposy == y) {
				killed="k";
				savedkx=SyncIt.w1.kposx;
				savedky=SyncIt.w1.kposy;
				SyncIt.w1.kposx = -100;
				SyncIt.w1.kposy = -100;
			}
			if (SyncIt.w1.qposx == x && SyncIt.w1.qposy == y) {
				killed="q";
				savedkx=SyncIt.w1.qposx;
				savedky=SyncIt.w1.qposy;
				SyncIt.w1.qposx = -100;
				SyncIt.w1.qposy = -100;
			}
			if (SyncIt.w1.cposx1 == x && SyncIt.w1.cposy1 == y) {
				killed="c2";
				savedkx=SyncIt.w1.cposx1;
				savedky=SyncIt.w1.cposy1;
				SyncIt.w1.cposx1 = -100;
				SyncIt.w1.cposy1 = -100;
			}
			if (SyncIt.w1.hposx1 == x && SyncIt.w1.hposy1 == y) {
				killed="h2";
				savedkx=SyncIt.w1.hposx1;
				savedky=SyncIt.w1.hposy1;
				SyncIt.w1.hposx1 = -100;
				SyncIt.w1.hposy1 = -100;
			}
			if (SyncIt.w1.eposx1 == x && SyncIt.w1.eposy1 == y) {
				killed="e2";
				savedkx=SyncIt.w1.eposx1;
				savedky=SyncIt.w1.eposy1;
				SyncIt.w1.eposx1 = -100;
				SyncIt.w1.eposy1 = -100;
			}
		}
	}

///////////////////////////////////////////////////////.........New Method...................................
public boolean checkForOthers(int x, int y) {
		boolean located = false;enemy=false;
		if (SyncIt.b1.k1x == x && SyncIt.b1.k1y == y || SyncIt.b1.kposx == x && SyncIt.b1.kposy == y
				|| SyncIt.b1.k8x == x && SyncIt.b1.k8y == y || SyncIt.b1.k2x == x && SyncIt.b1.k2y == y
				|| SyncIt.b1.k3x == x && SyncIt.b1.k3y == y || SyncIt.b1.k4x == x && SyncIt.b1.k4y == y
				|| SyncIt.b1.k5x == x && SyncIt.b1.k5y == y || SyncIt.b1.k6x == x && SyncIt.b1.k6y == y
				|| SyncIt.b1.k7x == x && SyncIt.b1.k7y == y || SyncIt.b1.qposx == x && SyncIt.b1.qposy == y
				|| SyncIt.b1.eposx == x && SyncIt.b1.eposy == y || SyncIt.b1.hposx == x && SyncIt.b1.hposy == y
				|| SyncIt.b1.cposx == x && SyncIt.b1.cposy == y || SyncIt.b1.eposx1 == x && SyncIt.b1.eposy1 == y
				|| SyncIt.b1.hposx1 == x && SyncIt.b1.hposy1 == y || SyncIt.b1.cposx1 == x && SyncIt.b1.cposy1 == y) {
			located = true;
			if (SyncIt.chance == 1){
				enemy = true;
			}
			
		}
		if (SyncIt.w1.k1x == x && SyncIt.w1.k1y == y || SyncIt.w1.kposx == x && SyncIt.w1.kposy == y
				|| SyncIt.w1.k8x == x && SyncIt.w1.k8y == y || SyncIt.w1.k2x == x && SyncIt.w1.k2y == y
				|| SyncIt.w1.k3x == x && SyncIt.w1.k3y == y || SyncIt.w1.k4x == x && SyncIt.w1.k4y == y
				|| SyncIt.w1.k5x == x && SyncIt.w1.k5y == y || SyncIt.w1.k6x == x && SyncIt.w1.k6y == y
				|| SyncIt.w1.k7x == x && SyncIt.w1.k7y == y || SyncIt.w1.qposx == x && SyncIt.w1.qposy == y
				|| SyncIt.w1.eposx == x && SyncIt.w1.eposy == y || SyncIt.w1.hposx == x && SyncIt.w1.hposy == y
				|| SyncIt.w1.cposx == x && SyncIt.w1.cposy == y || SyncIt.w1.eposx1 == x && SyncIt.w1.eposy1 == y
				|| SyncIt.w1.hposx1 == x && SyncIt.w1.hposy1 == y || SyncIt.w1.cposx1 == x && SyncIt.w1.cposy1 == y) {
			located = true;
			if (SyncIt.chance == 0){
				enemy = true;
			}
		}
		
		return located;
	}

///////////////////////////////////////////////////////.........New Method...................................
public boolean check() {
		if ((elephant || horse || camel || king || queen) && !SyncIt.platformx.isEmpty())
			return true;
		if (SyncIt.platformx.isEmpty()) {
			elephant = false;
			horse = false;
			camel = false;
			king = false;
			queen = false;
		}
		return false;
	}

///////////////////////////////////////////////////////.........New Method...................................
public boolean isPresent(int x, int y) {
		boolean present = false;
		if (SyncIt.chance == 0 && !check()) {
			if (compared(x,y,SyncIt.b1.qposx,SyncIt.b1.qposy)) {
				present = true;
				queen = true;
			} else if (compared(x,y,SyncIt.b1.kposx,SyncIt.b1.kposy)) {
				present = true;
				king = true;
			} else if (compared(x,y,SyncIt.b1.eposx,SyncIt.b1.eposy)) {
				present = true;
				elephant = true;
				d1 = true;
				d2 = false;
			} else if (compared(x,y,SyncIt.b1.hposx,SyncIt.b1.hposy)) {
				present = true;
				horse = true;
				d1 = true;
				d2 = false;
			} else if (compared(x,y,SyncIt.b1.cposx,SyncIt.b1.cposy)) {
				present = true;
				camel = true;
				d1 = true;
				d2 = false;
			} else if (compared(x,y,SyncIt.b1.eposx1,SyncIt.b1.eposy1)) {
				present = true;
				elephant = true;
				d2 = true;
				d1 = false;
			} else if (compared(x,y,SyncIt.b1.hposx1,SyncIt.b1.hposy1)) {
				present = true;
				horse = true;
				d2 = true;
				d1 = false;
			} else if (compared(x,y,SyncIt.b1.cposx1,SyncIt.b1.cposy1)) {
				present = true;
				camel = true;
				d2 = true;
				d1 = false;
			}
		} else if (SyncIt.chance == 1 && !check()) {
			if (compared(x,y,SyncIt.w1.qposx,SyncIt.w1.qposy)) {
				present = true;
				queen = true;
			} else if (compared(x,y,SyncIt.w1.kposx,SyncIt.w1.kposy)) {
				present = true;
				king = true;
			} else if (compared(x,y,SyncIt.w1.eposx,SyncIt.w1.eposy)) {
				present = true;
				elephant = true;
				d1 = true;
				d2 = false;
			} else if (compared(x,y,SyncIt.w1.hposx,SyncIt.w1.hposy)) {
				present = true;
				horse = true;
				d1 = true;
				d2 = false;
			} else if (compared(x,y,SyncIt.w1.cposx,SyncIt.w1.cposy)) {
				present = true;
				camel = true;
				d1 = true;
				d2 = false;
			} else if (compared(x,y,SyncIt.w1.eposx1,SyncIt.w1.eposy1)) {
				present = true;
				elephant = true;
				d2 = true;
				d1 = false;
			} else if (compared(x,y,SyncIt.w1.hposx1,SyncIt.w1.hposy1)) {
				present = true;
				horse = true;
				d2 = true;
				d1 = false;
			} else if (compared(x,y,SyncIt.w1.cposx1,SyncIt.w1.cposy1)) {
				present = true;
				d2 = true;
				d1 = false;
				camel = true;

			}
		}
		return present;
	}
}
