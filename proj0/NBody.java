public class NBody {
public static double readRadius(String s){
	In in=new In(s);
	in.readInt();
	double radius=in.readDouble();
	return radius;
}
public static Planet[] readPlanets(String s){

	In in=new In(s);
	int n;
	n=in.readInt();
	Planet[] result=new Planet[n];
	in.readDouble();
for(int i=0;i<n;i++){
result[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
}
return result;
}
public static void main(String[] args){
double T=Double.parseDouble(args[0]);
double dt=Double.parseDouble(args[1]);
String filename=args[2];
double radius=readRadius(filename);
Planet[] allplanets=readPlanets(filename);
StdDraw.setScale(-radius,radius);
StdDraw.clear();
double time=0;
while(time<T){
	double[] xForces=new double[allplanets.length];
	double[] yForces=new double[allplanets.length];
for(int i=0;i<allplanets.length;i++){
xForces[i]=allplanets[i].calcNetForceExertedByX(allplanets);
yForces[i]=allplanets[i].calcNetForceExertedByY(allplanets);
}
for(int i=0;i<allplanets.length;i++){
	allplanets[i].update(dt,xForces[i],yForces[i]);
}
StdDraw.picture(0,0,"images/starfield.jpg");
for(int i=0;i<allplanets.length;i++){
	allplanets[i].draw();
}
StdDraw.show(10);
time+=dt;
}
}}
