package bogdan.imagefilters.effect;

import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bogdan.imagefilters.effect.bitmap.Bitmap;
import bogdan.imagefilters.effect.bitmap.SimpleBitmap;
import bogdan.imagefilters.effect.executor.EffectExecutor;
import bogdan.imagefilters.effect.executor.MultiThreadEffectExecutor;
import bogdan.imagefilters.effect.executor.SingleThreadEffectExecutor;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//testAllFilters();

		String imageName = "imageTests/anni.jpg";
		Bitmap original = new SimpleBitmap(imageName);
		Effect ef = EffectLibrary.Anna2();
		
		EffectExecutor ex = new SingleThreadEffectExecutor();
		//EffectExecutor ex = new MultiThreadEffectExecutor();
		ex.execute(ef, original);		
		
		Bitmap newImage = ex.getNewImage();
		((SimpleBitmap)newImage).writeToFile("newfileTest.jpg");
		
		//printAllARGBDetails(image);
		
		System.exit(0);
	}
	
	@SuppressWarnings("unused")
	private static void testAllFilters(){
		String imageName = "resources/smallLena.jpg";
		try {
			Class<?> effectLibrary = Class.forName("org.bogdan.effect.EffectLibrary");
			Method[] effects = effectLibrary.getDeclaredMethods();
			for(Method effect : effects){
				//BufferedImage image = readImage(imageName);
				Bitmap original = new SimpleBitmap(imageName);
				
				Effect ef = (Effect) effect.invoke(null, (Object[])null);
				//EffectExecutor ex = new SingleThreadEffectExecutor();
				EffectExecutor ex = new MultiThreadEffectExecutor();
				ex.execute(ef, original);		
				Bitmap newImage = ex.getNewImage();
				String fileName = String.format("resources/bitmapTestResults/%sLena.jpg", effect.getName());
				((SimpleBitmap)newImage).writeToFile(fileName);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Call the method that prints out ARGB color Information. ARGB = Alpha,
	 * Red, Green and Blue
	 */
	public static void printAllARGBDetails(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		System.out.println("Image Dimension: Height-" + height + ", Width-"
				+ width);
		System.out.println("Total Pixels: " + (height * width));
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

				int pixel = image.getRGB(i, j);
				System.out.println("Pixel Location(" + i + "," + j + ")- ["
						+ getARGBPixelData(pixel) + "]");
			}
		}
	}

	/**
	 * Image Pixels are Arrays of Integers [32 bits/4Bytes] Consider a 32 pixel
	 * as 11111111-00110011-00111110-00011110
	 * 
	 * First Byte From Left [11111111]= Alpha Second Byte From Left[00110011]=
	 * Red Third Byte From Left [00111110]= Green Fourth Byte From
	 * Left[00011110]= Blue
	 * 
	 * The following method will do a proper bit shift and logical AND operation
	 * to extract the correct values of different color/alpha components.
	 * 
	 */
	public static String getARGBPixelData(int pixel) {
		String pixelARGBData = "";
		/**
		 * Shift all pixels 24 bits to the right. Do a logical and with
		 * 0x000000FF i.e. 0000 0000 0000 0000 0000 0000 1111 1111 You will get
		 * the alpha value for the pixel
		 */
		int alpha = (pixel >> 24) & 0x000000FF;

		/**
		 * Shift all pixels 16 bits to the right. Do a logical and with
		 * 0x000000FF i.e. 0000 0000 0000 0000 0000 0000 1111 1111 You will get
		 * the red value for the pixel
		 */

		int red = (pixel >> 16) & 0x000000FF;

		/**
		 * Shift all pixels 8 bits to the right. Do a logical and with
		 * 0x000000FF i.e. 0000 0000 0000 0000 0000 0000 1111 1111 You will get
		 * the green value for the pixel
		 */
		int green = (pixel >> 8) & 0x000000FF;

		/**
		 * Dont do any shift. Do a logical and with 0x000000FF i.e. 0000 0000
		 * 0000 0000 0000 0000 1111 1111 You will get the blue value for the
		 * pixel
		 */
		int blue = (pixel) & 0x000000FF;

		pixelARGBData = "Alpha: " + alpha + ", " + "Red: " + red + ", "
				+ "Green: " + green + ", " + "Blue: " + blue;

		return pixelARGBData;
	}
}
