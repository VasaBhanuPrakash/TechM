function fun(){
    let x=prompt("Enter new folder name");
    let newDiv=document.createElement("div");
    newDiv.id="displayDiv";
    newDiv.innerHTML=`
    <p>Folder Created:${x}</p>`;
    document.body.appendChild(newDiv);
}