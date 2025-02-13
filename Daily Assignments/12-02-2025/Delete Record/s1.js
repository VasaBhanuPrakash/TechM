function click1(){
    if(confirm("Record will be Deleted, are you sure?")){
        var x=document.getElementById("c1");
        x.style.visibility="visible";
    }
    else{
        alert("Action Cancelled");
    }
}