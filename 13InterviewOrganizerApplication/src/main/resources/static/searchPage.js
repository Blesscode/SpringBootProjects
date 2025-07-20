
  function setStatus(status) {
	console.log("Selected Status:", status);
	document.getElementById("statusInput").value = status;
	document.getElementById("statusButtonText").textContent = status;
  }

  function setGender(gender) {
	document.getElementById("genderInput").value = gender;
	document.getElementById("genderButton").textContent = gender;
  }
