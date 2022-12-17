package com.macro.imagegallery.processing;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageProcessor {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public ImageProcessor(){ }
	
	public Mat BGR2Gray(Mat srcimg) {
		Mat retimg = null;
		Imgproc.cvtColor(srcimg, retimg, Imgproc.COLOR_BGR2GRAY);
		return retimg;
	}
	
	// For Unit Test
	public static void main(String[] args) {
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
	}
	
}
