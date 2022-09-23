import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Elements {
	static BufferedImage img,bbking,wbking,bwking,wwking,blwking,blbking,rbking,rwking,bbqueen,
			wbqueen,wwqueen,bwqueen,rbqueen,rwqueen,wwelephant,bwelephant,wbelephant,bbelephant,
			rbelephant,rwelephant,wwhorse,bwhorse,wborse,wbhorse,bbhorse,rbhorse,rwhorse,wwcamel,
			bwcamel,wbcamel,bbcamel,rbcamel,rwcamel,wwwarrior,bwwarrior,wbwarrior,bbwarrior,rbwarrior,rwwarrior;
public Elements(){
	try{
		bbking =  ImageIO.read(Elements.class.getResource("/textures/bbking.png"));
		wbking =  ImageIO.read(Elements.class.getResource("/textures/wbking.png"));
		bwking =  ImageIO.read(Elements.class.getResource("/textures/bwking.png"));
		wwking =  ImageIO.read(Elements.class.getResource("/textures/wwking.png"));
		blwking =  ImageIO.read(Elements.class.getResource("/textures/blwking.png"));
		blbking =  ImageIO.read(Elements.class.getResource("/textures/blbking.png"));
		rbking =  ImageIO.read(Elements.class.getResource("/textures/rbking.png"));
		rwking =  ImageIO.read(Elements.class.getResource("/textures/rwking.png"));
		bbqueen =  ImageIO.read(Elements.class.getResource("/textures/bbqueen.png"));
		wbqueen =  ImageIO.read(Elements.class.getResource("/textures/wbqueen.png"));
		wwqueen =  ImageIO.read(Elements.class.getResource("/textures/wwqueen.png"));
		bwqueen =  ImageIO.read(Elements.class.getResource("/textures/bwqueen.png"));
		rbqueen =  ImageIO.read(Elements.class.getResource("/textures/rbqueen.png"));
		rwqueen =  ImageIO.read(Elements.class.getResource("/textures/rwqueen.png"));
		wwelephant =  ImageIO.read(Elements.class.getResource("/textures/wwelephant.png"));
		bwelephant =  ImageIO.read(Elements.class.getResource("/textures/bwelephant.png"));
		wbelephant =  ImageIO.read(Elements.class.getResource("/textures/wbelephant.png"));
		bbelephant =  ImageIO.read(Elements.class.getResource("/textures/bbelephant.png"));
		rbelephant =  ImageIO.read(Elements.class.getResource("/textures/rbelephant.png"));
		rwelephant =  ImageIO.read(Elements.class.getResource("/textures/rwelephant.png"));
		wwhorse =  ImageIO.read(Elements.class.getResource("/textures/wwhorse.png"));
		bwhorse =  ImageIO.read(Elements.class.getResource("/textures/bwhorse.png"));
		wbhorse =  ImageIO.read(Elements.class.getResource("/textures/wbhorse.png"));
		bbhorse =  ImageIO.read(Elements.class.getResource("/textures/bbhorse.png"));
		rbhorse =  ImageIO.read(Elements.class.getResource("/textures/rbhorse.png"));
		rwhorse =  ImageIO.read(Elements.class.getResource("/textures/rwhorse.png"));
		wwcamel =  ImageIO.read(Elements.class.getResource("/textures/wwcamel.png"));
		bwcamel =  ImageIO.read(Elements.class.getResource("/textures/bwcamel.png"));
		wbcamel =  ImageIO.read(Elements.class.getResource("/textures/wbcamel.png"));
		bbcamel =  ImageIO.read(Elements.class.getResource("/textures/bbcamel.png"));
		rbcamel =  ImageIO.read(Elements.class.getResource("/textures/rbcamel.png"));
		rwcamel =  ImageIO.read(Elements.class.getResource("/textures/rwcamel.png"));
		wwwarrior =  ImageIO.read(Elements.class.getResource("/textures/wwwarrior.png"));
		bwwarrior =  ImageIO.read(Elements.class.getResource("/textures/bwwarrior.png"));
		wbwarrior =  ImageIO.read(Elements.class.getResource("/textures/wbwarrior.png"));
		bbwarrior =  ImageIO.read(Elements.class.getResource("/textures/bbwarrior.png"));
		rbwarrior =  ImageIO.read(Elements.class.getResource("/textures/rbwarrior.png"));
		rwwarrior =  ImageIO.read(Elements.class.getResource("/textures/rwwarrior.png"));
		}catch(Exception e){}
}
public static BufferedImage king(char team,char tile){

	if(team=='b' && tile=='b')
		img=bbking;
	else if(team=='b' && tile=='w')
		img=wbking;
	else if(team=='w' && tile=='b')
		img=bwking;
	else if(team=='w' && tile=='w')
		img=wwking;
	else if(team=='w' && tile=='k')
		img=blwking;
	else if(team=='b' && tile=='k')
		img=blbking;
	
	if(SyncIt.chance==1){
		if(SyncIt.isEnem)
			img=rbking;
	}else{
		if(SyncIt.isEnem)
			img=rwking;
	}
return img;
}

public static BufferedImage queen(char team,char tile){
BufferedImage img=null;
	if(team=='b' && tile=='b')
		img=bbqueen;
	else if(team=='b' && tile=='w')
		img=wbqueen;
	else if(team=='w' && tile=='w')
		img=wwqueen;
	else if(team=='w' && tile=='b')
		img=bwqueen;
	
	if(SyncIt.chance==1){
		if(SyncIt.isEnem)
			img=rbqueen;
	}else{
		if(SyncIt.isEnem)
			img=rwqueen;
	}

return img;
}


public static BufferedImage elephant(char team,char tile){
BufferedImage img=null;
	if(team=='w' && tile=='w')
		img=wwelephant;
	else if(team=='w' && tile=='b')
		img=bwelephant;
	else if(team=='b' && tile=='w')
		img=wbelephant;
	else if(team=='b' && tile=='b')
		img=bbelephant;
	
	if(SyncIt.chance==1){
		if(SyncIt.isEnem)
			img=rbelephant;
	}else{
		if(SyncIt.isEnem)
			img=rwelephant;
	}
return img;	
}


public static BufferedImage horse(char team,char tile){
BufferedImage img=null;
	if(team=='w' && tile=='w')
		img=wwhorse;
	else if(team=='w' && tile=='b')
		img=bwhorse;
	else if(team=='b' && tile=='w')
		img=wbhorse;
	else if(team=='b' && tile=='b')
		img=bbhorse;
	if(SyncIt.chance==1){
		if(SyncIt.isEnem)
			img=rbhorse;
	}else{
		if(SyncIt.isEnem)
			img=rwhorse;
	}
return img;
}


public static BufferedImage camel(char team,char tile){
	BufferedImage img=null;
	if(team=='w' && tile=='w')
		img=wwcamel;
	else if(team=='w' && tile=='b')
		img=bwcamel;
	else if(team=='b' && tile=='w')
		img=wbcamel;
	else if(team=='b' && tile=='b')
		img=bbcamel;
	
	if(SyncIt.chance==1){
		if(SyncIt.isEnem)
			img=rbcamel;
	}else{
		if(SyncIt.isEnem)
			img=rwcamel;
	}
return img;
}


public static BufferedImage warrior(char team,char tile){
BufferedImage img=null;
	if(team=='w' && tile=='w')
		img=wwwarrior;
	else if(team=='w' && tile=='b')
		img=bwwarrior;
	else if(team=='b' && tile=='w')
		img=wbwarrior;
	else if(team=='b' && tile=='b')
		img=bbwarrior;
	
	if(SyncIt.chance==1){
		if(SyncIt.isEnem)
			img=rbwarrior;
	}else{
		if(SyncIt.isEnem)
			img=rwwarrior;
	}
return img;
}
}














