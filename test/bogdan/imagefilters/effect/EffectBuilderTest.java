package bogdan.imagefilters.effect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.EffectBuilder;
import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.layer.Layer;

public class EffectBuilderTest {

	EffectBuilder effectBuilder;
	
	@Before
	public void setup(){
		this.effectBuilder = new EffectBuilder();
	}
	
	@Test 
	public void constructEffectWithOneFilter(){
		int alphaValue = 2;
		Effect effect = this.effectBuilder.alpha(alphaValue).getEffect();
		
		assertNotNull(effect);
		assertEquals(1, effect.getNumberFilters());
	}
	
	@Test 
	public void createEffectWithAllFilters(){
		Bitmap testImage = Mockito.mock(Bitmap.class); 
		Layer.LayerMergeMode layerMode = Layer.LayerMergeMode.BOTTOM;
		Effect effect = this.effectBuilder
				.adjust(0, 0, 0)
				.alpha(0)
				.apollo()	
				.bluebw()
				.blur(1)
				.brighten(0)
				.contrast(0)
				.earlyBird()
				.expose(0)
				.fill(0, 0, 0)
				.gamma(0)
				.gotham()
				.xpro()
				.walden()
				.tritone(0, 0, 0)
				.toaster()
				.substract(0, 0, 0)
				.sharpen()
				.sepia()
				.saturate(0)
				.redbw()
				.posterize(0)
				.ninthenSeventeSeven()
				.lordKevin()
				.lomo()
				.invert()
				.hefe()
				.hashVille()
				.grey()
				.layerAddition(testImage, layerMode)
				.layerDifference(testImage, layerMode)
				.layerExclusion(testImage, layerMode)
				.layerMultiply(testImage, layerMode)
				.layerOverlay(testImage, layerMode)
				.layerScreen(testImage, layerMode)
				.layerSoftLight(testImage, layerMode)
				.getEffect();
		
		assertEquals(36, effect.getNumberFilters());
	}

}
