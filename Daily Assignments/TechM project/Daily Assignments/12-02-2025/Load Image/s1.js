function fun(){
    let newDiv=document.createElement("div");
    newDiv.id="displayDiv";
    newDiv.innerHTML=`
    <iframe src="https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcT-4r-04VAGPxBET_6iqWuk0PLIFyQwcjHg8GEjM1UwKMYXOnWK7S4QHeNt8zMBwTIe_735zcZ-HuLo_njCycS8l1PxF-nbSJjM3odOuijggWVnZsl8u4CJMQ" style="width:250px;height:250px;"></iframe>`;
    document.body.appendChild(newDiv);
}