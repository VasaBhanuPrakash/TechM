var item=["Samsung TV","LG TV","Onida TV"];
var price=[45000.53,38000.65,27600.76];
var man=["02-12-2025","01-05-2025","02-06-2025"];
var img=["samsung.webp","onida.webp","lg.webp"];
var day=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
var mon=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var x=prompt("Enter the item name");
for(var i in item){
    if(item[i]==x){
    document.writeln(`<pre><img src="${img[i]}" alt="Image is hidden"></pre>`);
    document.writeln("<pre>"+item[i]+"</pre>");
    document.writeln("<pre>"+price[i]+"</pre>");
    var date=new Date(man[i]);
    document.writeln(`<pre>${date.getDate()} ${day[date.getDay()]}, ${mon[date.getMonth()]} ${date.getFullYear()}</pre>`);
}}