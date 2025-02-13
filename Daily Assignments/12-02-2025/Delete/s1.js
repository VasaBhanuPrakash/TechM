x=prompt("Enter the name of the item:");
var item=["TV","Car","Bike","AC"];
var price=[54560.56,276500.64,99999.99,83000];
for(i in item){
    if(item[i]==x){
        document.writeln(`<pre>Name:${x}</pre>`);
        document.writeln(`<pre>Price:${price[i]}</pre>`);
    }
}