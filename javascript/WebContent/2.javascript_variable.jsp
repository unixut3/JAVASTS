<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>javascript variable</h1><hr/>
<script type="text/javascript">
	console.log("console test!!!");
	/*
	변수,리터럴(상수)	
	*/
	var a;
	a = '김경호';
	var aa =new String('김경호');
	
	var b="김경미";
	var c = 123;
	var d = 123.4;
	var e = true;
	
	var f = new Object();
	f.name = '김미려';
	f.age=33;
	var ff = {'name':'김경수','age':34};//JSON
	
	var fff=[34,56,67,78];//JSON
	
	var ffff=new Array();
	ffff.push(34);
	ffff.push(56);
	ffff.push(67);
	ffff.push(78);
	g = 1+2;
	
	var h=null;
	var i;
	window.j = 3.14;
	
	console.log(window.a);
	console.log(window.b);
	console.log(c);
	console.log(d);
	console.log(e);
	console.log(e);
	console.log(f);
	console.log(ff);
	console.log(fff);
	console.log(ffff);
	console.log(g);
	console.log(h);
	console.log(i);
	console.log(j);
	console.log("-----------data type-------------")
	console.log(typeof a);//'김경호'
	console.log(typeof aa);//new String('김경호')
	console.log(typeof b);
	console.log(typeof c);
	console.log(typeof d);
	console.log(typeof e);
	console.log(typeof f);
	console.log(typeof ff);
	console.log(typeof fff);
	console.log(typeof ffff);
	console.log(typeof g);
	console.log(typeof h);
	console.log(typeof i);
	
	var k='문자열';
    var kk = new String('문자열');	
    var l=123;
	var m=true;
	var n;
	var o={};
	var p=null;
	
	if(typeof k=='string'){
		console.log("typeof k=='string'");
	}
	if(typeof l=='number'){
		console.log("typeof l=='number'");
	}
	if(typeof n=='undefined'){
		console.log("n == 'undefined'");
	}
	if(n == undefined){
		console.log("n == undefined");
	}
	if(p==null){
		console.log("p==null");
	}
	console.log(
			"**********값비교 연산자 ==(값이일치), ===(값과 타입까지일치) *********")
	if(k == kk){
		console.log('k == kk');
	}
	if(k === kk){
		console.log('k === kk');
	}
	console.log("--------선언전 사용--------:"+friend);
	var friend='김은희';
	console.log("-------변수타입-->bool로 자동변경-----------");
	var ud;
	var nullVar=null;
	var zeroNumber=0;
	var zeroString='0';
	if(!ud){
		console.log('undefined--> false')
	}
	if(!nullVar){
		console.log('nullVar--> false')
	}
	if(!zeroNumber){
		console.log('zeroNumber--> false')
	}
	if(zeroString){
		console.log('zeroString--> true')
	}
	if('김'){
		console.log('\'김\'-> true');
	}
	if(3232){
		console.log('3232-> true');
	}
	if(34.56){
		console.log('34.56-> true');
	}
	if({}){
		console.log('{}-> true');
	}
	if([]){
		console.log('[]-> true');
	}
	console.log('-----------function type-----------------');
	function func1(){
		console.log('func1()호출');
	}
	console.log(window.func1);
	console.log(window.alert);
	console.log(typeof alert);
	console.log(typeof func1);
	
	//if(window.alert){
	//	window.alert('alert....');
	//}   알람뜨는거
	if(window.func1){
		window.func1();
	}
	var funcVar = func1;
	window.funcVar();
	
	console.log('-------------variable scope[함수{}에 의해서만 형성]--------------------');
	var g1='김수미G';
	var g2 = 0000;
	var g3 = true;
	var g4=3.14;
	
	function func_scope(){
		var g1='김수미L';
		var g2=8888;
		var g3=false;
		g4='로칼에서 전역접근g4';
		var g5 = [1,2,3,4,5,6];
		var g6 = {'id':'xxx','name':'kim'};
		console.log("----------function안에서 local변수---------------");
		console.log(g1);
		console.log(g2);
		console.log(g3);
		console.log(g4);
		console.log(g5);
		console.log(g6);
		console.log("----------function안에서 window변수---------------");
		console.log(window.g1);
		console.log(window.g2);
		console.log(window.g3);
		console.log(window.g4);
		
	} 
	func_scope();
	console.log('----------function밖에서--------------');	
	console.log(g1);
	console.log(g2);
	console.log(g3);
	console.log(g4);
	
	var var1='변수값1';
	var var1='변수값2';
	console.log(var1);
	
	console.log('----------------variable scope[제어문{}에 의해서는 생성되지 않는다]-------------');
	var v1='변수1';
	if(true){
		var v1='if{}안에서 선언1';
		var v2='if{}안에서 선언2';
		console.log(v1);
		console.log(window.v1);
	}
		console.log(v2);
		console.log(window.v2);
	
	
	
	
</script>
</body>
</html>










