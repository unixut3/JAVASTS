/*
	학생객체 생성자함수작성	
	 
	 1. prototype이라는 프로퍼티는 그 용도가 약속되어 있는 
		    특수한 프로퍼티다.
	 2. property안에 함수를 정의할수있다   			
*/
function Student(id,name,kor,eng,math){
	
		this.id=id;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		this.tot=0;
		this.avg=0.0;
		this.calcluateTot=function(){
			this.tot=this.kor+this.eng+this.math;
		};
		this.calculateAvg=function(){
			this.avg=this.tot/3.0;
		};
		this.toString=function(){
			return '['+this.id+']'+this.name+','+this.kor+','+this.eng+','+this.math+','+this.tot+','+this.avg;
		}
}





