package com.vflux.docproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * App for document matching
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	//
		// Prepare the resumes for matching
		//
		String cv1 = "I am a Full-Stack developer with a Master of Science (M.S.) in Information Technology and 3 years of software development experience. I am experienced in web, mobile and desktop development with many technologies using HTML5, CSS3, JavaScript, NodeJs, MongoDB, AngularJs, MeteorJs, python, MySQL and IONIC Framework. I have a working experience with Model View Controller (MVC), and have been involved in maintaining versions of source code using GIT. I have also designed and developed web user controls, master pages, validation controls, LESS files using technologies like AJAX Toolkit, JQuery. When working on a new project, I like to speak with my clients so that I can have a clear understanding of their needs and vision of the project. Thank you in advance for your time and consideration. I look forward to working with you soon.";
		String cv2 = "I am Swarna, a passionate web developer. I love to create websites using HTML5, CSS3, javascript, jquery and client side frameworks like bootstrap, materialize. I feel that meteor is an amazing framework that makes it really easy to build real time web applications with simple web technologies like Java script and HTML. Here is my meteor app Tutorial Hunt - http://tutorialhunt.meteor.com/, recently featured on Product Hunt and received 320+ upvotes.";
		List<String> resumes = new ArrayList<String>();
		resumes.add(cv1);
		resumes.add(cv2);
		//
		// Match CVs to the job description
		//
		String jobdescr = "The person should have worked on multiple web development projects based on technologies such as MongoDB, NodeJS, MeteorJS, HTML5, CSS3";
		String transformedJobDescr = Stopwords.removeStemmedStopWords(jobdescr);
		System.out.println(transformedJobDescr);
		for(String resume: resumes) {
			//
			// Clean CV of stemmed and stop words
			//
			String transformedText = Stopwords.removeStemmedStopWords(resume);
			System.out.println(transformedText);
			//
			// Match the resume with the job description
			//
			double similarity = CosineDocumentSimilarity.getCosineSimilarity(transformedJobDescr, transformedText);
			System.out.println(similarity);
		}
    }
}
