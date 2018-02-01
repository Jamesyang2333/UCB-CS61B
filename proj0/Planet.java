public class Planet {
public double xxPos;
public double yyPos;
public double xxVel;
public double yyVel;
public double mass;
public String imgFileName;
public Planet(double xP,double yP, double xV,double yV,double m,String img)
{
xxPos=xP;
yyPos=yP;
xxVel=xV;
yyVel=yV;
mass=m;
imgFileName=img;
}
public Planet(Planet p){
	xxPos=p.xxPos;
yyPos=p.yyPos;
xxVel=p.xxVel;
yyVel=p.yyVel;
mass=p.mass;
imgFileName=p.imgFileName;
}
public double calcDistance(Planet x){
double j;
j=Math.sqrt((xxPos-x.xxPos)*(xxPos-x.xxPos)+(yyPos-x.yyPos)*(yyPos-x.yyPos));
return j;
}
public double calcForceExertedBy(Planet x)
{
double j;
j=6.67e-11*mass*x.mass/calcDistance(x)/calcDistance(x);
return j;
}
public double calcForceExertedByX(Planet x){
double j;
j=calcForceExertedBy(x)*(x.xxPos-xxPos)/calcDistance(x);
return j;

}

public double calcForceExertedByY(Planet x){
double j;
j=calcForceExertedBy(x)*(x.yyPos-yyPos)/calcDistance(x);
return j;

}
public double calcNetForceExertedByX(Planet[] x){
	double j=0;
for(int i=0;i<x.length;i++){
	if(!this.equals(x[i])){
		j=j+calcForceExertedByX(x[i]);

	}

}
return j;
}
public double calcNetForceExertedByY(Planet[] x){
	double j=0;
for(int i=0;i<x.length;i++){
	if(!this.equals(x[i])){
		j=j+calcForceExertedByY(x[i]);

	}

}
return j;
}
public void update(double dt,double Fx,double Fy){

xxVel=xxVel+dt*Fx/mass;
yyVel=yyVel+dt*Fy/mass;
xxPos=xxPos+dt*xxVel;
yyPos=yyPos+dt*yyVel;
}
public void draw(){
	StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);

}
}
