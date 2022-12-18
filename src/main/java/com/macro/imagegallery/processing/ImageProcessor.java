package com.macro.imagegallery.processing;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageProcessor {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public ImageProcessor(){ }
	
	public static Mat RGB2Gray(Mat srcimg) {
		Mat retimg = srcimg;
		Imgproc.cvtColor(srcimg, retimg, Imgproc.COLOR_RGB2GRAY);
		return retimg;
	}
	
	public static Mat bytes2Mat(byte[] imgbytes) {
		Mat imagemat = Imgcodecs.imdecode(new MatOfByte(imgbytes), Imgcodecs.IMREAD_UNCHANGED);
		return imagemat;
	}
	
	public static byte[] mat2Byte(Mat imgmat) {
		MatOfByte mob = new MatOfByte();
		Imgcodecs.imencode(".jpg", imgmat, mob);
		return mob.toArray();
	}
	
	// For Unit Test
	public static void main(String[] args) {
		Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
	}
	
}
