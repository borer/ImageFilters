package bogdan.imagefilters.effect;

import java.util.ArrayList;
import java.util.List;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.filter.Filter;

/**
 * Groups filters in one place ,so when the filters are applied the act as an effect.
 * The filters are applied in the order they are added to the effect.
 * WARNING: the order of the filters matter for the execution of the effect.  
 * @author bogdan
 * 
 */
public class Effect {

	private List<Filter> filters;
	private List<Effect> beforeEffects;
	private List<Effect> afterEffects;

	public Effect() {
		this.filters = new ArrayList<Filter>();
		this.beforeEffects = new ArrayList<Effect>();
		this.afterEffects = new ArrayList<Effect>();
	}
	
	public void addBeforeEffect(Effect ef){
		this.beforeEffects.add(ef);
	}
	
	public void addAfterEffect(Effect ef){
		this.afterEffects.add(ef);
	}
	
	public int getNumberBeforeEffects(){
		return this.beforeEffects.size();
	}
	
	public int getNumberAfterEffects(){
		return this.afterEffects.size();
	}
	
	public void removeFilter(Filter filter){
		this.filters.remove(filter);
	} 

	public void addFilter(Filter filter){
		this.filters.add(filter);
	}
	
	public int getNumberFilters(){
		return this.filters.size();
	}
	
	/**
	 * Applies all the filters of the effect sequentially.
	 * @param image
	 * @return
	 */
	public Bitmap applay(Bitmap image){
		if(image == null) throw new RuntimeException("Image is null.");
		
		this.applayBeforeEffects(image);
		this.applayFilters(image);
		this.applayAfterEffects(image);

		return image;
	}
	
	private Bitmap applayBeforeEffects(Bitmap bitmap){
		for(Effect effect: this.beforeEffects){
			bitmap = effect.applay(bitmap);
		}
		
		return bitmap;
	}
	
	private Bitmap applayFilters(Bitmap bitmap){
		for(Filter filter : this.filters){
			bitmap = filter.apply(bitmap);
		}
		
		return bitmap;
	}
	
	private Bitmap applayAfterEffects(Bitmap bitmap){
		for(Effect effect: this.afterEffects){
			bitmap = effect.applay(bitmap);
		}
		
		return bitmap;
	}
	
	/**
	 * Creates a copy of this effect and returns it. The newly created effect
	 * contains references to the filters in the originals filters, so no memory is
	 * wasted.
	 * @return
	 */
	/*public Effect duplicate(){
		Effect duplicateEffect = new Effect();
		
		for(Filter filter : this.filters){
			duplicateEffect.addFilter(filter);
		}
		
		return duplicateEffect;
	}*/
}
