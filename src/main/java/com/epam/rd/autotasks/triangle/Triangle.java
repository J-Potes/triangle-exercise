package com.epam.rd.autotasks.triangle;

class Triangle {
	private Point a;
	private Point b;
	private Point c;
	private Segment segA;
	private Segment segB;
	private Segment segC;
	
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        
        this.segA = new Segment(b, c);
        this.segB = new Segment(a, c);
        this.segC = new Segment(a, b);
        
        Line l1 = new Line(this.segC);
        
        if(this.c.isInLine(l1) == true) {
        	throw new IllegalArgumentException("The triangle does not exists, all vertices are in the same line");
        }
    }
    
    public Triangle(double ax, double ay, double bx, double by, double cx, double cy) {
    	this(new Point(ax,bx), new Point(bx,by), new Point(cx,cy));
    }

    public double area() {
        Line lineSegA = new Line(this.segA);
        double area = this.segA.length() * lineSegA.distPoint(this.a) / 2;
        return area;
    }

    public Point centroid(){
        Segment segMidB = new Segment(this.b, this.segB.middle());
        Segment segMidC = new Segment(this.c, this.segC.middle());
        
        return segMidB.intersection(segMidC);
    }

}
