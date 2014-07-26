package bogdan.imagefilters.effect.executor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.executor.EffectExecutor;
import bogdan.imagefilters.effect.executor.SingleThreadEffectExecutor;


public class SingleThreadEffectExecutorTest {

	private EffectExecutor executor;
	
	@Before
	public void setup(){
		this.executor = new SingleThreadEffectExecutor();
	}
	
	@Test
	public void runSingleThreadExecutor() {
		Effect effect = mock(Effect.class);
		Bitmap bitmap = mock(Bitmap.class);
		when(effect.applay(bitmap)).thenReturn(bitmap);
		
		this.executor.execute(effect, bitmap);
		
		//verify(effect).applay(bitmap);
		assertNotNull(this.executor.getNewImage());
		assertTrue(this.executor.isDone());
	}

}
