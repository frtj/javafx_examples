package com.myown.app.javafx_examples;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MyUtil {
	
	public InputStream getFileAsInputStream( String path ) throws FileNotFoundException
	{
		// rippoff from spring...
		ClassLoader classLoader = null;
		InputStream is = null;
		try {
			classLoader = Thread.currentThread().getContextClassLoader();
		}
		catch (Throwable ex) {
			// Cannot access thread context ClassLoader - falling back to system class loader...
		}
		if (classLoader == null) {
			// No thread context class loader -> use class loader of this class.
			classLoader = MyUtil.class.getClassLoader();
		}
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		if( classLoader != null )
			is = classLoader.getResourceAsStream(path);
		else
			throw new RuntimeException( "could not get classloader ("+path+")" );
		if (is == null) {
			throw new FileNotFoundException( path + " cannot be opened because it does not exist");
		}
		return is;
	}
}
