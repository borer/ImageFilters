package bogdan.imagefilters.effect.bitmap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.bitmap.BitmapSplitter;
import bogdan.imagefilters.effect.bitmap.SimpleBitmap;

public class BitmapSplitterTest {
	
	private BitmapSplitter bitmapSpplitter;
	
	@Before
	public void setup(){
		this.bitmapSpplitter = new BitmapSplitter();
	}
	
	@Test
	public void splitBitmapInTenChunks() {
		Bitmap bitmap = mock(SimpleBitmap.class);
		when(bitmap.getData()).thenReturn(new int[100]);
		int numberOfChunks = 10;
		
		List<Bitmap> bitmapChunks = this.bitmapSpplitter.splitBitmap(bitmap, numberOfChunks);
		
		assertEquals(numberOfChunks, bitmapChunks.size());
	}
}
