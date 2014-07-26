package bogdan.imagefilters.effect;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.filter.Filter;

public class EffectTest {

	Effect effect;
	Bitmap originalImage;
	
	@Before
	public void setup() {
		this.effect = new Effect();
		this.originalImage = mock(Bitmap.class);
	}
	
	@Test
	public void EmptuEffectIsCreated(){
		assertEquals(0, effect.getNumberFilters());
	}
	
	@Test
	public void addOneFilterToEffect() {
		Filter filter = mock(Filter.class);
		effect.addFilter(filter);
		
		assertEquals(1, effect.getNumberFilters());
	}
	
	@Test
	public void applyEffectWithOneFilter(){
		Filter filter = mock(Filter.class);
		effect.addFilter(filter);
		effect.applay(this.originalImage);
		
		verify(filter).apply(originalImage);
	}

	@Test(expected = RuntimeException.class)
	public void throwException_WhenApplyingNullImageToEffect(){
		effect.applay(null);
	}
	
	@Test
	public void addOneBeforeEffectToEffect(){
		Effect beforeEffect = mock(Effect.class);
		effect.addBeforeEffect(beforeEffect);
		
		assertEquals(1, effect.getNumberBeforeEffects());
	}
	
	@Test
	public void applyOneBeforeEffect(){
		Effect beforeEffect = mock(Effect.class);
		effect.addBeforeEffect(beforeEffect);
		effect.applay(originalImage);
		
		verify(beforeEffect).applay(originalImage);
	}
	
	@Test
	public void addOneAfterEffectToEffect(){
		Effect afterEffect = mock(Effect.class);
		effect.addAfterEffect(afterEffect);
		
		assertEquals(1, effect.getNumberAfterEffects());
	}

	@Test
	public void applyOneAfterEffect(){
		Effect afterEffect = mock(Effect.class);
		effect.addAfterEffect(afterEffect);
		effect.applay(originalImage);
		
		verify(afterEffect).applay(originalImage);
	}
}
