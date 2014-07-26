package bogdan.imagefilters.effect.executor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

import bogdan.imagefilters.effect.Effect;
import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.executor.EffectExecutor;
import bogdan.imagefilters.effect.executor.MultiThreadEffectExecutor;

public class MultiThreadEffectExecutorTest {

	private static EffectExecutor executor;
	
	@BeforeClass
	public static void setup(){
		executor = new MultiThreadEffectExecutor();
	}
	
	@Test
	public void runMultiThreadExecutor() {
		Effect effect = mock(Effect.class);
		Bitmap bitmap = mock(Bitmap.class);
		when(bitmap.getData()).thenReturn(new int[100]);
		
		executor.execute(effect, bitmap);
	
		assertNotNull(executor.getNewImage());
		assertTrue(executor.isDone());
	}
}
