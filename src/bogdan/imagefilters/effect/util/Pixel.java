package bogdan.imagefilters.effect.util;

public class Pixel {

	private int r,g,b,a;
	
	public Pixel(){
		
	}

	public Pixel(int r,int g,int b,int a){
		
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	
	public Pixel(int r,int g,int b){
		this(r,g,b,100);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public static final Pixel getPixelFromInt(int rgba){
		int a = (rgba >> 24) & 0xff;
		int r = (rgba >> 16) & 0xff;
		int g = (rgba >> 8) & 0xff;
		int b = rgba & 0xff;		
		Pixel p = new Pixel(r, g, b, a);
		
		return p;
	}
	
	public static final int getIntFromPixel(Pixel p){
		int a = p.getA();
		int r = p.getR();
		int g = p.getG();
		int b = p.getB();		
		int rgba = ((a&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
		
		return rgba;
	}
}
