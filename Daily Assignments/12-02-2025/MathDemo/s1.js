let generatedCode = "";
generatedCode = Math.floor(100000 + Math.random() * 900000); // Generates a 6-digit number
document.getElementById("generatedCode").textContent = `Your Code: ${generatedCode}`;

function generateCode() {
    generatedCode = Math.floor(100000 + Math.random() * 900000); // Generates a 6-digit number
    document.getElementById("generatedCode").textContent = `Your Code: ${generatedCode}`;
}

function verifyCode() {
    let userCode = document.getElementById("userCode").value;
    
    if (userCode === generatedCode.toString()) {
        document.getElementById("result").textContent = "✅ Verification Successful!";
        document.getElementById("result").style.color = "green";
    } else {
        document.getElementById("result").textContent = "❌ Incorrect Code. Try Again!";
        document.getElementById("result").style.color = "red";
    }
}
