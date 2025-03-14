var x=parseInt(prompt("Enter no less than 10"));
switch(x){
    case 1:{
        console.log("Chosen correct number");
        break;
    }
    default:{
        if(x<10){
            console.warn("Chosen wrong number");
        }
        else{
            console.error("Choose a number below 10");
        }
    }
}