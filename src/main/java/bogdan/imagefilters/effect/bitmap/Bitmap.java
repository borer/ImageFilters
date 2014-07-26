package bogdan.imagefilters.effect.bitmap;

/***
 * Represents an image. Is used by the filters as an input and output.
 * @author bogdan
 *
 */
public interface Bitmap {
	
	/***
	 * Get the image date as an array of int.Each integer represents a pixel.
	 * @return
	 */
	public int[] getData();
	
	/***
	 * Sets the buffer for the current image.
	 * @param data
	 */
	public void setData(int[] data); //TODO: could be refactored

	/***
	 * Get the start of the data in the pixels array.
	 * @return
	 */
	public int getDataStart();
	
	/***
	 * Gets the end of the data in the pixels array.
	 * @return
	 */
	public int getDataEnd();
	
	public int getHeight();
	
	public int getWidth();
}