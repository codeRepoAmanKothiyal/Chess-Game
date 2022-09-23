import java.awt.image.BufferedImage;

public class Player {
	public static BufferedImage kingPosition(char team,char p){
		return Elements.king(team,p);
	}
	public static BufferedImage queenPosition(char team,char p){
		return Elements.queen(team,p);
	}
	public static BufferedImage elephantPosition(char team,char p){
		return Elements.elephant(team, p);
	}
	public static BufferedImage horsePosition(char team,char p){
		return Elements.horse(team, p);
	}
	public static BufferedImage camelPosition(char team,char p){
		return Elements.camel(team,p);
	}
	public static BufferedImage warriorPosition(char team,char p){
		return Elements.warrior(team,p);
	}
}
