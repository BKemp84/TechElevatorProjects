const colors = document.getElementById("colors");
colors.addEventListener("click", event => {
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

colors.addEventListener("dblclick", event => {
	if (event.target.nodeName.toLowerCase() === 'li') {
		event.target.style.backgroundColor = 'transparent';
	}

});


function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = document.getElementById('colorpicker').value;
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});