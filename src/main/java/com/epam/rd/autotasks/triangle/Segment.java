package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
	public Point start;
	public Point end;

    public Segment(Point start, Point end) {
    	if(start.equalTo(end) == false) {
    		this.start = start;
    		this.end = end;
    	}
    	else {
    		throw new IllegalArgumentException("The start and end points can not be the same");
    	}
    }

    double length() {
    	double d = sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
    	return d;
    }

    Point middle() {
    	double xMiddle = (start.getX() + end.getX()) / 2;
    	double yMiddle = (start.getY() + end.getY()) / 2;
    	
    	Point pMiddle = new Point(xMiddle, yMiddle);
    	return pMiddle;
    }

    Point intersection(Segment another) {
    	double denominator = ((this.start.getX() - this.end.getX()) * (another.start.getY()-another.end.getY())) - ((this.start.getY()-this.end.getY()) * (another.start.getX() - another.end.getX()));
    	if(denominator == 0) {
    		return null;
    	}
    	else {
    		double t = (((this.start.getX() - another.start.getX())*(another.start.getY()-another.end.getY())) - ((this.start.getY()-another.start.getY())*(another.start.getX()-another.end.getX())))/denominator;
    		double u = (((this.start.getX() - another.start.getX())*(this.start.getY() - this.end.getY()))-((this.start.getY() - another.start.getY())*(this.start.getX() - this.end.getX())))/denominator;
    		
    		if(t >= 0 && t <= 1 && u >= 0 && u <= 1) {
    			double xInter = this.start.getX() + (t * (this.end.getX() - this.start.getX()));
    			double yInter = this.start.getY() + (t * (this.end.getY() - this.start.getY()));
    			Point pInter = new Point(xInter, yInter);
    			return pInter;
    		}
    		else {
    			return null;
    		}
    	}
    }
}
