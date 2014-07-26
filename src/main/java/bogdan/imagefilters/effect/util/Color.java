package bogdan.imagefilters.effect.util;

public class Color {

	static public int alpha(int color){
		return (color >> 24) & 0x000000FF;
	}
	
	static public int red(int color){
		return (int)((color >> 16) & 0x000000FF);
	}
	
	static public int green(int color){
		return (int)((color >>8 ) & 0x000000FF);
	}
	
	public static int blue(int color){
		return (int)((color) & 0x000000FF);
	}
	
	static public int colorToInt(int R,int G,int B,int A){
		//int color = (int)( (A << 24) | (R << 16) | (G << 8) | B);
		
		int color = ((A&0x0ff)<<24)|((R&0x0ff)<<16)|((G&0x0ff)<<8)|(B&0x0ff);
		
		return color;
	}
	
}
