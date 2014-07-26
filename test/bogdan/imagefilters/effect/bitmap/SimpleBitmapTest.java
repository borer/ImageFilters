package bogdan.imagefilters.effect.bitmap;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import bogdan.imagefilters.effect.bitmap.SimpleBitmap;

public class SimpleBitmapTest {

	static SimpleBitmap bitmap;
	static int width = 64;
	static int height = 64;
	static String generatedImageFilename;
	static String originalImageFilename;
	
	@BeforeClass
	public static void setUp() {
		generatedImageFilename = "newTestImage.jpg";
		originalImageFilename = "resources/smallLena.jpg";
		bitmap = new SimpleBitmap(originalImageFilename);/*64x64*/
		width = 64;
		height = 64;
	}
	
	@Test
	public void readBitmapFromFile(){
		assertNotNull(bitmap);
		assertEquals(width, bitmap.getWidth());
		assertEquals(height, bitmap.getHeight());
	}
	
	@Test
	public void outputBitmapToFile(){ 
		File imageFile = new File(generatedImageFilename);
						
		assertFalse(imageFile.exists());
		bitmap.writeToFile(generatedImageFilename);		
		assertTrue(imageFile.exists());

		this.cleanImageFile();
	}
	
	private void cleanImageFile(){
		File imageFile = new File(generatedImageFilename);
		if(imageFile.exists())
			imageFile.delete();
	}
	
	@Test
	public void twoEqualsImagesAreActuallyEqual(){
		SimpleBitmap equalImage = new SimpleBitmap(originalImageFilename);
		
		assertTrue(bitmap.equals(equalImage));
	}
	
	@Test
	public void createDeepCopyFromOriginalBitmap(){
		SimpleBitmap duplicateBitmap = (SimpleBitmap) bitmap.duplicate();
		
		assertTrue(bitmap.equals(duplicateBitmap));
	}
	
	
	@Test
	public void bufferDataCorrespondToImageDimensions(){
		assertEquals(0, bitmap.getDataStart());
		assertEquals(width*height, bitmap.getDataEnd());
	}
	
}
