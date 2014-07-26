package bogdan.imagefilters.effect.filter;

import bogdan.imagefilters.effect.util.Color;
import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;


public class Tritone extends AbstractFilter {

	private int shadows,midtones,highlights;
	private int[] colors;
	
	public Tritone(int shadows, int midtones, int highlights) {
		this.shadows = shadows;
		this.midtones = midtones;
		this.highlights = highlights;
		
		this.calculateColorTable();
	}
	
	private void calculateColorTable(){
		this.colors = new int[256];
        for ( int k = 0; k < 128; k++ ) {
            float t = k / 127.0f;
            this.colors[k] = Utils.mixColors( t, this.shadows, this.midtones );
        }
        for ( int k = 128; k < 256; k++ ) {
            float t = (k-127) / 128.0f;
            this.colors[k] = Utils.mixColors( t, this.midtones, this.highlights );
        }
	}
	
	@Override
	public Pixel process(Pixel pixel){
		int rgba =  this.colors[Utils.brightness(pixel)];
		pixel.setR(Color.red(rgba));
		pixel.setG(Color.green(rgba));
		pixel.setB(Color.blue(rgba));
		
		return pixel;
	}

}
