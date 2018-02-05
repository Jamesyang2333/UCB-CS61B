class intlist{
	int first;
	intlist rest;
	public intlist(int first, intlist rest){
		this.first = first;
		this.rest = rest;
	}
	public void addfirst(int a){
		intlist temp = this;
		temp = new intlist(a, temp);
		this.rest = temp;
		this.first = a;
	}
	public static void main(String[] args){
		intlist a = new intlist(10, null);
		a.addfirst(100);
		System.out.println(a.first);
	}
}