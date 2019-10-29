/*
	학생객체 생성자함수작성				
*/
function Student(id,name,kor,eng,math){
		/*
		1. Student(1,'kim',23,34,78);
		    this --> window
		2. new Student(1,'kim',23,34,78); 
		    2-1. Object객체생성 --> this 
		    2-2. this.property추가
		    2-3. return this;
		*/
		
		this.id=id;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		this.tot=0;
		this.avg=0.0;
		this.calculateTot=function(){
			this.tot=this.kor+this.eng+this.math;
		};
		this.calculateAvg=function(){
			this.avg=this.tot/3.0;
		};
		this.toString=function(){
			return '['+this.id+']'+this.name+','+this.kor+','+this.eng+','+this.math+','+this.tot+','+this.avg;
		}
}
/*
학생객체 패키지 생성자함수작성				
*/
var com={};
com.itwill={};
var Student = function(id,name,kor,eng,math){
	/*
	1. Student(1,'kim',23,34,78);
	    this --> window
	2. new Student(1,'kim',23,34,78); 
	    2-1. Object객체생성 --> this 
	    2-2. this.property추가
	    2-3. return this;
	*/
	
	this.id=id;
	this.name=name;
	this.kor=kor;
	this.eng=eng;
	this.math=math;
	this.tot=0;
	this.avg=0.0;
	this.calculateTot=function(){
		this.tot=this.kor+this.eng+this.math;
	};
	this.calculateAvg=function(){
		this.avg=this.tot/3.0;
	};
	this.toString=function(){
		return '['+this.id+']'+this.name+','+this.kor+','+this.eng+','+this.math+','+this.tot+','+this.avg;
	}
};















