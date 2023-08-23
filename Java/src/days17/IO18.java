package days17;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Point implements Serializable{
	private int x; 	
	private int y;
	public Point(int x, int y) {
		this.x = x;this.y = y;	
	}
	public String toString() {	
		return "(x:"+ this.x + ",y:" + this.y + ")";
	}
}

public class IO18 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File d = new File("d:\\java01\\java_se\\temp");
		if( !d.exists() ) d.mkdirs();
		File file = new File( d, "Point.dat");
		
		ObjectInputStream ois 
		= new ObjectInputStream( new BufferedInputStream( new FileInputStream( file )  ) ); 
		
		ArrayList<Point> list = (ArrayList<Point>) ois.readObject();
		int i = 1;
		for( Point p : list ) {
			System.out.printf("%s  ", p.toString() );
			if( i++ % 7 == 0 )System.out.println();
		}

	}

}










