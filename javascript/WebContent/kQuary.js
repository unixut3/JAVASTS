/**
 * 
 */
function hello(fArg,name){
		if(name==undefined){
			name='GUEST';
		}
		var msg = name+" 님 안녕하세요";
		fArg(msg);		
	};
	
function each(array,userCallbackFunc){
		for (var i = 0; i < array.length; i++) {
			userCallbackFunc(i,array[i]);
		}
}