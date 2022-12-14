import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class ImageProcessor {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	ImageProcessor(){ }
	
	
	
	
	// For Unit Test
	public static void main(String[] args) {
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
	}
	
}
