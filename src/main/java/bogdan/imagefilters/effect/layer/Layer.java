package bogdan.imagefilters.effect.layer;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.filter.Filter;
import bogdan.imagefilters.effect.util.Color;
import bogdan.imagefilters.effect.util.Pixel;
import bogdan.imagefilters.effect.util.Utils;

public abstract class Layer implements Filter{
	
	public enum LayerMergeMode {
		BOTTOM,
		TOP
	};
	
	private Bitmap filter;
	private LayerMergeMode mergeMode;
	
	public Layer(Bitmap filter) {
		this(filter, LayerMergeMode.TOP);
	}
	
	public Layer(Bitmap filter, LayerMergeMode mode){
		this.filter = filter;
		this.mergeMode = mode;
	}
	
	@Override
	public Bitmap apply(Bitmap image){
		
		int[] bottomData;
		int[] topData;
		int h,w;
		
		if(this.mergeMode == LayerMergeMode.TOP){
			bottomData = image.getData();
			topData = this.filter.getData();
			
			h = Math.min(image.getHeight(),this.filter.getHeight());
			w = Math.min(image.getWidth(), this.filter.getWidth());
			
		} else {
			bottomData = this.filter.getData();
			topData = image.getData();
			
			h = Math.min(this.filter.getHeight(),image.getHeight());
			w = Math.min(this.filter.getWidth(), image.getWidth());
		}

		
		int i=0,j=0,index=0;
		Pixel brgba =new Pixel();
		Pixel trgba =new Pixel();
		
		for (i = 0; i < h; i++) {
            for (j = 0; j < w; j++) {
            	index = (i*w) + j;
                
                brgba.setR( Color.red(bottomData[index]) );
                brgba.setG( Color.green(bottomData[index]) );
                brgba.setB( Color.blue(bottomData[index]) );
                brgba.setA( Color.alpha(bottomData[index]) );
                
                trgba.setR( Color.red( topData[index]) );
                trgba.setG( Color.green( topData[index]) );
                trgba.setB( Color.blue( topData[index]) );
                trgba.setA( Color.alpha( topData[index]) );
                
                // Execute blend.
                Pixel newPixel = this.process(brgba, trgba);
                
                // Re-assign data.
                /*bottomData[index]     = Utils.clamp(newPixel.getR());
                bottomData[index + 1] = Utils.clamp(newPixel.getG());
                bottomData[index + 2] = Utils.clamp(newPixel.getB());
                bottomData[index + 3] = Utils.clamp(newPixel.getA());*/
                
                bottomData[index] = Color.colorToInt(Utils.clamp( newPixel.getR() ),
                		Utils.clamp( newPixel.getG() ),
                		Utils.clamp( newPixel.getB() ),
                		Utils.clamp( newPixel.getA() ) );         
            }
		}
				
		image.setData(bottomData);

		return image;
	}
	
	public abstract Pixel process(Pixel brgba,Pixel trgba);


	public LayerMergeMode getMergeMode() {
		return mergeMode;
	}


	public void setMergeMode(LayerMergeMode mergeMode) {
		this.mergeMode = mergeMode;
	}
}
