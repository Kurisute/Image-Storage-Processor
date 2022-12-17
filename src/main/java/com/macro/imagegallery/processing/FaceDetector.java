package com.macro.imagegallery.processing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class FaceDetector {
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	private CascadeClassifier faceCascade;
	private int absoluteFaceSize;
	
	public FaceDetector() {
		this.faceCascade = new CascadeClassifier();
		this.absoluteFaceSize = 0;
	}
	
	public void loadCascadeClassifier(String classifierpath) {
		this.faceCascade.load(classifierpath);
	}
	
	public MatOfRect detect(Mat frame) {
		MatOfRect faces = new MatOfRect();
		Mat grayFrame = new Mat();
		
		Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
		Imgproc.equalizeHist(grayFrame, grayFrame);
		
		if (this.absoluteFaceSize == 0){
			int height = grayFrame.rows();
			if (Math.round(height * 0.2f) > 0){
				this.absoluteFaceSize = Math.round(height * 0.2f);
			}
		}
		
		this.faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE,
				new Size(this.absoluteFaceSize, this.absoluteFaceSize), new Size());
		
		return faces;
	}
	
	public Mat drawDetection(Mat frame, MatOfRect faces) {
		Rect[] facesArray = faces.toArray();
		for (int i = 0; i < facesArray.length; i++)
			Imgproc.rectangle(frame, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0), 3);
		return frame;
	}
	
	// Unit Test
	public static void main(String[] args) {
		String envRootDir = System.getProperty("user.dir");
		System.out.println(envRootDir);
		String sampleDir = envRootDir + "\\sample";
		Mat testimg = Imgcodecs.imread(sampleDir + "\\face_sample.jpg");
		FaceDetector facedetector = new FaceDetector();
		System.out.println(envRootDir + "\\detection_model\\haarcascade_frontalface_alt.xml");
		facedetector.loadCascadeClassifier(envRootDir + "\\detection_model\\haarcascade_frontalface_alt.xml");
		MatOfRect face_region = facedetector.detect(testimg);
		Mat retimg = facedetector.drawDetection(testimg, face_region);
		Imgcodecs.imwrite(sampleDir + "\\face_detected.jpg", retimg);
	}
	
	
}
