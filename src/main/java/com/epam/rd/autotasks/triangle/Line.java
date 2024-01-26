package com.epam.rd.autotasks.triangle;
import static java.lang.Math.*;

public class Line {
	public double m;
	public double b;
	public boolean vertical = false;
	public double verticalX;
	
    public Line(double m, double b) {
    	this.m = m;
    	this.b = b;
    }
    
    public Line(Segment seg) {
    	this(seg.start, seg.end);
    }
    
    public Line(Point p1, Point p2) {
    	if((p2.getX()-p1.getX()) == 0) {
    		this.vertical = true;
    		this.verticalX = p1.getX();
    		this.m = 0;
    		this.b = 0;
    	}
    	else {
    		this.m = (double) ((p2.getY()-p1.getY())/(p2.getX()-p1.getX()));
        	this.b = (double) (p1.getY() - (this.m * p1.getX()));
    	}
    }

    public Point intersection(Line other) {
    	
    	if(this.vertical == false && other.vertical == false) {
    		if(this.m == other.m) {
        		return null;
        	}
        	else {
        		double x = (other.b - this.b)/(this.m - other.m);
        		double y = (this.m * x) + this.b;
            	
            	Point intersec = new Point(x,y);
            	return intersec;
        	}
    	}
    	else if(this.vertical == true && other.vertical == false) {
    		double y = (other.m * this.verticalX) + other.b;
    		
    		Point intersec = new Point(this.verticalX,y);
        	return intersec;
    	}
    	else if(this.vertical == false && other.vertical == true) {
    		double y = (this.m * other.verticalX) + this.b;
    		
    		Point intersec = new Point(other.verticalX,y);
        	return intersec;
    	}
    	else {
    		return null;
    	}
        
    }
    
    public double distPoint(Point p) {
    	if(this.vertical == false) {
    		double d = abs((this.m * p.getX()) - p.getY() + this.b)/sqrt(pow(m,2) + 1);
        	return d;
    	}
    	else {
    		double d = abs(p.getX()- this.verticalX);
    		return d;
    	}
    }
    
    public double getM() {
    	return this.m;
    }
    
    public double getB() {
    	return this.b;
    }
}
