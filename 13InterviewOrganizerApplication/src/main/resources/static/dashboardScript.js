// Sidebar Burger Toggle Logic
document.addEventListener("DOMContentLoaded", () => {
  const burger = document.getElementById('burger');
  const menu = document.getElementById('menu');


  burger.onclick = () => {
    menu.classList.toggle('show');

    burger.innerHTML = burger.innerHTML === '☰' ? '✖' : '☰';
  };


  // Person icon dropdown toggle
  userIcon.onclick = () => {
    dropdownMenu.classList.toggle('show');
  };

  // Optional: Hide dropdown if clicked outside
  document.addEventListener('click', function (e) {
    if (!userIcon.contains(e.target)) {
      dropdownMenu.classList.remove('show');
    }
  });
});