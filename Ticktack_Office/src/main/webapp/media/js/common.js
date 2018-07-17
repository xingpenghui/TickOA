//接收多值
function manyValues(){
var url=window.location.search;
var arr=new Array();
if(url.indexOf("?")!=-1){
	
	var str = url.substr(1);
   strs = str.split("&"); 
   var key=new Array(strs.length);
   var value=new Array(strs.length);
   
   
   
   for(i=0;i<strs.length;i++){
    var arr1=strs[i].split("=");
    var obj=new Object();
    obj.arr1[0]=unescape(arr1[1]);
    
  } 
   
} 
return arr;

}